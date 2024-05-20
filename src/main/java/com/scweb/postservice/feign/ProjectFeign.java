package com.scweb.postservice.feign;

import com.scweb.postservice.dto.SampleDto;
import com.scweb.postservice.dto.SampleFieldDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "PROJECT-SERVICE", url = "http://localhost:8080")
public interface ProjectFeign {
    @GetMapping("/stage/sample")
    ResponseEntity<List<SampleDto>> getAllSamples(@RequestParam(name = "stageId") Long stageId);

    @GetMapping("/stage/sample/field")
    ResponseEntity<List<SampleFieldDto>> getAllFields(@RequestParam(name = "sampleId") Long sampleId);

}
