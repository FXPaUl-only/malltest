
package cn.fxpaul.modules.app.service;


import cn.fxpaul.modules.app.entity.UserEntity;
import cn.fxpaul.modules.app.form.LoginForm;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 用户
 *
 * @author FXPaul
 */
public interface UserService extends IService<UserEntity> {

	UserEntity queryByMobile(String mobile);

	/**
	 * 用户登录
	 * @param form    登录表单
	 * @return        返回用户ID
	 */
	long login(LoginForm form);
}
