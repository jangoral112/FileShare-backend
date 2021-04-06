package com.jango.auth.service.controller;

import com.jango.auth.service.dto.UserAuthenticationRequest;
import com.jango.auth.service.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/authUser")
    public ResponseEntity<String> authenticateUser(@RequestBody UserAuthenticationRequest request) {

        String authToken = authenticationService.authenticateUser(request);

        return ResponseEntity.ok().header("Authorization", "bearer" + authToken).build();
    }


}
