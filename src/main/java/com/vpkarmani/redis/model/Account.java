package com.vpkarmani.redis.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@RedisHash(value =  "account", timeToLive = 60)
public class Account {

	public enum Type {
		SAVINGS, CHECKING
	}

	@Id
	private String id;

	private String accountNumber;

	private Account.Type accountType;

	private Double balance;
}
