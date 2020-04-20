
package cn.fxpaul.modules.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.fxpaul.modules.app.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 *
 * @author FXPaul
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

}
