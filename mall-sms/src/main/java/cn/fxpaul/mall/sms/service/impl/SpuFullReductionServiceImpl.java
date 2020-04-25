package cn.fxpaul.mall.sms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.fxpaul.core.bean.PageVo;
import cn.fxpaul.core.bean.Query;
import cn.fxpaul.core.bean.QueryCondition;
import cn.fxpaul.mall.sms.dao.SpuFullReductionDao;
import cn.fxpaul.mall.sms.entity.SpuFullReductionEntity;
import cn.fxpaul.mall.sms.service.SpuFullReductionService;


@Service("spuFullReductionService")
public class SpuFullReductionServiceImpl extends ServiceImpl<SpuFullReductionDao, SpuFullReductionEntity> implements SpuFullReductionService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<SpuFullReductionEntity> page = this.page(
                new Query<SpuFullReductionEntity>().getPage(params),
                new QueryWrapper<SpuFullReductionEntity>()
        );

        return new PageVo(page);
    }

}