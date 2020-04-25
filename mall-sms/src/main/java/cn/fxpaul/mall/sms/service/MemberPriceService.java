package cn.fxpaul.mall.sms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.fxpaul.mall.sms.entity.MemberPriceEntity;
import cn.fxpaul.core.bean.PageVo;
import cn.fxpaul.core.bean.QueryCondition;
/**
 * 商品会员价格
 *
 * @author FXPaul
 * @email 486422911@qq.com
 * @date 2020-04-22 18:08:46
 */
public interface MemberPriceService extends IService<MemberPriceEntity> {

    PageVo queryPage(QueryCondition params);
}

