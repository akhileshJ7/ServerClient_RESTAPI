package janaswamy.RestServerClientWithRedis.model;

import java.io.Serializable;

/**
 * This is an entity Customer with attributes
 * 
 * @Author Akhilesh Janaswamy
 * @version 1.0
 * @since 2020-08-06
 */
public class Customer implements Serializable {

    private String id;
    private String name;
    private String email;
    private String enrole;

    public Customer(String id, String name, String email, String enrole) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.enrole = enrole;
    }
    
    //Setter for each attributes
    public void setId(String id) {
        this.id = id;
    }
    //Setter for each attributes
    public void setName(String name) {
        this.name = name;
    }
    //Setter for each attributes
    public void setEmail(String email) {
        this.email = email;
    }
    //Setter for each attributes
	public void setEnrole(String enrole) {
		this.enrole = enrole;
	}
    //Getters for each attributes
    public String getId() {
        return id;
    }
    //Getters for each attributes
    public String getName() {
        return name;
    }
    //Getters for each attributes
    public String getEmail() {
        return email;
    }
    //Getters for each attributes
    public String getEnrole() {
		return enrole;
	}


}
