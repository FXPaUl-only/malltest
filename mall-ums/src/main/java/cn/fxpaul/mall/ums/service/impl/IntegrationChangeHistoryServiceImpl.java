package cn.fxpaul.mall.ums.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.fxpaul.core.bean.PageVo;
import cn.fxpaul.core.bean.Query;
import cn.fxpaul.core.bean.QueryCondition;

import cn.fxpaul.mall.ums.dao.IntegrationChangeHistoryDao;
import cn.fxpaul.mall.ums.entity.IntegrationChangeHistoryEntity;
import cn.fxpaul.mall.ums.service.IntegrationChangeHistoryService;


@Service("integrationChangeHistoryService")
public class IntegrationChangeHistoryServiceImpl extends ServiceImpl<IntegrationChangeHistoryDao, IntegrationChangeHistoryEntity> implements IntegrationChangeHistoryService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<IntegrationChangeHistoryEntity> page = this.page(
                new Query<IntegrationChangeHistoryEntity>().getPage(params),
                new QueryWrapper<IntegrationChangeHistoryEntity>()
        );

        return new PageVo(page);
    }

}