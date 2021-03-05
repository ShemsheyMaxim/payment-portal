# Payment portal app
----
A prototype of an online payment portal with simple functional written in Java.

In this project used N-tier architecture with DB layer,
DAO layer, Service layer, Controllers layer. Project was
developed according to SOLID principles.

### Project structure

No role:
- create user
- find all bank accounts for user by user id
- create payment
- create pack payments
- find history payment by parameters

### Technologies stack:

- Java,
- Spring Boot,
- Hibernate, 
- Spring data JPA,
- Postgresql 12
- Travis
- Maven
- Postman

### Running the Project

1. Download and install the [JDK]( https://www.oracle.com/ru/java/technologies/javase-downloads.html).
3. Download and install [Postgres](https://www.postgresql.org/download/).
4. Download and install [pgAdmin 4](https://www.pgadmin.org/download/)
5. Find file _application.properties_ in resources and change the parameters to yours:
    - url: jdbc:postgresql://"host name":"port"/"name db"
    - username: "username"
    - password: "password"
6. Run the project.

__The AccountType("card/simple") is created by default__. 

If you want to add/change account type you should do the following steps:
1. open _AccountType_ class in package model
2. add new enum value
3. open class _InjectController_ class in package controller
4. find method _injectAccount()_
3. create new AccountType with new type or change parameters to yours:
    - accountType.setNameType("name");
    - accountTypeService.create("accountType");