package com.example.userform;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping(value = "/form")
public class UserFormController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserServices userServices;


    @GetMapping(value = "/getAll",produces= MediaType.APPLICATION_JSON_VALUE)
    public GenericResponse getAll(){
        GenericResponse genericResponse = new GenericResponse();
        try {
            genericResponse.setData(userServices.getAllEmployees());
            genericResponse.setMessage("Successful");
            genericResponse.setStatus(true);
            return genericResponse;
        }catch (Exception e){
            genericResponse.setData(null);
            genericResponse.setMessage(e.getMessage());
            genericResponse.setStatus(false);
            return genericResponse;
        }


    }

    @PostMapping(value="/addUser", consumes= MediaType.APPLICATION_JSON_VALUE)
    public GenericResponse addUser(@Valid @RequestBody User user){
        GenericResponse genericResponse = new GenericResponse();
        try {
            genericResponse.setData(userServices.create(user));
            genericResponse.setMessage("Successful");
            genericResponse.setStatus(true);
            return genericResponse;
        }catch (Exception e){
            genericResponse.setData(null);
            genericResponse.setMessage(e.getMessage());
            genericResponse.setStatus(false);
            return genericResponse;
        }
    }

}
