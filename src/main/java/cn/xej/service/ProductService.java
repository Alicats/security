package cn.xej.service;

import cn.xej.common.RespObj;
import cn.xej.pojo.Product;

import java.util.List;

public interface ProductService {

    // 获取该用户的所有产品
    RespObj initProductTable(String username);

}
