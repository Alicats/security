package cn.xej;

import cn.xej.mapper.ProductMapper;
import cn.xej.pojo.Product;
import cn.xej.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SecurityApplicationTests {

    @Resource
    private ProductMapper productMapper;

    @Test
    void contextLoads() {

        Product product = productMapper.getProduct(2);
        System.out.println(product);

    }

}
