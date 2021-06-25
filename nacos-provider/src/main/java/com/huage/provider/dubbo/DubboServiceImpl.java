package com.huage.provider.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.huage.nacos.nacosapi.request.RequestDemo;
import com.huage.nacos.nacosapi.response.ResponseDemo;

/**
 * @author ：zhangsh
 * @date ：Created in 2021/6/24 10:28
 * @description： 接口实现类
 */
@Service(version = "${nacos.service.version}")
public class DubboServiceImpl implements com.huage.nacos.nacosapi.service.DubboServiceDemo {
    @Override
    public ResponseDemo getName(RequestDemo requestDemo) {
        System.out.println("123123");
        ResponseDemo er = new ResponseDemo("花Gie");
        return er;
    }
}
