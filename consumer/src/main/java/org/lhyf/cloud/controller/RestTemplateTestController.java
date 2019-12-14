package org.lhyf.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;


/**
 * @author yangfan
 * @date 2019/12/12 15:12
 * @Description 测试 RestTemplate
 *
 * get相关:
 * restTemplate.getForEntity
 * restTemplate.getForObject
 * post相关:
 * restTemplate.postForLocation
 * restTemplate.postForObject
 * restTemplate.postForEntity
 * put相关:
 * restTemplate.put
 * delete相关:
 * restTemplate.delete
 *
 */
@Slf4j
@RestController
public class RestTemplateTestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/echo1/{name}/{address}")
    public String echo1(@PathVariable(value = "name") String name, @PathVariable(value = "address") String address) {
        ResponseEntity<String> entity = restTemplate.getForEntity("http://provider/echo/{1}/{2}", String.class, name, address);
        HttpStatus statusCode = entity.getStatusCode();
        log.info(statusCode.toString());
        String body = entity.getBody();
        log.info(body);

        return body;
    }

    @GetMapping(value = "/echo2/{name}/{address}")
    public String echo2(@PathVariable(value = "name") String name, @PathVariable(value = "address") String address) {
        Map<String, Object> params = new HashMap<>();
        params.put("name1", name);
        params.put("address1", address);
        ResponseEntity<String> entity = restTemplate.getForEntity("http://provider/echo/{name1}/{address1}", String.class, params);
        HttpStatus statusCode = entity.getStatusCode();
        log.info(statusCode.toString());
        String body = entity.getBody();
        log.info(body);
        return body;
    }

    @GetMapping(value = "/echo3/{name}/{address}")
    public String echo3(@PathVariable(value = "name") String name, @PathVariable(value = "address") String address) {
        Map<String, Object> params = new HashMap<>();
        params.put("name1", name);
        params.put("address1", address);

        UriComponents uriComponents = UriComponentsBuilder.fromUriString("http://provider/echo/{name1}/{address1}")
                .build()
                .expand(params)
                .encode();
        URI uri = uriComponents.toUri();
        ResponseEntity<String> entity = restTemplate.getForEntity(uri, String.class);
        HttpStatus statusCode = entity.getStatusCode();
        log.info(statusCode.toString());
        String body = entity.getBody();
        log.info(body);
        return body;
    }

    @GetMapping(value = "/echo4/{name}/{address}")
    public String echo4(@PathVariable(value = "name") String name, @PathVariable(value = "address") String address) {
        String body = restTemplate.getForObject("http://provider/echo/{1}/{2}", String.class, name, address);
        log.info(body);
        return body;
    }

    @GetMapping(value = "/echo5/{name}/{address}")
    public String echo5(@PathVariable(value = "name") String name, @PathVariable(value = "address") String address) {
        Map<String, Object> params = new HashMap<>();
        params.put("name1", name);
        params.put("address1", address);
        String body = restTemplate.getForObject("http://provider/echo/{name1}/{address1}", String.class, params);

        log.info(body);
        return body;
    }

    @GetMapping(value = "/echo6/{name}/{address}")
    public String echo6(@PathVariable(value = "name") String name, @PathVariable(value = "address") String address) {
        Map<String, Object> params = new HashMap<>();
        params.put("name1", name);
        params.put("address1", address);

        UriComponents uriComponents = UriComponentsBuilder.fromUriString("http://provider/echo/{name1}/{address1}")
                .build()
                .expand(params)
                .encode();
        URI uri = uriComponents.toUri();
        String body = restTemplate.getForObject(uri, String.class);

        log.info(body);
        return body;
    }

}
