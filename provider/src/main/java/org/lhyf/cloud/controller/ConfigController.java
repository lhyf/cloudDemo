package org.lhyf.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Value("${useLocalCache:false}")
    private Boolean useLocalCache;

    @RequestMapping("/get")
    public Boolean get() {
        redisTemplate.opsForValue().get("11234");
        return useLocalCache;
    }
}