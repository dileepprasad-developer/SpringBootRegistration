# SpringBootRegistration
My First Spring Boot Application
This Application Registers the user and keep the details in Redis cache
Redis cache will keep the data in json format



1) GET example - http://localhost:9000/registration/user/18


2) POST  example - http://localhost:9000/registration/user/and post data in below json format
{"userid":"18","username":"foo","emailid":"foo@foo.com","registrationdate":"2016-07-20 08:33:12"}


3)DELETE example = http://localhost:9000/registration/user/18
