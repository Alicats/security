package cn.xej.pojo;


import lombok.Data;

@Data
public class Menu {

    /**
     * 主键id
     */
    private int id;

    /**
     * 父菜单id
     */
    private int menuPid;

    /**
     * 当前菜单所有父菜单
     */
    private String menuPids;

    /**
     * 是不是叶子节点  0不是叶子节点，1是叶子节点
     */
    private int isLeaf;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 跳转url
     */
    private String url;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 图标颜色
     */
    private String iconColor;

    /**
     * 排序
     */
    private int sort;

    /**
     * 菜单层级
     */
    private int level;

    /**
     * 菜单是否禁用
     */
    private int status;
}
