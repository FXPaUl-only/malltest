package cn.fxpaul.mall.pms.service;

import cn.fxpaul.core.bean.PageVo;
import cn.fxpaul.core.bean.QueryCondition;
import cn.fxpaul.mall.pms.entity.vo.SpuInfoVO;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.fxpaul.mall.pms.entity.SpuInfoEntity;

/**
 * spu信息
 *
 * @author FXPaul
 * @email 486422911@qq.com
 * @date 2020-04-20 14:30:34
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageVo queryPage(QueryCondition params);

    PageVo querySpuInfo(QueryCondition condition, Long catId);

    void saveSpuInfoVO(SpuInfoVO spuInfoVO);

    void saveSkuInfoWithSaleInfo(SpuInfoVO spuInfoVO, Long spuId);

    void saveBaseAttrs(SpuInfoVO spuInfoVO, Long spuId);



    Long saveSpuInfo(SpuInfoVO spuInfoVO);
}

