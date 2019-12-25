package org.lhyf.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangfan
 * @date 2019/12/25 15:43
 * @Description
 */
@RestController
@RequestMapping(value = "/config2")
public class Config2Controller {
    @Value("${config.flag:default}")
    private String flag;

    @RequestMapping("/get")
    public String get() {
        return flag;
    }
}
