package org.example.wecommerce.repositories;

import org.example.wecommerce.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserName(String userName);
    @Query("from User where eMail=:eMail")
    User findByEMail(String eMail);
}
