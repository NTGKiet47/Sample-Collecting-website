package com.scweb.projectservice.service;

import com.scweb.projectservice.model.UserAccount;

public interface UserAccountService {
    UserAccount findByUserId(String userId);
}
