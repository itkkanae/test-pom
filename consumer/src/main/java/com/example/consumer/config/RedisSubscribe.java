package com.example.consumer.config;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class RedisSubscribe implements MessageListener {

    /**
     * 这里的 onMessage 方法是得到消息后的处理方法， 其中 message 参数代表 Redis 发送过来的消息，
     * pattern是渠道名称，onMessage方法里打印 了它们的内容。
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
        //消息体
        String body = new String(message.getBody());
        //渠道名称
        String topic = new String(pattern);
        System.out.println("消息体：" + body);
        System.out.println("渠道名称：" + topic);
    }

}