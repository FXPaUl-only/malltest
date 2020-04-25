package cn.fxpaul.mall.pms.feign;

import cn.fxpaul.mall.sms.api.MallSmsApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @project: mall
 * @author: FXPaul
 * @date: 2020/4/24 23:39
 */
@FeignClient("service-sms")
public interface SkuSaleFeign extends MallSmsApi {

}
