package com.scweb.projectservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.scweb.projectservice.dto.SampleDto;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.ExtensionMethod;

import java.util.List;

@Entity

@Getter
@Setter
@Table(name = "sample")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sample {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image_path")
    private String imagePath;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "stage_id", referencedColumnName = "id")
    private Stage stage;

    @OneToMany(mappedBy = "sample", fetch = FetchType.EAGER, targetEntity = SampleField.class)
    private List<SampleField> sampleFieldList;

}
