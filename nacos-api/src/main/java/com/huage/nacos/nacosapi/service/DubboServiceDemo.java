package com.huage.nacos.nacosapi.service;

import com.huage.nacos.nacosapi.request.RequestDemo;
import com.huage.nacos.nacosapi.response.ResponseDemo;

/**
 * @author ：花Gie
 * @date ：Created in 2021/6/24 10:00
 * @description：接口213
 */
public interface DubboServiceDemo {

    /**
     * 获取用户名称
     *
     * @param requestDemo
     * @return
     */
    ResponseDemo getName(RequestDemo requestDemo);
}
