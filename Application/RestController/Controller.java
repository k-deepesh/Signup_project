// Controller.java
package com.signup.Application.RestController;

import com.signup.Application.Entity.Credentials;
import com.signup.Application.service.CredentialsServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Controller {

    private final CredentialsServiceLayer credentialsServiceLayer;

    @Autowired
    public Controller(CredentialsServiceLayer credentialsServiceLayer) {
        this.credentialsServiceLayer = credentialsServiceLayer;
    }

    @PostMapping("/signup")
    public String signUp(@RequestBody Credentials credentials) {
        credentialsServiceLayer.save(credentials);
        return "You've successfully registered with mail id: " + credentials.getMail();
    }

    @PostMapping("/signin")
    public String signIn(@RequestBody Credentials credentials) {
        if (credentialsServiceLayer.check(credentials.getMail())) {
            return "Hey user, you logged in successfully";
        } else {
            return "Credentials not found, please try creating an account";
        }
    }
}
