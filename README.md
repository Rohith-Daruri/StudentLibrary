# StudentLibrary
This Repository has Code related to Student_Library Project build using SpringBoot Framework and Java.
In the src file there are multiple packages created:-
1)DTO:- This has the Request and Response DTO classes that are used as input parameters used to pass while calling APIs and Response DTO to provide the Output.
2)Enum:- This has few enums defined like Gender,Status that are used in different model classes.
3)Exceptions:- This package has some custom exceptions used in the code for Example:-Book Not found Exception when the book is out of stock.
4)Transformers:- This has the transformer classes to convert the Request DTO taken as input while calling API to object and object to respective Response for displaying the output.
5)Model:- This package has the classes for which the respective Relational tables are created in Database.
6)Controller/Repository/Service packages: - These Packages has the three differnt layers interconnected for differrnt purposes.
                                            a)Controller:- This has the API 's defined that are called using Postman.
                                            b)Service:- This has the logic implemeted.
                                            c)Repository:-This has the interfaces defined that extend the JPARepository.

7)Email Notifications are enabled on successfull registration of the student.
8)Swagger is implemented to document the API's.
