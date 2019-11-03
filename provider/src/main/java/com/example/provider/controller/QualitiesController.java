package com.example.provider.controller;

import com.example.provider.service.QualitiesService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/qualities")
public class QualitiesController {

    @Resource
    private QualitiesService qualitiesService;

}
