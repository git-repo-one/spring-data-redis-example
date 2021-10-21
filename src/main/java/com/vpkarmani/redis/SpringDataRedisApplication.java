package com.vpkarmani.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vpkarmani.redis.model.Account;
import com.vpkarmani.redis.model.Person;
import com.vpkarmani.redis.repository.AccountRepository;
import com.vpkarmani.redis.repository.PersonRepository;

@SpringBootApplication
public class SpringDataRedisApplication implements CommandLineRunner {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRedisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// save few accounts
		accountRepository.save(new Account("id1", "123456", Account.Type.SAVINGS, Double.valueOf(100)));
		accountRepository.save(new Account("id2", "567890", Account.Type.CHECKING, Double.valueOf(200)));
		accountRepository.save(new Account("id3", "456743", Account.Type.SAVINGS, Double.valueOf(50)));

		// fetch all accounts
		System.out.println("Accounts found with findAll():");
		System.out.println("-------------------------------");
		for (final Account account : accountRepository.findAll()) {
			System.out.println(account);
		}

		System.out.println();

		System.out.println("Account found with findById('id1'):");
		System.out.println("--------------------------------");
		System.out.println(accountRepository.findById("id1"));

		System.out.println("\n//------------------------------------------------------------\n");

		personRepository.save(new Person("p1", "first name 1", "last name 1"));
		personRepository.save(new Person("p2", "first name 2", "last name 2"));
		personRepository.save(new Person("p3", "first name 3", "last name 3"));

		// fetch all accounts
		System.out.println("Persons found with findAll():");
		System.out.println("-------------------------------");
		for (final Person person : personRepository.findAll()) {
			System.out.println(person);
		}

		System.out.println();

		System.out.println("Person found with findById('p1'):");
		System.out.println("--------------------------------");
		System.out.println(personRepository.findById("p1"));

		System.exit(0);
	}
}
