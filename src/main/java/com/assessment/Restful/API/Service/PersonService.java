package com.assessment.Restful.API.Service;

import com.assessment.Restful.API.Entity.Person;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public interface PersonService {

    Map<String, Object> save(Person newPerson);
    Optional<Person> personById(Long personId);
    List<Person> getAllPersons();
}
