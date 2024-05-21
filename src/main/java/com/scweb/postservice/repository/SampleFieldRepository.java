package com.scweb.postservice.repository;

import com.scweb.postservice.model.SampleField;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleFieldRepository extends JpaRepository<SampleField, Long> {
}