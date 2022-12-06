package com.bessada.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bessada.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {}
