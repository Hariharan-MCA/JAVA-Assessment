# Restful-API

# JAVA Assessment Test

* Java Version 11
* Database : MySQL
* [Postman Collection via JSON Link](https://www.getpostman.com/collections/817b1a73c9fbbc9b31e2)

# Requirement - Creating REST API's
Person Attributes

|Name       | Type                 |Mandatory Constraints          |
|-----------|----------------------| :---------------:            |
|Id         | Long                 |Primary key, auto increasement|
|Email      | Varchar (50)         | Yes Unique                   |
|First Name | Varchar (20)         | Yes                          |
|Last Name  | Varchar (50)         | No                           |
|Age        | Integer              | Yes 18 <= age < 50           |

- Create an API to create person including data validation (Email, First Name, Last Name, Age).
- Create an API to get person by Id. Please use the @PathVariable annotation.
- Create an API to get all person. Then, please use lambda expression to filter person whose age is over
