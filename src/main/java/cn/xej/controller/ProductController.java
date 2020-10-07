package cn.xej.controller;

import cn.xej.common.RespObj;
import cn.xej.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 获取该用户的所有产品
     */
    @GetMapping("/initProductTable")
    public RespObj initProductTable(){
        System.out.println("获取该用户的所有产品");
        String username = "xej";
        return productService.initProductTable(username);
    }

}
