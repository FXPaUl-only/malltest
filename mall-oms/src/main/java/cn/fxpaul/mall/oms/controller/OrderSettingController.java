package cn.fxpaul.mall.oms.controller;

import java.util.Arrays;
import java.util.Map;


import cn.fxpaul.core.bean.PageVo;
import cn.fxpaul.core.bean.QueryCondition;
import cn.fxpaul.core.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import cn.fxpaul.mall.oms.entity.OrderSettingEntity;
import cn.fxpaul.mall.oms.service.OrderSettingService;




/**
 * 订单配置信息
 *
 * @author FXPaul
 * @email 486422911@qq.com
 * @date 2020-04-22 18:28:29
 */
@Api(tags = "订单配置信息 管理")
@RestController
@RequestMapping("oms/ordersetting")
public class OrderSettingController {
    @Autowired
    private OrderSettingService orderSettingService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('oms:ordersetting:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = orderSettingService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('oms:ordersetting:info')")
    public Resp<OrderSettingEntity> info(@PathVariable("id") Long id){
		OrderSettingEntity orderSetting = orderSettingService.getById(id);

        return Resp.ok(orderSetting);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('oms:ordersetting:save')")
    public Resp<Object> save(@RequestBody OrderSettingEntity orderSetting){
		orderSettingService.save(orderSetting);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('oms:ordersetting:update')")
    public Resp<Object> update(@RequestBody OrderSettingEntity orderSetting){
		orderSettingService.updateById(orderSetting);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('oms:ordersetting:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		orderSettingService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
