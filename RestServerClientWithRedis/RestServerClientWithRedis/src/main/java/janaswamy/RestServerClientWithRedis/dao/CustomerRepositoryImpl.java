package janaswamy.RestServerClientWithRedis.dao;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import janaswamy.RestServerClientWithRedis.model.Customer;

import java.util.Map;


/**
 * This class is template for customers actions. In his class 
 * RedisTemple is used to interact with Redis server, and 
 * HashOperation is used for Redis map specific operations
 * working on a hash to store the Customer Data.
 * 
 * @Author Akhilesh Janaswamy
 * @version 1.0
 * @since 2020-08-06
 */
@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private RedisTemplate<String, Customer> redisTemplate;
    

    private HashOperations hashOperations;

    public CustomerRepositoryImpl(RedisTemplate<String, Customer> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    /**
	 * This method saves Customer object to Redis
	 * @param customer object to be stored
	 */
    @Override
    public void save(Customer customer) {
        hashOperations.put("CUSTOMER", customer.getId(), customer);
    }

    /**
     * This method returns all Customer object in Redis
     * @return Collection of cutomer objects
     */
    @Override
    public Map<String, Customer> findAll() {
        return hashOperations.entries("CUSTOMER");
    }

    /**
     * This method find Customer object using id
     * @param id to find the Customer object
     * @return Customer object of the id
     */
    @Override
    public Customer findById(String id) {
        return (Customer)hashOperations.get("CUSTOMER", id);
    }
    
    /**
     * This method updates/saves the Customer object to Redis
     * 
     * @param customer object to be saved on Redis
     */
    @Override
    public void update(Customer customer) {
        save(customer);
    }

    /**
     * This method deletes the Customer from Redis
     * @param id of the customer to be deleted
     */
    @Override
    public void delete(String id) {
        hashOperations.delete("CUSTOMER", id);
    }
}
