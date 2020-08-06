package janaswamy.RestServerClientWithRedis.dao;

import org.springframework.stereotype.Service;

import janaswamy.RestServerClientWithRedis.model.Customer;

import java.util.Map;

/**
 * This is an interface for Customer Actions
 * 
 * @Author Akhilesh Janaswamy
 * @version 1.0
 * @since 2020-08-06
 */
@Service
public interface CustomerRepository {
	/**
	 * This method saves Customer object to Redis
	 * @param customer object to be stored
	 */
    public void save (Customer customer);
    
    /**
     * This method deletes the Customer from Redis
     * @param id of the customer to be deleted
     */
    public void delete(String id);
    
    /**
     * This method returns all Customer object in Redis
     * @return Collection of cutomer objects
     */
    public Map<String, Customer> findAll();
    
    /**
     * This method find Customer object using id
     * @param id to find the Customer object
     * @return Customer object of the id
     */
    public Customer findById(String id);
    
    /**
     * This method updates/saves the Customer object to Redis
     * 
     * @param customer object to be saved on Redis
     */
    public void update(Customer customer);
    
    

}
