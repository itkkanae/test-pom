package com.example.consumer.feign.hystrix;

import com.example.common.dto.Product;
import com.example.consumer.feign.QualitiesFeign;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class QualitiesHystrix implements QualitiesFeign {
    @Override
    public List<Product> selectProductByExample(QualityExample example) {
        return new ArrayList<>();
    }

    @Override
    public boolean insertQuality(QualityReg reg) {
        return false;
    }

}
