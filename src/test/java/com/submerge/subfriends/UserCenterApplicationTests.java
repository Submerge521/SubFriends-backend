package com.submerge.subfriends;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.security.NoSuchAlgorithmException;

@SpringBootTest
class SubFriendsApplicationTests {

	@Test
	void testDegist() throws NoSuchAlgorithmException {
		String newPassword = DigestUtils.md5DigestAsHex(("abcd"+"mypassword").getBytes());
		System.out.println(newPassword);


	}

	@Test
	void contextLoads() {
	}

}
