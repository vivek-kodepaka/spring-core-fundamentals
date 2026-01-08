## This module demonstrates a plain Spring application using
## IOC, DI, component scanning, and Java-based configuration.

-create plain maven project
-add spring-context (need for IOC and DI)
- added Engine interface and PetrolEngine class
- add Car class
- ![img.png](images/img.png)
- @Component:
     - Spring creates beans only for annotated classes
     - Spring will register this class as a bean in the IOC container”
- AppConfig -> acts as spring configuration 
      - @Configuration -> Without @ComponentScan, Spring container starts but finds zero beans
      - @ComponentScan("com.example.core") -> tell spring to check below modules to check for components
- App.java -> main file
  - ![img_1.png](images/img_1.png)
  -  // 1️⃣ Start Spring IOC Container
     var context =
     new AnnotationConfigApplicationContext(AppConfig.class);
     // 2️⃣ Ask Spring for a bean
     Car car = context.getBean(Car.class);
     // 3️⃣ Use it
     car.drive();
- new AnnotationConfigApplicationContext(AppConfig.class);
  - Spring:
     - Creates ApplicationContext
     - Scans package
     - Creates beans
     - Resolves dependencies
     - Manages lifecycle
     - This is IOC in action.
![img_2.png](images/img_2.png)







  

