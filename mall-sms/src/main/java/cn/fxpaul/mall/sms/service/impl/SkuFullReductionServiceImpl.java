package cn.fxpaul.mall.sms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.fxpaul.core.bean.PageVo;
import cn.fxpaul.core.bean.Query;
import cn.fxpaul.core.bean.QueryCondition;
import cn.fxpaul.mall.sms.dao.SkuFullReductionDao;
import cn.fxpaul.mall.sms.entity.SkuFullReductionEntity;
import cn.fxpaul.mall.sms.service.SkuFullReductionService;


@Service("skuFullReductionService")
public class SkuFullReductionServiceImpl extends ServiceImpl<SkuFullReductionDao, SkuFullReductionEntity> implements SkuFullReductionService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<SkuFullReductionEntity> page = this.page(
                new Query<SkuFullReductionEntity>().getPage(params),
                new QueryWrapper<SkuFullReductionEntity>()
        );

        return new PageVo(page);
    }

}