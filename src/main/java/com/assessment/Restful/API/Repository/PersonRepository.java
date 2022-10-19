package com.assessment.Restful.API.Repository;

import com.assessment.Restful.API.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = "SELECT * FROM person  WHERE email = ?1",nativeQuery = true)
    Optional<Person> findByEmail(String email);
}
