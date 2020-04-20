
package cn.fxpaul.modules.job.service;

import cn.fxpaul.common.utils.PageUtils;
import cn.fxpaul.modules.job.entity.ScheduleJobLogEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 定时任务日志
 *
 * @author FXPaul
 */
public interface ScheduleJobLogService extends IService<ScheduleJobLogEntity> {

	PageUtils queryPage(Map<String, Object> params);
	
}
