package com.escola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.escola.dto.Login;
import com.escola.service.LoginService;

public class LoginController {
	
	@Autowired
    private LoginService ls;
	
	 
	@GetMapping(value =  "/login/{username}/{password}", produces="application/json")
    public ResponseEntity<Login> login(@PathVariable String username,@PathVariable String password) {
		Login login = new Login();
		if(username != null && password != null) {
        	
        	login.setUsername(username);
        	login.setPassword(password);
        	login =  ls.findByUsername(login);
        	
        }
		return ResponseEntity.ok(login);
    }

}
