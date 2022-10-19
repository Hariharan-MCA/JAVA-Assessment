package com.assessment.Restful.API.Controller;

import com.assessment.Restful.API.Entity.Person;
import com.assessment.Restful.API.Service.PersonService;
import com.assessment.Restful.API.Service.ResponseHandler;
import com.assessment.Restful.API.Util.ResponseHandlerUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Log4j2
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/person")
    public ResponseEntity<Object> createPersons(@Valid @RequestBody Person person){
        log.info(ResponseHandlerUtil.PERSON_CREATE_API_INVOKED);
        Map<String, Object> data = personService.save(person);
        if (data.containsKey(ResponseHandlerUtil.ERROR)){
            return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
        } else {
            data.put(ResponseHandlerUtil.RESPONSE, ResponseHandlerUtil.RESPONSE_SUCCESS_MESSAGE);
            return new ResponseEntity<>(data, HttpStatus.CREATED);
        }
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Object> getPersonById(@PathVariable Long id){
        log.info(ResponseHandlerUtil.PERSON_SEARCH_BY_ID_API_INVOKED);
        Map<String, Object> data = new HashMap<>();
        Optional<Person> personByID = personService.personById(id);
        if (personByID.isEmpty()){
            data.put(ResponseHandlerUtil.PERSON, ResponseHandlerUtil.NO_RECORD + " " + ResponseHandlerUtil.PERSON_ID + " : " + id );
        } else {
            data.put(ResponseHandlerUtil.PERSON, personByID);
        }
        return ResponseHandler.generateResponse(HttpStatus.OK, data);
    }

    @GetMapping("/persons")
    public ResponseEntity<Object> getPersons(){
        log.info(ResponseHandlerUtil.PERSON_LIST_API_INVOKED);
        Map<String, Object> data = new HashMap<>();
        List<Person> personsList = personService.getAllPersons();
        if (personsList.isEmpty()){
            data.put(ResponseHandlerUtil.PERSON, ResponseHandlerUtil.NO_RECORD);
            return ResponseHandler.generateResponse(HttpStatus.OK, data);
        } else {
            data.put(ResponseHandlerUtil.PERSON, personsList);
            return ResponseHandler.generateResponse(HttpStatus.OK, data);
        }
    }
}
