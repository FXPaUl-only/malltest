package cn.fxpaul.mall.pms.service;

import cn.fxpaul.core.bean.PageVo;
import cn.fxpaul.core.bean.QueryCondition;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.fxpaul.mall.pms.entity.CategoryEntity;

import java.util.List;

/**
 * 商品三级分类
 *
 * @author FXPaul
 * @email 486422911@qq.com
 * @date 2020-04-20 14:30:34
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageVo queryPage(QueryCondition params);


    /**
     * 查询分类
     * @param level 等级
     * @param pid 父集ID
     * @return 分类数据集合
     */
    List<CategoryEntity> queryListWeb(Integer level, Long pid);
}

