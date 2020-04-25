package cn.fxpaul.mall.oms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.fxpaul.mall.oms.entity.OrderSettingEntity;
import cn.fxpaul.core.bean.PageVo;
import cn.fxpaul.core.bean.QueryCondition;
/**
 * 订单配置信息
 *
 * @author FXPaul
 * @email 486422911@qq.com
 * @date 2020-04-22 18:28:29
 */
public interface OrderSettingService extends IService<OrderSettingEntity> {

    PageVo queryPage(QueryCondition params);
}

