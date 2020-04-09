**This is a simple CRUD  on dynamodb running in docker  using springboot**

 Steps to start the setup
 
 1)
    --> Start docker container of dynamodb
        
        command `docker run -p 8000:8000 amazon/dynamodb-local`        
 
    --> install dynamodb-admin
        
        command `sudo npm install -g dynamodb-admin`
        
    --> get ui console of dynamodb-admin
       
        command `dynamodb-admin`
        
        Now open browser and navigate to http://localhost:8001
        
        manually creation of table is not required
        (Create table with name `persons` and key as `email` of type `string`)
        
 2) 
    --> start the springboot application
        
        command `mvn spring-boot:run`
        
 Test the application from postman
 
 1) Add a person api(POST) --> `http://localhost:8080/api/v1/create` 


    Request Body -->
    {
    	"email":"person@gmail.com",
    	"name":"person",
    	"age":22
    }
 2) Get all persons api (GET)--> `http://localhost:8080/api/v1/getall` 

 3) Update the existing person api(PUT) --> `http://localhost:8080/api/v1/update`


    Request Body --> 
    {
        	"email":"person@gmail.com",
        	"name":"person_updated",
        	"age":22
    }

 4) Delete a person api(DELETE) --> `http://localhost:8080/api/v1/delete/"?email=person@gmail.com` 
