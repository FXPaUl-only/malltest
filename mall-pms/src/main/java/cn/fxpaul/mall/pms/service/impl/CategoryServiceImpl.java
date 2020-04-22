package cn.fxpaul.mall.pms.service.impl;

import cn.fxpaul.core.bean.PageVo;
import cn.fxpaul.core.bean.Query;
import cn.fxpaul.core.bean.QueryCondition;
import cn.fxpaul.core.exception.MyException;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.fxpaul.mall.pms.dao.CategoryDao;
import cn.fxpaul.mall.pms.entity.CategoryEntity;
import cn.fxpaul.mall.pms.service.CategoryService;

import java.util.List;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageVo(page);
    }

    @Override
    public List<CategoryEntity> queryListWeb(Integer level, Long pid) {

        QueryWrapper<CategoryEntity> wrapper = new QueryWrapper<>();
        if (level != 0) {
            wrapper.eq("cat_level", level);
        }
        if (pid != null) {
            wrapper.eq("parent_cid", pid);
        }

        List<CategoryEntity> list = this.list(wrapper);
        if (list == null) {
            throw new MyException("数据不存在", 500);
        }
        return list;
    }


}