package com.submerge.subfriends.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.submerge.subfriends.dto.TeamQuery;
import com.submerge.subfriends.model.domain.Team;
import com.submerge.subfriends.model.domain.User;
import com.submerge.subfriends.model.request.TeamJoinRequest;
import com.submerge.subfriends.model.request.TeamUpdateRequest;
import com.submerge.subfriends.model.vo.TeamUserVO;

import java.util.List;


/**
* @author Submerge
* @description 针对表【team(队伍)】的数据库操作Service
* @createDate 2024-03-09 16:05:49
*/
public interface TeamService extends IService<Team> {


    /**
     * 创建队伍
     * @param team
     * @param loginUser
     * @return
     */
    long addTeam(Team team, User loginUser);

    /**
     * 查询队伍列表
     * @param teamQuery
     * @return
     */
    List<TeamUserVO> listTeams(TeamQuery teamQuery,boolean isAdmin);

    /**
     * 更新队伍信息
     * @param teamUpdateRequest
     * @param  loginUser
     * @return
     */
    boolean updateTeam(TeamUpdateRequest teamUpdateRequest,User loginUser);

    /**
     * 加入队伍
     * @param teamJoinRequest
     * @return
     */
    boolean joinTeam(TeamJoinRequest teamJoinRequest,User loginUser);
}
