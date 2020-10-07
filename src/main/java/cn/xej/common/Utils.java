package cn.xej.common;

import cn.xej.pojo.Menu;

import java.util.LinkedList;
import java.util.List;

public class Utils {

    public static List<VueMenu> getChildrenMenu(Menu menu, List<Menu> menuList, List<VueMenu> vueMenuLinkedList){
        for (Menu menu1 : menuList) {
            if (menu1.getMenuPid() == menu.getId()) {
                VueMenu vueMenu = new VueMenu();
                vueMenu.setIcon("el-icon-lx-cascades");
                vueMenu.setTitle(menu1.getMenuName());
                vueMenu.setIndex(menu1.getUrl().substring(1));

                // 针对有3级节点的情况
                /*
                if(menu1.getIsLeaf() == 0) {
                    LinkedList<VueMenu> vueMenuLinkedList1 = new LinkedList<>();
                    LinkedList<VueMenu> vueMenus = getChildMenu(menu1, menuList, vueMenuLinkedList1);
                    vueMenu.setSubs(vueMenus);
                }
                */
                vueMenuLinkedList.add(vueMenu);
            }
        }



        return vueMenuLinkedList;
    }

    // 针对有3级节点的情况
    /*
    public static LinkedList<VueMenu> getChildMenu(Menu menu, List<Menu> menuList, LinkedList<VueMenu> vueMenuLinkedList){
        for (Menu menu1 : menuList) {
            if (menu1.getMenuPid() == menu.getId()) {
                VueMenu vueMenu = new VueMenu();
                vueMenu.setIcon("el-icon-lx-cascades");
                vueMenu.setTitle(menu1.getMenuName());
                vueMenu.setIndex(menu1.getUrl().substring(1));

                vueMenuLinkedList.add(vueMenu);
            }
        }

        return vueMenuLinkedList;
    }
    */
}
