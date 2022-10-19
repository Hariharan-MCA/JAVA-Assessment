package com.assessment.Restful.API.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.assessment.Restful.API.Util.ResponseHandlerUtil.*;


/**
 * This class is used to handle the response structure of every API Call
 */
public class ResponseHandler {

    /**
     *
     * @param status - Status indicades the HTTPStatus of API Call
     * @param responseObj -
     * @return
     */
    public static ResponseEntity<Object> generateResponse(HttpStatus status, Object responseObj) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put(RESPONSE_TIMESTAMP, new Date());
            map.put(RESPONSE_STATUS, status.value());
            map.put(RESPONSE_DATA, responseObj);
            map.put(RESPONSE, RESPONSE_SUCCESS_MESSAGE);
            return new ResponseEntity<Object>(map,status);
        } catch (Exception e) {
            map.clear();
            map.put(RESPONSE_TIMESTAMP, new Date());
            map.put(RESPONSE_STATUS, HttpStatus.INTERNAL_SERVER_ERROR.value());
            map.put(RESPONSE_FAILURE_MESSAGE, e.getMessage());
            map.put(RESPONSE_DATA, null);
            return new ResponseEntity<Object>(map,status);
        }
    }
}
