package com.vax.spring_security_demo.controller;

import com.vax.spring_security_demo.model.User;
import com.vax.spring_security_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    //@PreAuthorize("hasRole('ADMIN') or #type == 'ADMIN'")
    //@PostAuthorize("returnObject.body != null && returnObject.body.size() > 0")
    //@PostAuthorize("returnObject?.body.size() > 1")
    @GetMapping
    public ResponseEntity<List<User>> getUsers(@RequestParam(required = false) String type) {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
