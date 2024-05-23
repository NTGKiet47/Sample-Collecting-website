package com.scweb.postservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sample", schema = "scpostservice")
public class Sample {
    @EmbeddedId
    private SampleId id;

    @JsonIgnore
    @MapsId("postId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @Column(name = "image_path", nullable = false, length = 100)
    private String imagePath;

    @OneToMany(mappedBy = "sample", cascade = CascadeType.ALL)
    private Set<SampleField> sampleFields = new LinkedHashSet<>();

}