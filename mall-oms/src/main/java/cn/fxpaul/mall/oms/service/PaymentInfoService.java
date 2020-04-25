package cn.fxpaul.mall.oms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.fxpaul.mall.oms.entity.PaymentInfoEntity;
import cn.fxpaul.core.bean.PageVo;
import cn.fxpaul.core.bean.QueryCondition;
/**
 * 支付信息表
 *
 * @author FXPaul
 * @email 486422911@qq.com
 * @date 2020-04-22 18:28:29
 */
public interface PaymentInfoService extends IService<PaymentInfoEntity> {

    PageVo queryPage(QueryCondition params);
}

