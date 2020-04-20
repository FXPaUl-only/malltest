
package cn.fxpaul.modules.oss.service;

import cn.fxpaul.common.utils.PageUtils;
import cn.fxpaul.modules.oss.entity.SysOssEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 文件上传
 *
 * @author FXPaul
 */
public interface SysOssService extends IService<SysOssEntity> {

	PageUtils queryPage(Map<String, Object> params);
}
