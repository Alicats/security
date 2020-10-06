package cn.xej.mapper;

import cn.xej.pojo.MyUserDetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MyUserDetailsServiceMapper {
    // 根据用户名获取该用户信息
    MyUserDetails findByUserName(String userId);

    // 根据用户名获取该用户角色
    List<String> findRoleByUserName(String userId);

    // 根据用户角色获取该用户的权限
    List<String> findAuthorityByRoleCodes(@Param("roleCodes") List<String> roleCodes);

    // 根据用户名称获取该用户的权限
    List<String> findUrlsByUserName(String userId);
}
