# Take Home Assignment

### Tech Stack

* [Spring](https://spring.io/) - an application framework and inversion of control container for the Java platform
* [H2](https://www.h2database.com/html/main.html) - a relational database management system written in Java

### Assignment Requirements
- [x] **GET /feature?email=XXX&featureName=XXX** - This endpoint receives email (user’s email) and featureName as request parameters and returns the following response in JSON format.
- [x] **POST /feature** - This endpoint receives the following request in JSON format and returns an empty response with HTTP Status OK (200) when the database is updated successfully, otherwise returns Http Status Not Modified (304).

### API List
Basic 
* **GET /feature?email=XXX&featureName=XXX**
* **POST /feature**
* **GET /feature/all**
* **GET /user/all**

### Configuration
```sh
Domain: localhost:8080

H2 Credential
Username: root
Password: 1234
```

### Test with Postman
Import the collection [here](https://github.com/jayfrey/moneylion-test/blob/dev/Take-Home-Test.postman_collection.json)
