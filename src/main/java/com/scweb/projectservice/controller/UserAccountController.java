package com.scweb.projectservice.controller;

import com.scweb.projectservice.model.UserAccount;
import com.scweb.projectservice.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserAccountController {
    private final UserAccountService userAccountService;
    @GetMapping
    public UserAccount findUser(@RequestParam("id") String userId){
        return userAccountService.findByUserId(userId);
    }
}
