package com.scweb.postservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "sample_field", schema = "scpostservice")
public class SampleField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "field_name", nullable = false, length = 100)
    private String fieldName;

    @Column(name = "field_value", nullable = false, length = 100)
    private String fieldValue;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sample_id", nullable = false)
    private Sample sample;

}