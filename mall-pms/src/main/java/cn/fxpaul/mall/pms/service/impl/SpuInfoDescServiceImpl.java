package cn.fxpaul.mall.pms.service.impl;

import cn.fxpaul.core.bean.PageVo;
import cn.fxpaul.core.bean.QueryCondition;
import cn.fxpaul.mall.pms.entity.vo.SpuInfoVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.fxpaul.core.bean.Query;
import cn.fxpaul.mall.pms.dao.SpuInfoDescDao;
import cn.fxpaul.mall.pms.entity.SpuInfoDescEntity;
import cn.fxpaul.mall.pms.service.SpuInfoDescService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;


@Service("spuInfoDescService")
public class SpuInfoDescServiceImpl extends ServiceImpl<SpuInfoDescDao, SpuInfoDescEntity> implements SpuInfoDescService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<SpuInfoDescEntity> page = this.page(
                new Query<SpuInfoDescEntity>().getPage(params),
                new QueryWrapper<SpuInfoDescEntity>()
        );

        return new PageVo(page);
    }

    /**
     * 保存spu描述信息（图片）
     *
     * @param spuInfoVO
     */
    @Transactional
    @Override
    public void saveSpuDesc(SpuInfoVO spuInfoVO, Long spuId) {
        List<String> spuImages = spuInfoVO.getSpuImages();

        if (!CollectionUtils.isEmpty(spuImages)) {
            SpuInfoDescEntity spuInfoDescEntity = new SpuInfoDescEntity();
            // 注意：spu_info_desc表的主键是spu_id,需要在实体类中配置该主键不是自增主键
            spuInfoDescEntity.setSpuId(spuId);
            // 把商品的图片描述，保存到spu详情中，图片地址以逗号进行分割
            spuInfoDescEntity.setDecript(StringUtils.join(spuInfoVO.getSpuImages(), ","));
            this.save(spuInfoDescEntity);
        }
    }

}