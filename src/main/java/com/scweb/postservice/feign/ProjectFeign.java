package com.scweb.postservice.feign;

import com.scweb.postservice.dto.SampleDto;
import com.scweb.postservice.dto.SampleFieldDto;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "project-service", url = "http://localhost:8080/api/project")
public interface ProjectFeign {
    @GetMapping("/stage/sample/getSampleById")
    SampleDto getSampleById(@RequestParam(name = "sampleId") Long sampleId);

    @GetMapping("/stage/sample/field")
    List<SampleFieldDto> getAllFields(@RequestParam(name = "sampleId") Long sampleId);

    @GetMapping("/stage/sample/getSampleList")
    List<SampleDto> getSampleList(@RequestParam List<Long> sampleIdList);

}
