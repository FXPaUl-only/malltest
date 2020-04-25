package cn.fxpaul.mall.oms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.fxpaul.mall.oms.entity.OrderOperateHistoryEntity;
import cn.fxpaul.core.bean.PageVo;
import cn.fxpaul.core.bean.QueryCondition;

/**
 * 订单操作历史记录
 *
 * @author FXPaul
 * @email 486422911@qq.com
 * @date 2020-04-22 18:28:29
 */
public interface OrderOperateHistoryService extends IService<OrderOperateHistoryEntity> {

    PageVo queryPage(QueryCondition params);
}

