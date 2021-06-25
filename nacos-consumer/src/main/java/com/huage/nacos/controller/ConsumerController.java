package com.huage.nacos.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;

import com.huage.nacos.nacosapi.request.RequestDemo;
import com.huage.nacos.nacosapi.response.ResponseDemo;
import com.huage.nacos.nacosapi.service.DubboServiceDemo;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：zhangsh
 * @date ：Created in 2021/6/23 18:56
 * @description：
 */
@RestController
@ResponseBody
public class ConsumerController {

    @Reference(check = false, version = "${nacos.service.version}")
    private DubboServiceDemo dubboServiceDemo;

    @NacosValue(value = "${name}", autoRefreshed = true)
    private String name;

    @RequestMapping(value = "/getName", method = RequestMethod.GET)
    @ResponseBody
    public String getName() {
        return name;
    }

    @RequestMapping(value = "/getDubboResult", method = RequestMethod.GET)
    @ResponseBody
    public ResponseDemo getDubboResult() {
        ResponseDemo de = dubboServiceDemo.getName(new RequestDemo());
        return de;
    }
}
