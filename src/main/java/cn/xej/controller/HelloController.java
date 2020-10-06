package cn.xej.controller;

import cn.xej.common.RespObj;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    @GetMapping("/hello")
    public RespObj hello() {
        String x = "world";
        return RespObj.succ(x);
    }

    @GetMapping("/ss")
    public String ss(){
        return "dasd";
    }

}
