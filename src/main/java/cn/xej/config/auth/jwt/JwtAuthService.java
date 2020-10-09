package cn.xej.config.auth.jwt;

import cn.xej.common.VueMenu;
import cn.xej.config.auth.MyUserDetailsService;
import cn.xej.config.exception.CustomException;
import cn.xej.config.exception.CustomExceptionType;
import cn.xej.pojo.MyUserDetails;
import cn.xej.pojo.User;
import cn.xej.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class JwtAuthService {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private MyUserDetailsService myUserDetailsService;

    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @Resource
    private UserService userService;

    /**
     * 登录认证换取JWT令牌
     * @return JWT
     */
    public Map<String,Object> login(String username,String password){
        Map<String,Object> map = new HashMap<>();
        List<String> menuUrlList = new ArrayList<>();

        try {
            UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username,password);
            Authentication authenticate = authenticationManager.authenticate(upToken);
            SecurityContextHolder.getContext().setAuthentication(authenticate);
        }catch (AuthenticationException e){
            throw new CustomException(CustomExceptionType.USER_INPUT_ERROR,"用户名或者密码不正确");
        }


//        UserDetails userDetails = myUserDetailsService.loadUserByUsername(username);

        MyUserDetails myUserDetails = (MyUserDetails) myUserDetailsService.loadUserByUsername(username);

        Collection<? extends GrantedAuthority> authorities = myUserDetails.getAuthorities();

        // 获取该用户的菜单权限
        for (GrantedAuthority authority : authorities) {
            if(authority.getAuthority().substring(0,1).equals("/")){
                menuUrlList.add(authority.getAuthority().substring(1));
            }
        }

        String token = jwtTokenUtil.generateToken(myUserDetails);

        LinkedList<VueMenu> menuList = userService.initMenu(myUserDetails.getMenuList());

        User user = userService.getUser(myUserDetails.getUsername());

        map.put("menuUrlList",menuUrlList);
        map.put("token",token);
        map.put("user",user);
        map.put("menuList",menuList);


//        return jwtTokenUtil.generateToken(userDetails);
        return map;
    }


    /**
     * 刷新token
     */
    public String refreshToken(String oldToken){
        if(!jwtTokenUtil.isTokenExpired(oldToken)){
            return jwtTokenUtil.refreshToken(oldToken);
        }
        return null;

    }
}
