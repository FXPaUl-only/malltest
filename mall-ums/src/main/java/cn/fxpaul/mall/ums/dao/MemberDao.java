package cn.fxpaul.mall.ums.dao;

import cn.fxpaul.mall.ums.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author FXPaul
 * @email 486422911@qq.com
 * @date 2020-04-22 19:48:32
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
