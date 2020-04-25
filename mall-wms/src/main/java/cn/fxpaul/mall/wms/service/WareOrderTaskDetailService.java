package cn.fxpaul.mall.wms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.fxpaul.mall.wms.entity.WareOrderTaskDetailEntity;
import cn.fxpaul.core.bean.PageVo;
import cn.fxpaul.core.bean.QueryCondition;

/**
 * 库存工作单
 *
 * @author FXPaul
 * @email 486422911@qq.com
 * @date 2020-04-22 19:54:57
 */
public interface WareOrderTaskDetailService extends IService<WareOrderTaskDetailEntity> {

    PageVo queryPage(QueryCondition params);
}

