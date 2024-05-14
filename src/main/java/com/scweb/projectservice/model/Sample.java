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
public class Sample {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "imagePath")
    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "projectId", referencedColumnName = "id")
    private Project project;

    @OneToMany(mappedBy = "sample")
    private List<SampleField> sampleFieldList;
}
