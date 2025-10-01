# Spring and Spring Boot Comprehensive Notes

## Spring Core: IoC and Dependency Injection (DI)

### DI Advantages
* **Loose Coupling:** Objects depend on abstractions, and Spring injects the actual implementation.
* **Easier Testing/Mock Objects:** Leads to cleaner code and better lifecycle management.

### IoC (Inversion of Control) - The Principle
* **Definition:** Giving control to the framework. Spring creates and manages objects (Beans).
* **Implementation:** **DI** is the technique used to achieve IoC.
* **IoC Container:** The Spring container manages the lifecycle, creation, and configuration of objects (Beans) based on config files or annotations.

### Dependency Injection Techniques (DI)
* **Constructor Injection:** Dependencies are provided via the constructor (e.g., using `private final Service service;` and a constructor).
* **Setter Injection:** Dependencies are provided via public setter methods.
* **Field Injection:** Dependencies are injected directly into the field using `@Autowired`.

### Bean Definition
* **Traditional Spring (XML):** To create an object (Bean) in the IoC Container, you write a config file (XML) and use tags like `<bean id="" class="">` with setter or constructor arguments.
    * Example: `ApplicationContext context = new ClassPathXmlApplicationContext("Demo.xml");`
* **Spring Boot (Annotations):** Achieved using annotations.

### Core Component/DI Annotations
* `@Component`: General annotation to ask Spring to create an object (Bean) in the IoC Container.
* `@Autowired`: Performs DI. Injects Dependency by Type.
* `@Primary`: Sets the **priority** of one class implementation over others when autowiring by Type.
* `@Qualifier`: Used to specify the exact **Bean Name** to be injected when multiple implementations exist.

## Spring Boot: Convention and Setup

### Spring Boot Overview
* **Concept:** An "Opinionated Framework" that favors **Convention Over Configuration**.
* **Goal:** Simplifies creating production-ready Spring applications.
* **Disadvantage:** Can include unwanted libraries due to convention over configuration. If you need more control, use pure Spring.
* **Running the Application:** Spring Boot **embeds Tomcat** or another server (like Jetty) into the JAR file (using `java -jar`), allowing it to run independently without needing an external server.

### Spring Boot Annotations
* `@SpringBootApplication`: Combines `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan` for smooth startup.
* `@Configuration`: Defines a class that provides Java-based configuration for the application.
* `@Component`: General-purpose component.
* `@Service`: Marks a class in the **Service/Business Logic Layer**.
* `@Repository`: Marks a class in the **Data Access Layer** (DAO classes).

## Data Persistence: ORM, JPA, and Repositories

### ORM and JPA
* **ORM (Object-Relational Mapping):** Maps Java objects to database tables. Allows working with databases using object-oriented concepts.
* **JPA (Java Persistence API):** A **standard** specification (set of rules and interfaces) to achieve ORM. Hibernate is one implementation of the JPA standard.
* **Spring Data JPA:** Simplifies working with JPA. Built on top of the JPA standard (still requires an implementation like Hibernate).

### Entity and Repository
* **`@Entity`:** Annotates a class that maps to a **table in the DB**.
* **`@Id`:** Declares a variable as the **primary key**.
* **`@GeneratedValue`:** To auto-generate the ID.
* **`@Repository`:** Annotation for the Repository Interface.
* **Repository Creation:** We create a Repository as an **Interface** that extends `JpaRepository<Class, data type of Primary Key>`.
    * `JpaRepository` contains all methods for standard **CRUD** operations, so we just use them (Spring auto-creates the implementing object).
* **NoSQL (e.g., MongoDB):** JPA is **not used**. We use **Spring Data MongoDB** instead.

### Querying
* **JPQL (JPA Query Language):** Used to write custom queries against entities.
* **`@Query`:** Used in the Repository interface to define custom search functions using JPQL or native SQL.
* **Query Method DSL:** A method to interact with the database using simple method names (instead of writing explicit queries).

## Web Development and REST APIs

### MVC Structure
* **Controller:** Handles Request and Response (Presentation Layer).
* **Service:** Logic for handling the request (Business Layer).
* **Repository:** Deals with the DB (Data Access Layer).

