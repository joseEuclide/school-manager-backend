package com.escola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.escola.dto.Login;
import com.escola.service.LoginService;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {
	
	@Autowired
    private LoginService ls;
	
	 
	@PostMapping(value =  "/login", consumes="application/json", produces="application/json")
    public ResponseEntity<Login> login(@RequestBody Login login) {
		if(login!= null) {
        	
        	login.setUsername(login.getUsername());
        	login.setPassword(login.getPassword());
        	login =  ls.findByUsername(login);
        	
        }
		return ResponseEntity.ok(login);
    }

}
