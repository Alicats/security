package cn.xej.service.impl;

import cn.xej.common.Constance;
import cn.xej.common.RespObj;
import cn.xej.common.Utils;
import cn.xej.mapper.ProductMapper;
import cn.xej.pojo.Product;
import cn.xej.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    /**
     * 获取该用户的所有产品
     * @param authentication
     * @return
     */
    @Override
    public RespObj initProductTable(int currentPage,Authentication authentication) {
        Map<String,Object> map = new HashMap<>();

        String username = ((UserDetails)(authentication.getPrincipal())).getUsername();

        List<Product> productList = productMapper.getProductList(username, Utils.getPageIndex(currentPage),Constance.PAGE_SIZE);
        int productListCount = productMapper.getProductListCount(username);

        map.put("productList",productList);
        map.put("productListCount",productListCount);
        map.put("pageSize",Constance.PAGE_SIZE);
        return RespObj.succ(map);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public RespObj delProduct(int id) {
        productMapper.delProduct(id);
        return RespObj.succ(null);
    }

    /**
     * 获取产品根据产品id
     * @param id
     * @return
     */
    @Override
    public RespObj getProduct(int id) {
        Product product = productMapper.getProduct(id);
        System.out.println(product);
        return RespObj.succ(product);
    }
}
