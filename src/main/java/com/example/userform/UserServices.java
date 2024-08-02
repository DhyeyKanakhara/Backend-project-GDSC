package com.example.userform;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServices {
    @Autowired
    UserRepository repository;

    public List<User> getAllEmployees()
    {
        return repository.findAll();
    }

    public User create(User user) throws Exception{
        repository.findById(user.getId()).ifPresent(x->{
            throw new RuntimeException("UserId Already Exists");
        });
        return repository.save(user);
    }
}
