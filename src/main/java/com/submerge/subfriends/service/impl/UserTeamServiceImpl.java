package com.submerge.subfriends.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.submerge.subfriends.mapper.UserTeamMapper;
import com.submerge.subfriends.model.domain.UserTeam;
import com.submerge.subfriends.service.UserTeamService;
import org.springframework.stereotype.Service;

/**
* @author Lenovo
* @description 针对表【user_team(用户队伍关系)】的数据库操作Service实现
* @createDate 2024-03-09 16:07:35
*/
@Service
public class UserTeamServiceImpl extends ServiceImpl<UserTeamMapper, UserTeam>
    implements UserTeamService {

}




