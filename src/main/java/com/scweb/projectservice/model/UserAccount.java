package com.scweb.projectservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "user_account")
public class UserAccount {
    @Id
    @Column(name = "userId")
    private String userId;

    @OneToMany(mappedBy = "userAccount")
    List<Project> projectList;
}
