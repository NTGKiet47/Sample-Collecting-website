package com.scweb.projectservice.repository;

import com.scweb.projectservice.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, String> {
    UserAccount findByUserId(String userId);
}
