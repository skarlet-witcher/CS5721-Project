## bank manage
> team assignment

`for fiddler`
-DproxySet=true -DproxyHost=127.0.0.1 -DproxyPort=8888

####architecture
- unique central server
- client of self service
- client of atm
- client of staff
- client of admin

####techniques
- Maven
- MVC pattern
- gRPC incl. Protobuf & cert authentication
- MySQL + Hibernate
- JFormDesigner
- JUnit

####further
- use mapper to avoid big amounts of set get methods. like `https://github.com/BAData/protobuf-converter`
- project not finished.

####Notice
- **use local cert in local testing environment** 
- adjust every module language level
- before running the project run maven `generate sources and update folders for all projects`

####Design Pattern
- Singleton Pattern
- Factory Pattern
- Builder Pattern
- Observer Pattern
- Facade Pattern
- ...
-----------
Introduction about 23 kinds of design pattern.(Chinese website)
https://blog.csdn.net/anxpp/article/details/51224293