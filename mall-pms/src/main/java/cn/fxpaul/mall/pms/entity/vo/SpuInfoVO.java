package cn.fxpaul.mall.pms.entity.vo;

/**
 * @project: mall
 * @author: FXPaul
 * @date: 2020/4/23 15:16
 */

import cn.fxpaul.mall.pms.entity.SpuInfoEntity;
import lombok.Data;

import java.util.List;

/**
 * spuInfo扩展对象
 * 包含：spuInfo基本信息、spuImages图片信息、baseAttrs基本属性信息、skus信息
 *
 * @author FXPaul
 */

@Data
public class SpuInfoVO extends SpuInfoEntity {

    /**
     * 图片信息
     */

    private List<String> spuImages;

    /**
     * 基本属性信息
     */
    private List<ProductAttrValueVO> baseAttrs;

    /**
     * Sku对应信息
     */
    private List<SkuInfoVO> skus;

}
