package org.lhyf.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
//@RefreshScope
public class ConfigController {

    @Value("${useLocalCache:default}")
    private String useLocalCache;

    @RequestMapping("/get")
    public String get() {
        return "consumer:" + useLocalCache;
    }
}