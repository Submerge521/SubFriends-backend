package com.submerge.subfriends.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: UserRegisterRequest
 * Package: com.submerge.SubFriends.model.request
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
