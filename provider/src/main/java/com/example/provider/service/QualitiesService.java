package com.example.provider.service;

import com.example.provider.mapper.QualitiesMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class QualitiesService {

    @Resource
    private QualitiesMapper qualitiesMapper;

}
