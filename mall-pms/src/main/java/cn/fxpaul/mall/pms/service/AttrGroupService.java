package cn.fxpaul.mall.pms.service;

import cn.fxpaul.core.bean.PageVo;
import cn.fxpaul.core.bean.QueryCondition;
import cn.fxpaul.mall.pms.entity.vo.AttrGroupVo;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.fxpaul.mall.pms.entity.AttrGroupEntity;

import java.util.List;


/**
 * 属性分组
 *
 * @author FXPaul
 * @email 486422911@qq.com
 * @date 2020-04-20 14:30:34
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageVo queryPage(QueryCondition params);

    /**
     * 查询规格分组
     * @param cid 分离id
     * @param condition 查询太久
     * @return 分页对象
     */
    PageVo queryByCidPage(Long cid, QueryCondition condition);

    /**
     *
     * @param gid
     * @return
     */
    AttrGroupVo queryById(Long gid);

    /**
     * 查询分类下的分组及其规格参数
     * @param cid
     * @return
     */
    List<AttrGroupVo> queryByCid(Long cid);
}

