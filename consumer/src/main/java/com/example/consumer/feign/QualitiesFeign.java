package com.example.consumer.feign;

import com.example.consumer.feign.hystrix.QualitiesHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(name = "spring-cloud-provider", fallback = QualitiesHystrix.class)
public interface QualitiesFeign {


}
