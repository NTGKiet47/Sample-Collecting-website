package com.scweb.projectservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "sample_field")
public class SampleField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fieldName")
    private String fieldName;

    @Column(name = "fieldValue")
    private String fieldValue;

    @ManyToOne
    @JoinColumn(name = "sampleId", referencedColumnName = "id")
    private Sample sample;
}
