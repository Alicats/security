package cn.xej.service;

import cn.xej.common.RespObj;
import cn.xej.pojo.Product;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface ProductService {

    // 获取该用户的所有产品
    RespObj initProductTable(int currentPage,Authentication authentication);

    // 删除产品根据产品id
    RespObj delProduct(int id);

    // 获取产品根据产品id
    RespObj getProduct(int id);
}
