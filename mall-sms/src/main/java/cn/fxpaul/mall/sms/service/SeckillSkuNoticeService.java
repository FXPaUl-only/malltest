package cn.fxpaul.mall.sms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.fxpaul.mall.sms.entity.SeckillSkuNoticeEntity;
import cn.fxpaul.core.bean.PageVo;
import cn.fxpaul.core.bean.QueryCondition;

/**
 * 秒杀商品通知订阅
 *
 * @author FXPaul
 * @email 486422911@qq.com
 * @date 2020-04-22 18:08:46
 */
public interface SeckillSkuNoticeService extends IService<SeckillSkuNoticeEntity> {

    PageVo queryPage(QueryCondition params);
}

