package janaswamy.RestServerClientWithRedis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import janaswamy.RestServerClientWithRedis.model.Customer;


/**
 * Rest Server Client using Redis Server
 * The program adds customer details using REST API's
 * and stores them using Redis server.
 * 
 * The following spring boot project is a service side
 * program using Spring Web and Spring Redis dependencies
 * 
 * 
 * @Author Akhilesh Janaswamy
 * @version 1.0
 * @since 2020-08-06
 */
@SpringBootApplication
public class RestServerClientWithRedisApplication {

	@Bean
	JedisConnectionFactory jedisConnectionFactory(){
		return new JedisConnectionFactory();
	}



	@Bean
	RedisTemplate<String, Customer> redisTemplate (){
		RedisTemplate<String, Customer> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}

	
	/**
	   * This is the main method which starts the application.
	   * @param args Unused.
	   * @return Nothing.
	   */
	public static void main(String[] args) {
		SpringApplication.run(RestServerClientWithRedisApplication.class, args);
	}

}
