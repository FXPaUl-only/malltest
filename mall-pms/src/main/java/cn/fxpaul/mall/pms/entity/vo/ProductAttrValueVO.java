package cn.fxpaul.mall.pms.entity.vo;

import cn.fxpaul.mall.pms.entity.ProductAttrValueEntity;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @project: mall
 * @author: FXPaul
 * @date: 2020/4/23 15:17
 */
@Data
public class ProductAttrValueVO extends ProductAttrValueEntity {

    public void setValueSelected(List<Object> valueSelected){
        // 如果接受的集合为空，则不设置
        if (CollectionUtils.isEmpty(valueSelected)){
            return;
        }
        this.setAttrValue(StringUtils.join(valueSelected, ","));
    }

}
