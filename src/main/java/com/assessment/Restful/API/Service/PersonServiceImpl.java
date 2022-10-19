package com.assessment.Restful.API.Service;

import com.assessment.Restful.API.Entity.Person;
import com.assessment.Restful.API.Repository.PersonRepository;
import com.assessment.Restful.API.Util.ResponseHandlerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Map<String, Object> save(Person newPerson) {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        if (personRepository.findByEmail(newPerson.getEmail()).isEmpty()){
            data.put(ResponseHandlerUtil.PERSON_ID, personRepository.save(newPerson).getId());
            response.put(ResponseHandlerUtil.RESPONSE_DATA, data);
            response.put(ResponseHandlerUtil.RESPONSE_TIMESTAMP, new Date().toString());
        } else {
            response.put(ResponseHandlerUtil.ERROR, ResponseHandlerUtil.EMAIL_EXISTS);
            response.put(ResponseHandlerUtil.RESPONSE_TIMESTAMP, new Date().toString());
        }
       return response;
    }

    @Override
    public Optional<Person> personById(Long personId) {
        Optional<Person> person =  personRepository.findById(personId);
        return person;
    }

    @Override
    public List<Person> getAllPersons() {
        List<Person> personsList = personRepository.findAll();
        List<Person> filteredPersonList = personsList.stream()
                                                    .filter(age -> age.getAge() > 35)
                                                    .collect(Collectors.toList());
        return filteredPersonList;
    }
}
