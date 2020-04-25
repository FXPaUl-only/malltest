package cn.fxpaul.mall.sms.api;

import cn.fxpaul.core.bean.Resp;
import cn.fxpaul.mall.sms.dto.SkuSaleDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @project: mall
 * @author: FXPaul
 * @date: 2020/4/25 0:33
 */
public interface MallSmsApi {

    @PostMapping("/sms/skubounds/skusale/save")
    Resp<Object> saveSkuSaleInfo(@RequestBody SkuSaleDTO skuSaleDTO);

}
