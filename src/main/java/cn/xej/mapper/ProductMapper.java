package cn.xej.mapper;

import cn.xej.pojo.Product;

import java.util.List;

public interface ProductMapper {
    List<Product> getProductList(String username,int pageIndex,int pageSize);

    int getProductListCount(String username);

    void delProduct(int id);

    Product getProduct(int id);
}
