package cn.xej.config.auth.jwt;

import cn.xej.config.exception.AjaxResponse;
import cn.xej.config.exception.CustomException;
import cn.xej.config.exception.CustomExceptionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class JwtAuthController {

    @Autowired
    private JwtAuthService jwtAuthService;

    @PostMapping("/authentication")
    public AjaxResponse login(@RequestBody Map<String,String> map){
        String username = map.get("username");
        String password = map.get("password");

        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            return AjaxResponse.error(new CustomException(CustomExceptionType.USER_INPUT_ERROR,"用户名或者密码不能为空"));
        }

        try {
            return AjaxResponse.success(jwtAuthService.login(username,password));
        }catch (CustomException e){
            return AjaxResponse.error(e);
        }
    }


    @GetMapping("/refreshToken")
    public AjaxResponse refreshToken(@RequestHeader("${jwt.header}")String token){
        return AjaxResponse.success(jwtAuthService.refreshToken(token));
    }

}
