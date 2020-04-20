
package cn.fxpaul.modules.sys.service;


import cn.fxpaul.common.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.fxpaul.modules.sys.entity.SysLogEntity;

import java.util.Map;


/**
 * 系统日志
 *
 * @author FXPaul
 */
public interface SysLogService extends IService<SysLogEntity> {

    PageUtils queryPage(Map<String, Object> params);

}
