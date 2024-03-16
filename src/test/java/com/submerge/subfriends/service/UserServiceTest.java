package com.submerge.subfriends.service;

import java.util.Arrays;
import java.util.List;

import com.submerge.subfriends.model.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ClassName: UserServiceTest
 * Package: com.submerge.SubFriends.service
 * Description: 用户服务测试
 *
 * @Author Submerge--WangDong
 * @Create 2023-08-03 22:00
 * @Version 1.0
 */
@SpringBootTest
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void testAddUser() {
        User user = new User();

        user.setUserName("testSubmerge");
        user.setUserAccount("123");
        user.setAvatarUrl("https://thirdwx.qlogo.cn/mmopen/vi_32/zZbss2A6N5s6ZjMuuh3DqpV8OCkCCngzsyzyY9YUCicSIQxib3tH5TdJcbbZrvkYD5o9CnwJKFF4Kss1ibWqAHhVw/132");
        user.setGender(0);
        user.setUserPassword("xxx");
        user.setPhone("123");
        user.setEmail("456");

        boolean result = userService.save(user);
        System.out.println(user.getId());
        assertTrue(result);
    }

    @Test
    void userRegister() {
        String userAccount = "submerge";
        String userPassword = "";
        String checkPassword = "123456";
        String stuCode = "20043170106";
//        long result = userService.userRegister(userAccount, userPassword, checkPassword, stuCode);
//        assertEquals(-1, result);
//        userAccount = "su";
//        result = userService.userRegister(userAccount, userPassword, checkPassword, stuCode);
//        assertEquals(-1, result);
//        userAccount = "submerge";
//        userPassword = "123456";
//        result = userService.userRegister(userAccount, userPassword, checkPassword, stuCode);
//        assertEquals(-1, result);
//        userAccount = "sub merge";
//        userPassword = "12345678";
//        result = userService.userRegister(userAccount, userPassword, checkPassword, stuCode);
//        assertEquals(-1, result);
//
//        checkPassword = "123456789";
//        result = userService.userRegister(userAccount, userPassword, checkPassword, stuCode);
//        assertEquals(-1, result);
//
//        userAccount = "testSubmerge";
//        checkPassword = "12345678";
//        result = userService.userRegister(userAccount, userPassword, checkPassword, stuCode);
//        assertEquals(-1, result);
//
//        userAccount = "Submerge";
//        result = userService.userRegister(userAccount, userPassword, checkPassword, stuCode);
////        assertTrue(result > 0);
//        assertEquals(-1, result);
//    }
    }

    @Test
    void testSearchUserByTags() {
        List<String> tagNameList = Arrays.asList("java", "python");
        List<User> userList = userService.searchUserByTags(tagNameList);
        assertNotNull(userList);
    }

    @Test
    void testMemorySearch() {
        List<String> tagNameList = Arrays.asList("java", "python");
        List<User> userList = userService.memorySearch(tagNameList);
        assertNotNull(userList);
    }
}

