package com.submerge.subfriends.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.submerge.subfriends.common.BaseResponse;
import com.submerge.subfriends.common.ErrorCode;
import com.submerge.subfriends.common.ResultUtils;
import com.submerge.subfriends.exception.BusinessException;
import com.submerge.subfriends.model.domain.User;
import com.submerge.subfriends.model.request.UserLoginRequest;
import com.submerge.subfriends.model.request.UserRegisterRequest;
import com.submerge.subfriends.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

import static com.submerge.subfriends.constant.UserConstant.ADMIN_ROLE;
import static com.submerge.subfriends.constant.UserConstant.USER_LOGIN_STATE;

/**
 * ClassName: UserController
 * Package: com.submerge.usercenter.controller
 * Description: 用户接口
 *
 * @Author Submerge--WangDong
 * @Create 2023-08-04 18:58
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/register")
    public BaseResponse<Long> userRegister(@RequestBody UserRegisterRequest userRegisterRequest) {
        if (userRegisterRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        String userAccount = userRegisterRequest.getUserAccount();
        String userPassword = userRegisterRequest.getUserPassword();
        String checkPassword = userRegisterRequest.getCheckPassword();
        String stuCode = userRegisterRequest.getStuCode();
        if (StringUtils.isAnyBlank(userAccount, userPassword, checkPassword, stuCode)) {
            return null;
        }
        long result = userService.userRegister(userAccount, userPassword, checkPassword, stuCode);
//        return new BaseResponse<>(0, result,"OK");
        return ResultUtils.success(result);
    }


    @PostMapping("/login")
    public BaseResponse<User> userLogin(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request) {
        if (userLoginRequest == null) {
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }
        String userAccount = userLoginRequest.getUserAccount();
        String userPassword = userLoginRequest.getUserPassword();
        if (StringUtils.isAnyBlank(userAccount, userPassword)) {
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }
        User user = userService.userLogin(userAccount, userPassword, request);
//        return new BaseResponse<>(0, user,"OK");
        return ResultUtils.success(user);
    }

    @PostMapping("/logout")
    public BaseResponse<Integer> userLogout(HttpServletRequest request) {
        if (request == null) {
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }
        int result = userService.userLogout(request);
        return ResultUtils.success(result);
    }

    @GetMapping("/current")
    public BaseResponse<User> getCurrentUser(HttpServletRequest request) {
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User currentUser = (User) userObj;
        if (currentUser == null) {
            throw new BusinessException(ErrorCode.NOT_LOGIN);
        }
        long userId = currentUser.getId();
        User user = userService.getById(userId);
        User safetyUser = userService.getSafetyUser(user);
        return ResultUtils.success(safetyUser);
    }


    @GetMapping("/search")
    public BaseResponse<List<User>> searchUsers(String userName, HttpServletRequest request) {

        if (!isAdmin(request)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(userName)) {
            queryWrapper.like("userName", userName);
        }
        List<User> userList = userService.list();
        List<User> collect = userList.stream().map(user -> userService.getSafetyUser(user)).collect(Collectors.toList());
        return ResultUtils.success(collect);
    }

    @PostMapping("/delete")
    public BaseResponse<Boolean> deleteUser(@RequestBody long id, HttpServletRequest request) {
        if (!isAdmin(request)) {
            throw new BusinessException(ErrorCode.NO_AUTH);
        }
        if (id <= 0) {
            throw new BusinessException(ErrorCode.NO_AUTH);
        }
        boolean b = userService.removeById(id);
        return ResultUtils.success(b);
    }


    /**
     * 是否为管理员
     *
     * @param request http请求
     * @return boolean值
     */
    private boolean isAdmin(HttpServletRequest request) {
        // 鉴权  仅管理员可查询
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User user = (User) userObj;
        if (user == null || user.getUserRole() != ADMIN_ROLE) {
            throw new BusinessException(ErrorCode.NO_AUTH);
        }
        return true;
    }
}
