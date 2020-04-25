package cn.fxpaul.mall.wms.dao;

import cn.fxpaul.mall.wms.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品库存
 * 
 * @author FXPaul
 * @email 486422911@qq.com
 * @date 2020-04-22 19:54:57
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {
	
}
