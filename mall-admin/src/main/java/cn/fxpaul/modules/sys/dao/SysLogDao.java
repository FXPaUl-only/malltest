
package cn.fxpaul.modules.sys.dao;


import cn.fxpaul.modules.sys.entity.SysLogEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统日志
 *
 * @author FXPaul
 */
@Mapper
public interface SysLogDao extends BaseMapper<SysLogEntity> {
	
}
