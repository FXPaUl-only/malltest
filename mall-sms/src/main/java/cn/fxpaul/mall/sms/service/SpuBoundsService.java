package cn.fxpaul.mall.sms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.fxpaul.mall.sms.entity.SpuBoundsEntity;
import cn.fxpaul.core.bean.PageVo;
import cn.fxpaul.core.bean.QueryCondition;
/**
 * 商品spu积分设置
 *
 * @author FXPaul
 * @email 486422911@qq.com
 * @date 2020-04-22 18:08:46
 */
public interface SpuBoundsService extends IService<SpuBoundsEntity> {

    PageVo queryPage(QueryCondition params);

}

