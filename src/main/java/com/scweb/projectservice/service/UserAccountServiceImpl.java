package com.scweb.projectservice.service;

import com.scweb.projectservice.model.UserAccount;
import com.scweb.projectservice.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountServiceImpl implements UserAccountService{
    UserAccountRepository userAccountRepository;

    @Autowired
    public UserAccountServiceImpl (UserAccountRepository userAccountRepository){
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public UserAccount findByUserId(String userId) {
        return userAccountRepository.findByUserId(userId);
    }
}
