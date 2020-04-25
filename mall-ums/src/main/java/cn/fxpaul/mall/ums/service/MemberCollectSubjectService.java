package cn.fxpaul.mall.ums.service;

import cn.fxpaul.core.bean.PageVo;
import cn.fxpaul.core.bean.QueryCondition;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.fxpaul.mall.ums.entity.MemberCollectSubjectEntity;

/**
 * 会员收藏的专题活动
 *
 * @author FXPaul
 * @email 486422911@qq.com
 * @date 2020-04-22 19:48:32
 */
public interface MemberCollectSubjectService extends IService<MemberCollectSubjectEntity> {

    PageVo queryPage(QueryCondition params);
}

