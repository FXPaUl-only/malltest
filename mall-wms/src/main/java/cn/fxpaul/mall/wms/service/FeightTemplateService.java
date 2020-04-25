package cn.fxpaul.mall.wms.service;

import cn.fxpaul.core.bean.PageVo;
import cn.fxpaul.core.bean.QueryCondition;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.fxpaul.mall.wms.entity.FeightTemplateEntity;


/**
 * 运费模板
 *
 * @author FXPaul
 * @email 486422911@qq.com
 * @date 2020-04-22 19:54:57
 */
public interface FeightTemplateService extends IService<FeightTemplateEntity> {

    PageVo queryPage(QueryCondition params);
}

