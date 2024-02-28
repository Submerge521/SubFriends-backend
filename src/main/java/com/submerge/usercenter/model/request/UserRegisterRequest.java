package com.submerge.usercenter.model.request;

import com.submerge.usercenter.service.UserService;
import lombok.Data;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;

import java.io.Serializable;
import java.nio.file.attribute.UserPrincipal;

/**
 * ClassName: UserRegisterRequest
 * Package: com.submerge.usercenter.model.request
 * Description: 用户注册请求体
 *
 * @Author Submerge--WangDong
 * @Create 2023-08-04 19:08
 * @Version 1.0
 */
@Data
public class UserRegisterRequest implements Serializable {


    private static final long serialVersionUID = 404578072120891250L;

    private String userAccount;
    private String userPassword;
    private String checkPassword;
    private String stuCode;
}
