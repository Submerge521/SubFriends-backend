package com.submerge.usercenter.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: UserLoginRequest
 * Package: com.submerge.usercenter.model.request
 * Description:
 *
 * @Author Submerge--WangDong
 * @Create 2023-08-04 19:39
 * @Version 1.0
 */
@Data
public class UserLoginRequest implements Serializable {


    private static final long serialVersionUID = 404578072120891250L;

    private String userAccount;
    private String userPassword;


}
