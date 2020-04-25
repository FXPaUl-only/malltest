package cn.fxpaul.mall.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.fxpaul.mall.ums.entity.MemberEntity;
import cn.fxpaul.core.bean.PageVo;
import cn.fxpaul.core.bean.QueryCondition;
/**
 * 会员
 *
 * @author FXPaul
 * @email 486422911@qq.com
 * @date 2020-04-22 19:48:32
 */
public interface MemberService extends IService<MemberEntity> {

    PageVo queryPage(QueryCondition params);
}

