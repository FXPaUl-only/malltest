package cn.fxpaul.mall.pms.dao;

import cn.fxpaul.mall.pms.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author FXPaul
 * @email 486422911@qq.com
 * @date 2020-04-20 14:30:34
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
