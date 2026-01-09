## This module demonstrates a plain Spring application using
## IOC, DI, component scanning, and Java-based configuration.

-create plain maven project
-add spring-context (need for IOC and DI)
- added Engine interface and PetrolEngine class
- add Car class
- <img src="images/img.png" width="500" />
- @Component:
     - Spring creates beans only for annotated classes
     - Spring will register this class as a bean in the IOC container”
- AppConfig -> acts as spring configuration 
      - @Configuration -> Without @ComponentScan, Spring container starts but finds zero beans
      - @ComponentScan("com.example.core") -> tell spring to check below modules to check for components
- App.java -> main file
   <img src="images/img_1.png" width="500" />
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
<img src="images/img_2.png" width="500" />


## -BeanFactory vs applicationContext

BeanFactory: BeanFactory is a basic container mainly used to demonstrate lazy loading.
<img src="images/img_6.png" width="500" />
<img src="images/img_7.png" width="500" />

      * XmlBeanFactory loads beans.xml
      * Bean is NOT created immediately
      * Bean is created only when getBean() is called
      * This is lazy initialization

**Important Interview Notes**

* XmlBeanFactory is deprecated (Spring 3.1+)*
* Still asked for conceptual understanding 
* Replaced by ApplicationContext

### ApplicationContext:
- ApplicationContext is an advanced Spring container built on top of BeanFactory.
Key Characteristics

  * Uses eager initialization (creates beans at startup)
  * Supports enterprise features
  * Most commonly used container
  * Used by Spring Boot internally

ApplicationContext = eager initialization by default
It does not matter whether beans are defined via:
     * @Component
      * @Bean in @Configuration
      * XML

## **Can we have Lazy Initialization in ApplicationContext?**

<img src="images/img_8.png" width="500" />
What happens?
* Spring context starts
* engine bean is NOT created
* Bean is created only when first requested

<img src="images/img_9.png" width="500" />
<img src="images/img_10.png" width="500" />
Meaning
* Car is created at startup
* Engine is created only when first used
* 📌 This uses a proxy internally.

<img src="images/img_11.png" width="500" />


## Spring Bean Lifecycle:
1. Instantiation
2. Dependency Injection
3. Initialization (@PostConstruct)
4. Ready for use
5. Destruction (@PreDestroy)

@PostConstruct runs after dependencies are injected.
@PreDestroy runs before bean destruction.
Prototype beans are not fully managed during destruction.

### Step 1: Bean Instantiation
- Spring creates the object

Uses:
- Constructor
- Factory method
- Reflection

📌 At this point:
- Object exists
- Dependencies NOT injected yet


### Step 2: Dependency Injection

- Spring injects dependencies
- Constructor / Setter / Field

📌 After this:
* Bean is in a valid state
* Dependencies are available


### Step 3: Initialization (IMPORTANT)
- This is where custom initialization logic runs.

There are 3 ways:
option 1: use this approach
    `@Component
    public class Engine {
    
        @PostConstruct
        public void init() {
            System.out.println("Engine initialized");
        }
    }`

#### Key points:
* Runs after dependency injection
* Runs once per bean
* Preferred over XML methods
* @PostConstruct runs after dependencies are injected.

#### option 2:

    `@Component
    public class Engine implements InitializingBean {
    
        @Override
        public void afterPropertiesSet() {
            System.out.println("Engine initialized");
        }
    }`

❌ Tightly couples code to Spring
⚠️ Avoid in business logic

#### option 3:
@Bean(initMethod=...) (CONFIG LEVEL)

    `@Bean(initMethod = "init")
    public Engine engine() {
    return new Engine();
    }`

- Useful for third-party classes

Bean Is Ready for Use ✅
At this stage:
* Bean is fully initialized
* Available via getBean()
* Used by application


## Bean Destruction Phase (VERY IMPORTANT)

Occurs when:
* Application shuts down
* Context is closed

#### @PreDestroy (MOST USED)

        `@Component
        public class Engine {
        
            @PreDestroy
            public void cleanup() {
                System.out.println("Engine destroyed");
            }
        }`

#### Used for:
* Closing DB connections
* Releasing resources
* Flushing buffers

📌 Interview line:
“@PreDestroy is used for cleanup before bean removal.”



DisposableBean Interface (LESS USED)
`@Component
public class Engine implements DisposableBean {

    @Override
    public void destroy() {
        System.out.println("Cleanup");
    }
}`


❌ Spring-coupled
⚠️ Avoid when possible
  

