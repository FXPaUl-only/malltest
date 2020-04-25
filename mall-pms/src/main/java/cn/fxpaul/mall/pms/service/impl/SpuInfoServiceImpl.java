package cn.fxpaul.mall.pms.service.impl;

import cn.fxpaul.core.bean.PageVo;
import cn.fxpaul.core.bean.QueryCondition;
import cn.fxpaul.mall.pms.dao.*;
import cn.fxpaul.mall.pms.entity.*;
import cn.fxpaul.mall.pms.entity.vo.ProductAttrValueVO;
import cn.fxpaul.mall.pms.entity.vo.SkuInfoVO;
import cn.fxpaul.mall.pms.entity.vo.SpuInfoVO;
import cn.fxpaul.mall.pms.feign.SkuSaleFeign;
import cn.fxpaul.mall.pms.service.*;
import cn.fxpaul.mall.sms.dto.SkuSaleDTO;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.fxpaul.core.bean.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;


@Service("spuInfoService")
public class SpuInfoServiceImpl extends ServiceImpl<SpuInfoDao, SpuInfoEntity> implements SpuInfoService {

    @Autowired
    private SpuInfoDescDao spuInfoDescDao;

    @Autowired
    private ProductAttrValueService productAttrValueService;

    @Autowired
    private SkuInfoDao skuInfoDao;

    @Autowired
    private SkuImagesService skuImagesService;

    @Autowired
    private AttrDao attrDao;

    @Autowired
    private SkuSaleAttrValueService skuSaleAttrValueService;

    @Autowired
    private SpuInfoDescService spuInfoDescService;


    @Autowired
    private SkuSaleFeign skuSaleFeign;

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<SpuInfoEntity> page = this.page(
                new Query<SpuInfoEntity>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageVo(page);
    }

    @Override
    public PageVo querySpuInfo(QueryCondition condition, Long catId) {
        // 封装分页条件
        IPage<SpuInfoEntity> page = new Query<SpuInfoEntity>().getPage(condition);

        // 封装查询条件
        QueryWrapper<SpuInfoEntity> wrapper = new QueryWrapper<>();
        // 如果分类id不为0，要根据分类id查，否则查全部
        if (catId != 0) {
            wrapper.eq("catalog_id", catId);
        }
        // 如果用户输入了检索条件，根据检索条件查
        String key = condition.getKey();
        if (StringUtils.isNotBlank(key)) {
            wrapper.and(t -> t.like("spu_name", key).or().eq("id", key));
        }

        return new PageVo(this.page(page, wrapper));
    }


    /**
     * 保存商品信息
     *
     * @param spuInfoVO
     */
    @GlobalTransactional
    @Override
    public void saveSpuInfoVO(SpuInfoVO spuInfoVO) {

        /// 1.保存spu相关
        Long spuId = this.saveSpuInfo(spuInfoVO);

        // 1.2. 保存spu的描述信息 spu_info_desc //新事务遇到ArithmeticException回滚不会添加数据
        this.spuInfoDescService.saveSpuDesc(spuInfoVO, spuId);

        // 1.3. 保存spu的规格参数信息
        this.saveBaseAttrs(spuInfoVO, spuId);

        /// 2. 保存sku相关信息 pms_spu_info
        this.saveSkuInfoWithSaleInfo(spuInfoVO, spuId);

    }

