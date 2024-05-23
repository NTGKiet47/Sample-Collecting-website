package com.scweb.projectservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "user_account")
public class UserAccount {
    @Id
    @Column(name = "user_id")
    private String userId;

    @OneToMany(mappedBy = "userAccount", fetch = FetchType.LAZY
            , cascade = CascadeType.PERSIST, targetEntity = Project.class)
    List<Project> projectList;
}
