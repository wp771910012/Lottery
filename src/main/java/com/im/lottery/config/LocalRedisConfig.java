package com.im.lottery.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class LocalRedisConfig {
	@Value("${spring.redis.host}")
	private String hostName;
	@Value("${spring.redis.port}")
	private int port;
	@Value("${spring.redis.password}")
	private String passWord;
	@Value("${spring.redis.pool.max-idle}")
	private int maxIdl;
	@Value("${spring.redis.pool.min-idle}")
	private int minIdl;
	
//	@Value("${activity.appIds}")
//	private String appIds;
//	@Value("${activity.startTime}")
//	private String startTime;
//	@Value("${activity.during}")
//	private int during;
	
    @Bean
    public RedisConnectionFactory jedisConnectionFactory(){
        JedisPoolConfig poolConfig=new JedisPoolConfig();
        poolConfig.setMaxIdle(maxIdl);
        poolConfig.setMinIdle(minIdl);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(true);
        poolConfig.setTestWhileIdle(true);
        poolConfig.setNumTestsPerEvictionRun(10);
        poolConfig.setTimeBetweenEvictionRunsMillis(60000);

        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(poolConfig);
        jedisConnectionFactory.setHostName(hostName);  
        if(!passWord.isEmpty()){  
            jedisConnectionFactory.setPassword(passWord);  
        }  
        jedisConnectionFactory.setPort(port);  
        return jedisConnectionFactory;
    }

//    @Bean
//    public StringRedisTemplate redisTemplate() throws Exception {
//        StringRedisTemplate redisTemplate = new StringRedisTemplate(jedisConnectionFactory());
//        Date start = new SimpleDateFormat("yyyy-MM-dd").parse(startTime); 
//        Date now = new Date();
//        long duration = during*60*60*1000;
//        if(now.getTime()-start.getTime() < duration){
//        	String redisKey = "activity_key";
//        	long expire = duration+start.getTime()-now.getTime();
//        	redisTemplate.opsForValue().set(redisKey, appIds, expire, TimeUnit.MILLISECONDS);
//        }
//        return redisTemplate;
//    }
    
    @Bean
    public RedisTemplate<String, Object> redisTemplateObject() throws Exception {
    	RedisTemplate<String, Object> redisTemplateObject = new RedisTemplate<String, Object>();  
    	redisTemplateObject.setConnectionFactory(jedisConnectionFactory());
        setSerializer(redisTemplateObject); 
        redisTemplateObject.afterPropertiesSet();  
        return redisTemplateObject;
    }
    
    /** 
     * 设置序列化方法 
     */  
    private void setSerializer(RedisTemplate<String, Object> template) {  
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(  
                Object.class);  
        ObjectMapper om = new ObjectMapper();  
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);  
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);  
        jackson2JsonRedisSerializer.setObjectMapper(om);  
        template.setKeySerializer(template.getStringSerializer());  
        template.setValueSerializer(jackson2JsonRedisSerializer);
//        template.setHashKeySerializer(template.getStringSerializer());
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
    }  
}