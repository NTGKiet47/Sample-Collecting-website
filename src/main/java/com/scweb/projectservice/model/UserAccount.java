package com.scweb.projectservice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @Column(name = "user_id")
    private String userId;

    @JsonManagedReference
    @OneToMany(mappedBy = "userAccount", fetch = FetchType.LAZY
            , cascade = CascadeType.PERSIST, targetEntity = Project.class)
    List<Project> projectList;
}
