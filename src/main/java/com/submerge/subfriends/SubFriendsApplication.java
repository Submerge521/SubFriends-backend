package com.submerge.subfriends;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Submerge
 */
@SpringBootApplication
@MapperScan("com.submerge.subfriends.mapper")
public class SubFriendsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubFriendsApplication.class, args);
	}

}
