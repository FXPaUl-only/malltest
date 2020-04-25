package cn.fxpaul.mall.pms.entity.vo;

import cn.fxpaul.mall.pms.entity.AttrAttrgroupRelationEntity;
import cn.fxpaul.mall.pms.entity.AttrEntity;
import cn.fxpaul.mall.pms.entity.AttrGroupEntity;
import lombok.Data;

import java.util.List;

/**
 * @project: mall
 * @author: FXPaul
 * @date: 2020/4/23 9:48
 */
@Data
public class AttrGroupVo extends AttrGroupEntity {

    private List<AttrEntity> attrEntities;

    private List<AttrAttrgroupRelationEntity> relations;
}
