package com.scweb.postservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "sample", schema = "scpostservice")
public class Sample {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "image_path", nullable = false, length = 100)
    private String imagePath;

    @JsonIgnore
    @ManyToMany(mappedBy = "samples")
    private Set<Post> posts = new LinkedHashSet<>();

    @OneToMany(mappedBy = "sample", cascade = CascadeType.ALL)
    private Set<SampleField> sampleFields = new LinkedHashSet<>();
}