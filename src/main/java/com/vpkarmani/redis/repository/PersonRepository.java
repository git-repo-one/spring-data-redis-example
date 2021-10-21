package com.vpkarmani.redis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vpkarmani.redis.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, String> {

}
