package cn.fxpaul.mall.oms.service;

import cn.fxpaul.core.bean.PageVo;
import cn.fxpaul.core.bean.QueryCondition;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.fxpaul.mall.oms.entity.OrderItemEntity;


/**
 * 订单项信息
 *
 * @author FXPaul
 * @email 486422911@qq.com
 * @date 2020-04-22 18:28:29
 */
public interface OrderItemService extends IService<OrderItemEntity> {

    PageVo queryPage(QueryCondition params);
}

