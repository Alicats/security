package cn.xej.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class User {

    /**
     * 主键id
     */
    private int id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 注册时间
     */
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 组织id
     */
    private int orgId;

    /**
     * 0无效用户，1是有效用户
     */
    private int enabled;

    /**
     * 手机号
     */
    private String phone;


    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户角色
     */
    private Role role;
}
