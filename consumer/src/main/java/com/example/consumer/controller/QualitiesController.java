package com.example.consumer.controller;

import com.example.consumer.feign.QualitiesFeign;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "质检Controller")
@RestController
@RequestMapping(value = "/qualities")
public class QualitiesController {

    @Resource
    private QualitiesFeign qualitiesFeign;


}
