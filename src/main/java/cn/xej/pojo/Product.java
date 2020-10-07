package cn.xej.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Product {

    /**
     * 主键id
     */
    private int id;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品简介
     */
    private String introduce;

    /**
     * 产品状态   0表示未审核，1表示审核通过
     */
    private int status;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 产品封面真实路径
     */
    private String productImageRealPath;

    /**
     * 产品封面网络路径
     */
    private String productImageDbPath;

    /**
     * 产品创建人
     */
    private String username;
}