    /**
     * 保存sku相关信息及营销信息
     *
     * @param spuInfoVO
     */
    @Override
    public void saveSkuInfoWithSaleInfo(SpuInfoVO spuInfoVO, Long spuId) {
        List<SkuInfoVO> skus = spuInfoVO.getSkus();
        if (CollectionUtils.isEmpty(skus)) {
            return;
        }
        skus.forEach(skuInfoVO -> {
            // 2.1. 保存sku基本信息
            SkuInfoEntity skuInfoEntity = new SkuInfoEntity();
            BeanUtils.copyProperties(skuInfoVO, skuInfoEntity);
            // 品牌和分类的id需要从spuInfo中获取
            skuInfoEntity.setBrandId(spuInfoVO.getBrandId());
            skuInfoEntity.setCatalogId(spuInfoVO.getCatalogId());
            // 获取随机的uuid作为sku的编码
            skuInfoEntity.setSkuCode(UUID.randomUUID().toString().substring(0, 10).toUpperCase());
            // 获取图片列表
            List<String> images = skuInfoVO.getImages();
            // 如果图片列表不为null，则设置默认图片
            if (!CollectionUtils.isEmpty(images)) {
                // 设置第一张图片作为默认图片
                skuInfoEntity.setSkuDefaultImg(skuInfoEntity.getSkuDefaultImg() == null ? images.get(0) : skuInfoEntity.getSkuDefaultImg());
            }
            skuInfoEntity.setSpuId(spuId);
            this.skuInfoDao.insert(skuInfoEntity);

            // 获取skuId
            Long skuId = skuInfoEntity.getSkuId();
            // 2.2. 保存sku图片信息 pms_spu_images
            if (!CollectionUtils.isEmpty(images)) {
                String defaultImage = images.get(0);
                List<SkuImagesEntity> skuImagesEntities = images.stream().map(image -> {
                    SkuImagesEntity skuImagesEntity = new SkuImagesEntity();
                    skuImagesEntity.setDefaultImg(StringUtils.equals(defaultImage, image) ? 1 : 0);
                    skuImagesEntity.setSkuId(skuId);
                    skuImagesEntity.setImgSort(0);
                    skuImagesEntity.setImgUrl(image);
                    return skuImagesEntity;
                }).collect(Collectors.toList());
                boolean b = this.skuImagesService.saveBatch(skuImagesEntities);
                System.out.println(b);
            }

            // 2.3. 保存sku的规格参数（销售属性）
            List<SkuSaleAttrValueEntity> saleAttrs = skuInfoVO.getSaleAttrs();
            if (!CollectionUtils.isEmpty(saleAttrs)) {
                saleAttrs.forEach(saleAttr -> {
                    // 设置属性名，需要根据id查询AttrEntity
                    saleAttr.setSkuId(skuId);
                });
                boolean b = this.skuSaleAttrValueService.saveBatch(saleAttrs);
                System.out.println(b);

            }

            // 3. 保存营销相关信息，需要远程调用gmall-sms
            SkuSaleDTO skuSaleDTO = new SkuSaleDTO();
            BeanUtils.copyProperties(skuInfoVO, skuSaleDTO);
            skuSaleDTO.setSkuId(skuId);
            this.skuSaleFeign.saveSkuSaleInfo(skuSaleDTO);

        });
    }

    /**
     * 保存spu基本属性信息
     *
     * @param spuInfoVO
     */
    @Override
    public void saveBaseAttrs(SpuInfoVO spuInfoVO, Long spuId) {
        List<ProductAttrValueVO> baseAttrs = spuInfoVO.getBaseAttrs();
        if (!CollectionUtils.isEmpty(baseAttrs)) {
            List<ProductAttrValueEntity> productAttrValueEntities = baseAttrs.stream().map(productAttrValueVO -> {
                productAttrValueVO.setSpuId(spuId);
                productAttrValueVO.setAttrSort(0);
                productAttrValueVO.setQuickShow(0);
                return productAttrValueVO;

            }).collect(Collectors.toList());
            this.productAttrValueService.saveBatch(productAttrValueEntities);
        }
    }


    /**
     * 保存spu基本信息
     *
     * @param spuInfoVO
     */
    @Override
    public Long saveSpuInfo(SpuInfoVO spuInfoVO) {
        // 1.1. 保存spu基本信息 spu_info
        // 默认是已上架
        spuInfoVO.setPublishStatus(1);
        spuInfoVO.setCreateTime(new Date());
        // 新增时，更新时间和创建时间一致
        spuInfoVO.setUodateTime(spuInfoVO.getCreateTime());
        this.save(spuInfoVO);
        // 获取新增后的spuId
        return spuInfoVO.getId();
    }

}