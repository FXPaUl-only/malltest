package cn.fxpaul.mall.pms.service.impl;

import cn.fxpaul.core.bean.PageVo;
import cn.fxpaul.core.bean.Query;
import cn.fxpaul.core.bean.QueryCondition;
import cn.fxpaul.mall.pms.dao.AttrAttrgroupRelationDao;
import cn.fxpaul.mall.pms.entity.AttrAttrgroupRelationEntity;
import cn.fxpaul.mall.pms.entity.vo.AttrVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.fxpaul.mall.pms.dao.AttrDao;
import cn.fxpaul.mall.pms.entity.AttrEntity;
import cn.fxpaul.mall.pms.service.AttrService;
import org.springframework.transaction.annotation.Transactional;


@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrDao, AttrEntity> implements AttrService {

    @Autowired
    private AttrDao attrDao;

    @Autowired
    private AttrAttrgroupRelationDao relationDao;



    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageVo(page);
    }

    @Override
    public PageVo queryByCidTypePage(QueryCondition queryCondition, Long cid, Integer type) {
        // 构建查询条件
        QueryWrapper<AttrEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("catelog_id", cid);
        if (type != null) {
            wrapper.eq("attr_type", type);
        }
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(queryCondition), // 构建分页条件
                wrapper
        );

        return new PageVo(page);
    }

    @Transactional
    @Override
    public void saveAttrVO(AttrVO attrVO) {
        // 新增规格参数
        this.attrDao.insert(attrVO);

        // 新增中间表
        AttrAttrgroupRelationEntity relation = new AttrAttrgroupRelationEntity();
        relation.setAttrId(attrVO.getAttrId());
        relation.setAttrGroupId(attrVO.getAttrGroupId());
        this.relationDao.insert(relation);
    }

}