
package cn.fxpaul.modules.sys.service;

import cn.fxpaul.modules.sys.entity.SysUserTokenEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.fxpaul.common.utils.R;

/**
 * 用户Token
 *
 * @author FXPaul
 */
public interface SysUserTokenService extends IService<SysUserTokenEntity> {

	/**
	 * 生成token
	 * @param userId  用户ID
	 */
	R createToken(long userId);

	/**
	 * 退出，修改token值
	 * @param userId  用户ID
	 */
	void logout(long userId);

}
