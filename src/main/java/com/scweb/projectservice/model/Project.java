package com.scweb.projectservice.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "projectName")
    private String projectName;

    @Column(name = "projectDesc")
    private String projectDesc;

    @ManyToOne
    @JoinColumn(name = "ownerId", referencedColumnName = "userId")
    private UserAccount userAccount;

    @OneToMany(mappedBy = "project")
    private List<Sample> sampleList;
}
