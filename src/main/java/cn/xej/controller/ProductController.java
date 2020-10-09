package cn.xej.controller;

import cn.xej.common.RespObj;
import cn.xej.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 获取该用户的所有产品
     */
    @GetMapping("/initProductTable")
    public RespObj initProductTable(int currentPage,Authentication authentication){
        return productService.initProductTable(currentPage,authentication);
    }

    /**
     * 删除产品根据产品id
     */
    @DeleteMapping("/delProduct/{id}")
    public RespObj delProduct(@PathVariable("id")int id){
        System.out.println("删除产品 id "+id);
        return productService.delProduct(id);
    }


    /**
     * 获取产品根据产品id
     */
    @GetMapping("/getProduct/{id}")
    public RespObj getProduct(@PathVariable("id")int id){
        return productService.getProduct(id);
    }


    @DeleteMapping("/del/{id}")
    public String del(@PathVariable("id")int id){
        System.out.println("删除");
        return "xxx";
    }


    @DeleteMapping("/dd")
    public String dd(){
        System.out.println("删除dd");
        return "dd";
    }


    @GetMapping("/dds/{id}")
    public String dds(@PathVariable("id")int id){
        System.out.println("id  "+id);
        return "dds";
    }

    @PostMapping("/sss")
    public String sss(int id,String name){
        System.out.println("sss id "+id+" name "+name);
        return "sss tianjia";
    }


    @PutMapping("/put")
    public String put(){
        return "put";
    }
}
