package com.vpkarmani.redis.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@RedisHash(value =  "person", timeToLive = 120) // Long.parseLong("#{@environment.getProperty('prop.name')}")
public class Person {

	@Id
	private String id;

	private String firstName;

	private String lastName;
}
