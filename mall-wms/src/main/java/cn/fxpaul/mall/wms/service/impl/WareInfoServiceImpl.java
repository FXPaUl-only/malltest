package cn.fxpaul.mall.wms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.fxpaul.core.bean.Query;
import cn.fxpaul.core.bean.PageVo;
import cn.fxpaul.core.bean.QueryCondition;

import cn.fxpaul.mall.wms.dao.WareInfoDao;
import cn.fxpaul.mall.wms.entity.WareInfoEntity;
import cn.fxpaul.mall.wms.service.WareInfoService;


@Service("wareInfoService")
public class WareInfoServiceImpl extends ServiceImpl<WareInfoDao, WareInfoEntity> implements WareInfoService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<WareInfoEntity> page = this.page(
                new Query<WareInfoEntity>().getPage(params),
                new QueryWrapper<WareInfoEntity>()
        );

        return new PageVo(page);
    }

}