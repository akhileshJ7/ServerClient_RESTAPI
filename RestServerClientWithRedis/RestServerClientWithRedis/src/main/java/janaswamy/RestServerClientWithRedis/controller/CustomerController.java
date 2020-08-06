package janaswamy.RestServerClientWithRedis.controller;

import org.springframework.web.bind.annotation.*;

import janaswamy.RestServerClientWithRedis.dao.CustomerRepository;
import janaswamy.RestServerClientWithRedis.model.Customer;

import java.util.Map;

/**
 * This is a controller implementation which maps to 
 * GET, DELETE, PUT and POST REST API's
 * 
 * @Author Akhilesh Janaswamy
 * @version 1.0
 * @since 2020-08-06
 */

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;	
    }

    /**
     * This method creates and stores Customer Object using GET
     * 
     * @param id, name, email, enrole Argumets from url
     * @return Customer object created to display
     */
    @GetMapping("/add/{id}/{name}/{email}/{enrole}")
    public Customer add(@PathVariable("id") final String id,
                       @PathVariable("name") final String name,
                       @PathVariable("email") final String email,
                       @PathVariable("enrole") final String enrole
                       ) {
        customerRepository.save(new Customer(id, name, email, enrole));
        return customerRepository.findById(id);
    }
    
    /**
     * This method creates and stores Customer Object using POST
     * 
     * @param Customer object from the api
     * @return Customer object created to display
     */
    @PostMapping("/add")
    public Customer add(@RequestBody Customer customer) {
		customerRepository.save(customer);
		return customer;
    }
    
    /**
     * This method updates/creates and stores Customer Object using PUT
     * 
     * @param Customer object from the api
     * @return Customer object created to display
     */
    @PutMapping("/update")
    public Customer update (@RequestBody Customer customer) {
		customerRepository.update(customer);
		return customer;
    }
    
    /**
     * This method displays all Customer Object using GET
     * 
     * @param Nothing
     * @return Collection of object on Redis
     */
    @GetMapping("/all")
    public Map<String, Customer> update(){
        return customerRepository.findAll();
    }
    
    /**
     * This method deletes Customer Object using DELETE
     * 
     * @param id of the desired object 
     * @return String to display deleted.
     */
    
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") final String id) {
    	customerRepository.delete(id);
    	return "Deleted";
    }

}
