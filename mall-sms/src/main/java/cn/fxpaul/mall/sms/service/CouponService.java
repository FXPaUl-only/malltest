package cn.fxpaul.mall.sms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.fxpaul.mall.sms.entity.CouponEntity;
import cn.fxpaul.core.bean.PageVo;
import cn.fxpaul.core.bean.QueryCondition;
/**
 * 优惠券信息
 *
 * @author FXPaul
 * @email 486422911@qq.com
 * @date 2020-04-22 18:08:46
 */
public interface CouponService extends IService<CouponEntity> {

    PageVo queryPage(QueryCondition params);
}

