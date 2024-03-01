package com.submerge.subfriends;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Submerge
 */
@SpringBootApplication
@MapperScan("com.submerge.subfriends.mapper")
@EnableScheduling
public class SubFriendsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubFriendsApplication.class, args);
	}

}
