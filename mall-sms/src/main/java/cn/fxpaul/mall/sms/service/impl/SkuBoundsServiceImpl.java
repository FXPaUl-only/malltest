package cn.fxpaul.mall.sms.service.impl;

import cn.fxpaul.mall.sms.dao.SkuFullReductionDao;
import cn.fxpaul.mall.sms.dao.SkuLadderDao;
import cn.fxpaul.mall.sms.entity.SkuFullReductionEntity;
import cn.fxpaul.mall.sms.entity.SkuLadderEntity;
import cn.fxpaul.mall.sms.dto.SkuSaleDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.fxpaul.core.bean.PageVo;
import cn.fxpaul.core.bean.Query;
import cn.fxpaul.core.bean.QueryCondition;

import cn.fxpaul.mall.sms.dao.SkuBoundsDao;
import cn.fxpaul.mall.sms.entity.SkuBoundsEntity;
import cn.fxpaul.mall.sms.service.SkuBoundsService;
import org.springframework.util.CollectionUtils;


@Service("skuBoundsService")
public class SkuBoundsServiceImpl extends ServiceImpl<SkuBoundsDao, SkuBoundsEntity> implements SkuBoundsService {

    @Autowired
    private SkuFullReductionDao skuFullReductionDao;

    @Autowired
    private SkuLadderDao skuLadderDao;


    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<SkuBoundsEntity> page = this.page(
                new Query<SkuBoundsEntity>().getPage(params),
                new QueryWrapper<SkuBoundsEntity>()
        );

        return new PageVo(page);
    }

    @Override
    public void saveSkuSaleInfo(SkuSaleDTO skuSaleDTO) {

        // 3.1. 积分优惠
        SkuBoundsEntity skuBoundsEntity = new SkuBoundsEntity();
        BeanUtils.copyProperties(skuSaleDTO, skuBoundsEntity);
        // 数据库保存的是整数0-15，页面绑定是0000-1111
        List<Integer> work = skuSaleDTO.getWork();

        if (!CollectionUtils.isEmpty(work)){
            skuBoundsEntity.setWork(work.get(0) * 8 + work.get(1) * 4 + work.get(2) * 2 + work.get(3));
        }
        this.save(skuBoundsEntity);

        // 3.2. 满减优惠
        SkuFullReductionEntity skuFullReductionEntity = new SkuFullReductionEntity();
        BeanUtils.copyProperties(skuSaleDTO, skuFullReductionEntity);
        skuFullReductionEntity.setAddOther(skuSaleDTO.getFullAddOther());
        this.skuFullReductionDao.insert(skuFullReductionEntity);

        // 3.3. 数量折扣
        SkuLadderEntity skuLadderEntity = new SkuLadderEntity();
        BeanUtils.copyProperties(skuSaleDTO, skuLadderEntity);
        this.skuLadderDao.insert(skuLadderEntity);

    }

}