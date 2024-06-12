// CredentialsDAO.java
package com.signup.Application.DAO;

import com.signup.Application.Entity.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialsDAO extends JpaRepository<Credentials, String> {
    Credentials findByMail(String mail);
}
