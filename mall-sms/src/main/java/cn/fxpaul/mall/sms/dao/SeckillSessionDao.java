package cn.fxpaul.mall.sms.dao;

import cn.fxpaul.mall.sms.entity.SeckillSessionEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 秒杀活动场次
 * 
 * @author FXPaul
 * @email 486422911@qq.com
 * @date 2020-04-22 18:08:46
 */
@Mapper
public interface SeckillSessionDao extends BaseMapper<SeckillSessionEntity> {
	
}
