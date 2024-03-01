package com.submerge.subfriends.once;

import com.submerge.subfriends.mapper.UserMapper;
import com.submerge.subfriends.model.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;

/**
 * ClassName: InsertUsers
 * Package: com.submerge.subfriends.once
 * Description:
 *
 * @Author Submerge--WangDong
 * @Create 2024-03-01 20:58
 * @Version 1.0
 */
@Component
public class InsertUsers {

    @Resource
    private UserMapper userMapper;

    /**
     * 批量插入用户
     */
//    @Scheduled(initialDelay = 5000,fixedRate = Long.MAX_VALUE )
    public void doInsertUser() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final int INSERT_NUM = 1000;
        for (int i = 0; i < INSERT_NUM; i++) {
            User user = new User();
            user.setUserName("小栋");
            user.setUserAccount("Submerge");
            user.setAvatarUrl("https://oss.1381801.com/forum/202308/11/093616ccxkx99wchwrrw1a.jpg");
            user.setGender(0);
            user.setUserPassword("12345678");
            user.setPhone("123456789108");
            user.setEmail("submerge0521@163.com");
            user.setUserStatus(0);
            user.setUserRole(0);
            user.setStuCode("20043170101");
            user.setTags("[]");
            userMapper.insert(user);
        }
        stopWatch.stop();
        System.out.println(stopWatch.getLastTaskTimeMillis());

    }
}



