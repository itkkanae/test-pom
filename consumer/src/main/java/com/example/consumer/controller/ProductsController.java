package com.example.consumer.controller;

import com.example.common.utils.RedisUtils;
import com.example.consumer.feign.ProductsFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;


@Slf4j
@Api(tags = "产品Controller")
@RestController
@RequestMapping(value = "/products")
public class ProductsController {

    @Resource
    private ProductsFeign productsFeign;
    @Resource
    private RedisUtils redisUtils;
    @Resource
    private KafkaTemplate kafkaTemplate;
/*    @Resource
    private RabbitTemplate rabbitTemplate;*/

    @ApiOperation("kafkaDemo")
    @GetMapping("/kafkaDemo")
    public void kafkaDemo() throws ExecutionException, InterruptedException {
        ListenableFuture<SendResult> f1 = kafkaTemplate.send("tp1", "key11","t1111");
        while (!f1.isDone()) ;
        //do...
    }

    @KafkaListener(topics = {"tp1"})
    public void kafkaListener(ConsumerRecord<String, Object> record) {
        Object obj = record.value();
        System.out.println(obj);
        //do...
    }


}
