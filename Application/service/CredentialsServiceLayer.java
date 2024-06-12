// CredentialsServiceLayer.java
package com.signup.Application.service;

import com.signup.Application.DAO.CredentialsDAO;
import com.signup.Application.Entity.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CredentialsServiceLayer {

    private final CredentialsDAO credentialsDAO;

    @Autowired
    public CredentialsServiceLayer(CredentialsDAO credentialsDAO) {
        this.credentialsDAO = credentialsDAO;
    }

    public void save(Credentials credentials) {
        credentialsDAO.save(credentials);
    }

    public boolean check(String mail) {
        return credentialsDAO.findByMail(mail) != null;
    }
}
