package com.submerge.subfriends.service;

import com.submerge.subfriends.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.submerge.subfriends.model.request.UserRegisterRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Lenovo
 * @description 针对表【user(用户)】的数据库操作Service
 * @createDate 2023-08-03 21:51:08
 */
public interface UserService extends IService<User> {


    /**
     * 用户注册
     * @param userRegisterRequest
     * @return
     */
    long userRegister(UserRegisterRequest userRegisterRequest);

    /**
     * 用户登录
     *
     * @param userAccount  用户账户
     * @param userPassword 用户密码
     * @param request      http请求
     * @return 脱敏后的用户信息
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 用户脱敏
     *
     * @param originUser user参数
     * @return safetyUser对象
     */
    User getSafetyUser(User originUser);

    /**
     * 用户注销
     *
     * @param request 请求
     * @return
     */
    int userLogout(HttpServletRequest request);


    /**
     * 根据标签搜索用户
     *
     * @param tagNameList 用户要拥有的标签
     * @return
     */
    List<User> searchUserByTags(List<String> tagNameList);

    List<User> memorySearch(List<String> tagNameList);

    /**
     * 更新用户信息
     *
     * @param user
     * @param loginUser
     * @return
     */
    Integer updateUser(User user, User loginUser);

    /**
     * 获取当前登录用户信息
     *
     * @return
     */
    User getLoginUser(HttpServletRequest request);


    /**
     * 是否为管理员
     *
     * @param request http请求
     * @return boolean值
     */
    boolean isAdmin(HttpServletRequest request);

    /**
     * 是否为管理员
     *
     * @param loginUser
     * @return boolean值
     */
    boolean isAdmin(User loginUser);

    /**
     * 获取当前用户
     * @param request
     * @return
     */
    User getCurrentUser(HttpServletRequest request);


    /**
     * 匹配用户
     *
     * @param num
     * @param loginUser
     * @return
     */
    List<User> matchUsers(long num, User loginUser);
}
