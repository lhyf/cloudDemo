package org.lhyf.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/****
 * @author YF
 * @date 2019-12-14 21:08
 * @desc EchoController
 *
 **/
@Slf4j
@RestController
public class EchoController {

    @RequestMapping(value = "/echo/{name}/{address}")
    public String echo(@PathVariable(value = "name") String name, @PathVariable(value = "address") String address) {
        log.info("provider 收到参数:name:{}, address:{}", name, address);
        return "Name:" + name + " : Address:" + address;
    }
}
