package com.submerge.subfriends.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: TeamAddRequest
 * Package: com.submerge.subfriends.model.request
 * Description: 用户退出队伍请求包装类
 *
 * @Author Submerge--WangDong
 * @Create 2024-03-09 18:24
 * @Version 1.0
 */
@Data
public class TeamQuitRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 要退出的队伍id
     */
    private Long teamId;



}
