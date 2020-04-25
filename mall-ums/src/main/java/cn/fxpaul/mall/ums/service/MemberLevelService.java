package cn.fxpaul.mall.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.fxpaul.mall.ums.entity.MemberLevelEntity;
import cn.fxpaul.core.bean.PageVo;
import cn.fxpaul.core.bean.QueryCondition;
/**
 * 会员等级
 *
 * @author FXPaul
 * @email 486422911@qq.com
 * @date 2020-04-22 19:48:32
 */
public interface MemberLevelService extends IService<MemberLevelEntity> {

    PageVo queryPage(QueryCondition params);
}

