package com.submerge.subfriends.model.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: TeamAddRequest
 * Package: com.submerge.subfriends.model.request
 * Description:
 *
 * @Author Submerge--WangDong
 * @Create 2024-03-09 18:24
 * @Version 1.0
 */
@Data
public class TeamJoinRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 要加入的队伍id
     */
    private Long teamId;


    /**
     * 密码
     */
    private String password;


}
