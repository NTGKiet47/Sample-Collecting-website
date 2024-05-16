package com.scweb.postservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user_account")
public class UserAccount {
    @Id
    @Column(name = "user_id")
    private String userId;

    @OneToMany(mappedBy = "userAccount", cascade = CascadeType.PERSIST, targetEntity = Post.class)
    private List<Post> postList;
}
