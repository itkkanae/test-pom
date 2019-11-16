package com.example.consumer.config;

import com.example.common.utils.RedisUtils;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import javax.annotation.Resource;

@Configuration
@ComponentScan({"com.example.common"})
public class RedisConfiguration {


    /**
     * redis 连接工厂
     */
    @Resource
    private RedisConnectionFactory redisConnectionFactory;

    /**
     * Redis消息监听器
     */
    @Resource
    private MessageListener redisMsgListener;

    //任务池
    private ThreadPoolTaskScheduler taskScheduler;

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {

        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer =
                new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

        redisTemplate.setConnectionFactory(factory);
        // key采用String序列化方式
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        // value采用jackson序列化方式
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }

    /**
     * 创建任务池，运行线程等待处理redis的消息
     */
    @Bean
    public ThreadPoolTaskScheduler initTaskScheduler() {
        if (null != taskScheduler) {
            return taskScheduler;
        }
        taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(20);
        return taskScheduler;
    }

    /**
     * 定义redis的监听器
     *
     * @return 监听容器
     */
    @Bean
    public RedisMessageListenerContainer initRedisContainer() {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        //Redis连接工厂
        container.setConnectionFactory(redisConnectionFactory);
        //设置运行任务的线程池
        container.setTaskExecutor(initTaskScheduler());
        //定义监听渠道
        Topic topic = new ChannelTopic("__keyevent@0__:expired");
        //使用监听器监听Redis的消息
        container.addMessageListener(redisMsgListener, topic);
        return container;
    }

}
