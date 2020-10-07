package cn.xej.service.impl;

import cn.xej.common.Utils;
import cn.xej.common.VueMenu;
import cn.xej.mapper.UserMapper;
import cn.xej.pojo.Menu;
import cn.xej.pojo.User;
import cn.xej.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUser(String username) {
        User user = userMapper.getUser(username);
        return user;
    }


    @Override
    public LinkedList<VueMenu> initMenu(List<Menu> menuList) {
        LinkedList<VueMenu> menuLinkedList = new LinkedList<>();
        for(Menu menu:menuList){
            List<VueMenu> vueMenuList = new ArrayList<>();
            if(menu.getMenuPid() == 0){
                VueMenu vueMenu = new VueMenu();
                vueMenu.setIcon("el-icon-lx-cascades");
                vueMenu.setTitle(menu.getMenuName());
                if(menu.getUrl().equals("") || menu.getUrl() == null){
                    vueMenu.setIndex(String.valueOf(menu.getId()));
                }else {
                    vueMenu.setIndex(menu.getUrl().substring(1));
                }

                if(menu.getIsLeaf() == 0) {
                    List<VueMenu> vueMenus = Utils.getChildrenMenu(menu, menuList, vueMenuList);
                    vueMenu.setSubs(vueMenus);
                }

                menuLinkedList.add(vueMenu);
            }
        }

        return menuLinkedList;
    }
}
