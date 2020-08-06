# ServerClient_RESTAPI
Problem
1. Create a rest server with at least one POST, PUT, GET and DELETE API’s
2. Use Redis server to store these values
3. Write a client program to call these API’s

This Repository consists of two application: 
1st folder-Client ClientServer: Client program which uses REST API's 
    Application is a basic java program which uses Http libraries to connects 
    with the local host on port 8081
    
2nd folder-RestServerClientWithRedis: Spring Boot application which creates
    REST API using Redis server to store these data.
    
How to Run:
1. Run Redis Server on cmd prompt or using redis-server.exe
2. Eclipse IDE: 
    a.Import Maven Project 
    b.Right click project and Run as > Mavin Build ..
    c.Enter spring-boot:run on Goals field, then click applay and finally run
3. Open we browser and enter the following url 
      url: localhost:8081/customer/add
      this url display all the object currently on server
4. Run ClientServer project by running main for Demo on different console

Features:
1. ClientServer: Creates a demo by using all the REST API's creates
        Demo Steps:Step1: Customer of ID 1 was been added using GET
                   Step 2: Customer of ID 2 was been added using POST
                   Step 3: Customer of ID 2 was been updated using PUT
                   Step 4: Customer of ID 1 was been deleted using DELETE
                   Step 5: Customers in the REDIS has been display using GET
                   
2. RestServerClientWithRedis: Creates localhost on port 8081 
        to create/add/delete/update customer information. The follow are the 
        urls for each actions
        
   To Test ALL API use Advance REST Client or POSTMAN (ios)
   (I have used Advance REST Client to test my project)
   Method:
        1. GET: localhost:8081/customer/add/{id}/{name}/{email}/{enrole}
            Fields id = customer Id,
                  name= customer full name,
                  email= customer email address,
                  enrole= customer subscription 
            Eg: localhost:8081/customer/add/1/James/james@gmail.com/1-month
            Create: {
                      id : 1
                      name : James,
                      email : james@gmail.com,
                      enrole : 1-month,
                    }
                   
           GET: localhost:8081/customer/all
            Displays all the Customer JSON in Redis
            
        
        2. POST: localhost:8081/customer/add
            On Advance REST Client Set the Following 
                  Parameter>Body>Body Content> application/json
                                >Editor view> Either Raw INput or Json view
                                Raw input:  {
                                              id : 1
                                              name : James, 
                                              email : james@gmail.com,
                                              enrole : 1-month,
                                             }
                                             
        3. PUT: localhost:8081/customer/update
            On Advance REST Client Set the Following 
                  Parameter>Body>Body Content> application/json
                                >Editor view> Either Raw INput or Json view
                                Raw input:  {
                                              id : 1
                                              name : James Vital, 
                                              email : jamesss@gmail.com,
                                              enrole : 5-month,
                                             }                                     
                                             
                                             
         4. Delete: localhost:8081/customer/delete/1
            On Advance REST Client Set the Following the above
            


Tools and Technologies:
Spring boot: WEB, Redis Access Dependencies
Redis 6.0.6
Advance REST Client



References:
https://www.revisitclass.com/networking/how-to-kill-a-process-which-is-using-port-8080-in-window
https://alvinalexander.com/blog/post/java/simple-java-socket-client-class-program/?fbclid=IwAR05SZfqH8HEG_A6X2ghV2PCyPmOBv-ZzxG1StDjIyyJs7KAl5K6q-nZsVw
https://redislabs.com/blog/redis-as-a-json-store/
https://www.baeldung.com/spring-data-redis-tutorial
                  
                  
            
        
           
       
        
