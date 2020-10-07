package cn.xej.service.impl;

import cn.xej.common.RespObj;
import cn.xej.mapper.ProductMapper;
import cn.xej.pojo.Product;
import cn.xej.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    /**
     * 获取该用户的所有产品
     * @param username
     * @return
     */
    @Override
    public RespObj initProductTable(String username) {

        List<Product> productList = productMapper.getProductList(username);
        return RespObj.succ(productList);
    }
}
