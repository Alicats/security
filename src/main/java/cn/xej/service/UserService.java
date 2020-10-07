package cn.xej.service;

import cn.xej.common.VueMenu;
import cn.xej.pojo.Menu;
import cn.xej.pojo.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public interface UserService {

    User getUser(String username);

    LinkedList<VueMenu> initMenu(List<Menu> menuList);
}
