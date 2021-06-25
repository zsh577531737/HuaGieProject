package com.huage.nacos.nacosapi.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ：花Gie
 * @date ：Created in 2021/6/24 10:00
 * @description： 接口返回实体类
 */
@Data
public class ResponseDemo implements Serializable {
    private static final long serialVersionUID = 2206286050783576406L;

    private String name;

    public ResponseDemo(String name) {
        this.name = name;
    }

    public ResponseDemo() {
    }
}
