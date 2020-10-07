package cn.xej.common;

import lombok.Data;

import java.util.List;

@Data
public class VueMenu {

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 菜单url
     */
    private String index;

    /**
     * 菜单名称
     */
    private String title;

    /**
     * 菜单子节点
     */
    private List<VueMenu> subs;

}
