package cn.fxpaul.mall.oms.dao;

import cn.fxpaul.mall.oms.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author FXPaul
 * @email 486422911@qq.com
 * @date 2020-04-22 18:28:29
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}
