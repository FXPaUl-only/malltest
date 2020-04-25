package cn.fxpaul.mall.oms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.fxpaul.mall.oms.entity.RefundInfoEntity;
import cn.fxpaul.core.bean.PageVo;
import cn.fxpaul.core.bean.QueryCondition;

/**
 * 退款信息
 *
 * @author FXPaul
 * @email 486422911@qq.com
 * @date 2020-04-22 18:28:29
 */
public interface RefundInfoService extends IService<RefundInfoEntity> {

    PageVo queryPage(QueryCondition params);
}

