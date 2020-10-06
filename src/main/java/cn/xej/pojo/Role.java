package cn.xej.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Role {

    /**
     * 主键id
     */
    private int id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色描述
     */
    private String roleDesc;


    /**
     * 角色编号
     */
    private String roleCode;

    /**
     * 角色顺序
     */
    private int sort;

    /**
     * 角色是否可用  0可用
     */
    private int status;

    /**
     * 角色创建日期
     */
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

}
