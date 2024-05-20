package com.scweb.projectservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "sample")
@Builder
public class Sample {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image_path")
    private String imagePath;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "stage_id", referencedColumnName = "id")
    private Stage stage;

    @JsonManagedReference
    @OneToMany(mappedBy = "sample", fetch = FetchType.EAGER, targetEntity = SampleField.class)
    private List<SampleField> sampleFieldList;
}