### REST Annotations
* `@RestController`: To create a Controller Class that sends data (JSON) instead of returning a view/file.
* `@RequestMapping("/...")`: For request mapping.
* `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`: Map to HTTP verbs for CRUD operations.
* `@RequestBody`: To get the request **body** (data) from the client (e.g., JSON to Post).
* `@ResponseBody`: Tells Spring to return data directly into the HTTP response body.
* `@PathVariable`: To get variable values from the URL path (e.g., `/users/{id}`).
* `@RequestParam`: To extract query parameters from the URL.
* **Jackson Library:** Helps convert Java `object` $\leftrightarrow$ `Json` (data) for client/server communication.

### HTTP Response and Status Codes
* **`ResponseEntity`:** Used to pass the HTTP Status code explicitly with the response (e.g., `return new ResponseEntity<>(product, HttpStatus.OK);`).
* **2xx (Successful):** `200 OK`, `201 Created`, `204 No Content`.
* **4xx (Client Error):** `400 Bad Request`, `401 Unauthorized`, `403 Forbidden`.
* **5xx (Server Error):** `500 Internal Server Error`, `502 Bad Gateway`, `503 Service Unavailable`.

## Spring Security

### Security Framework
* **Purpose:** To handle **Authentication** (Who is allowed and who is not) and **Authorization** (What authenticated users are allowed to do).
* **Authentication:** Process of verifying a user's identity.
* **Authorization:** Process of granting or denying access based on authenticated user's roles and permissions.
* **Default Behavior:** Once `spring-boot-starter-security` is added, it automatically secures all endpoints. Spring auto-generates a temporary password for the default user upon first run.

### Customization
* **Configuration:** Create a class that uses `@Configuration` and **`@EnableWebSecurity`** and extends `WebSecurityConfigurerAdapter` to override configuration methods.
* **Configuration Logic:** Use methods to define security:
    * `.authorizeRequests()`: Starts authentication rules for requests.
    * `.antMatchers("/**").permitAll()`: Allows public access.
    * `.anyRequest().authenticated()`: Requires authentication for everything else.
    * `.formLogin()`: Enables form-based login (can use default or custom login page).
    * `.logout()`: Configures logout.
* **Session Management:** Basic Auth is stateless. For persistent access, Spring uses **Session Management** (generates a **`JSESSIONID`** cookie) which holds auth details for a certain amount of time.
* **`SecurityContextHolder`:** Contains all data of the user that has been authenticated.

## Utilities and Configuration

### Lombok
* **Purpose:** Dependency used to **auto-generate code** (Getters, Setters, Constructors, etc.) during compilation based on annotations (`@Data`, `@AllArgsConstructor`, `@NoArgsConstructor`).

### Transactional Management
* **`@Transactional`:** Treats a function as a **single operation** (transactional context).
* **Behavior:** If there is an error in any line, all previous operations will **Rollback**.
* **Backend:** Handled by the **`PlatformTransactionManager`** interface.

### External Properties and Profiles
* **`@Value`:** Used to inject a single value from an external property file (like `application.yml`).
* **`@ConfigurationProperties`:** Binds external properties to a POJO class (creating a configuration bean).
* **`@Profile`:** Specifies which profile (`dev` or `prod`) a bean/component belongs to. Used to switch between development and production configurations.
    * Switch profiles using `spring.profiles.active=dev` (e.g., in a property file or command line).

## Maven Build Tool

### Maven Purpose
* **Build Automation Tool:** Simplifies the build process.
* **Dependency Management:** Manages external dependencies (libraries).

### POM.xml
* **`pom.xml` (Project Object Model):** Contains info about the project, dependencies, plugins, parent version, and properties.
    * `<dependencies>`: Info about project dependencies.
    * `<plugins>`: Used for packaging, repackaging, etc.
    * `<parent>`: To inherit dependencies (e.g., Spring Boot Starters).

### Maven Lifecycle
| Phase | Action |
| :--- | :--- |
| **`mvn clean`** | Clear the `target` folder. |
| **`mvn compile`** | Compile the code. |
| **`mvn test`** | Run tests. |
| **`mvn package`** | Create the final JAR or WAR file. |
| **`mvn install`** | Place the JAR/WAR file into the local repository. |
| **`mvn deploy`** | Deploy the artifact to a remote repository. |

