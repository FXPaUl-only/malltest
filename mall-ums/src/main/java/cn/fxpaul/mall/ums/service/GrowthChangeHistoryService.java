package cn.fxpaul.mall.ums.service;

import cn.fxpaul.core.bean.PageVo;
import cn.fxpaul.core.bean.QueryCondition;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.fxpaul.mall.ums.entity.GrowthChangeHistoryEntity;


/**
 * 成长值变化历史记录
 *
 * @author FXPaul
 * @email 486422911@qq.com
 * @date 2020-04-22 19:48:32
 */
public interface GrowthChangeHistoryService extends IService<GrowthChangeHistoryEntity> {

    PageVo queryPage(QueryCondition params);
}

