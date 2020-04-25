package cn.fxpaul.mall.sms.service;

import cn.fxpaul.mall.sms.dto.SkuSaleDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.fxpaul.mall.sms.entity.SkuBoundsEntity;
import cn.fxpaul.core.bean.PageVo;
import cn.fxpaul.core.bean.QueryCondition;

/**
 * 商品sku积分设置
 *
 * @author FXPaul
 * @email 486422911@qq.com
 * @date 2020-04-22 18:08:46
 */
public interface SkuBoundsService extends IService<SkuBoundsEntity> {

    PageVo queryPage(QueryCondition params);

    void saveSkuSaleInfo(SkuSaleDTO skuSaleDTO);
}

