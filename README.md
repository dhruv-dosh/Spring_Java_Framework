# 🎓 Spring Boot Development & Architecture Handbook

## Content Box

1.  [Spring Core: IoC and Dependency Injection (DI)](https://www.google.com/search?q=%23spring-core-ioc-and-dependency-injection-di)
      * [DI Advantages](https://www.google.com/search?q=%23di-advantages)
      * [IoC (Inversion of Control) - The Principle](https://www.google.com/search?q=%23ioc-inversion-of-control---the-principle)
      * [Dependency Injection Techniques (DI)](https://www.google.com/search?q=%23dependency-injection-techniques-di)
      * [Bean Definition](https://www.google.com/search?q=%23bean-definition)
      * [Core Component/DI Annotations](https://www.google.com/search?q=%23core-componentdi-annotations)
2.  [Spring Boot: Convention and Setup](https://www.google.com/search?q=%23spring-boot-convention-and-setup)
      * [Spring Boot Overview](https://www.google.com/search?q=%23spring-boot-overview)
      * [Spring Boot Annotations](https://www.google.com/search?q=%23spring-boot-annotations)
3.  [Data Persistence: ORM, JPA, and Repositories](https://www.google.com/search?q=%23data-persistence-orm-jpa-and-repositories)
      * [ORM and JPA](https://www.google.com/search?q=%23orm-and-jpa)
      * [Entity and Repository](https://www.google.com/search?q=%23entity-and-repository)
      * [Querying](https://www.google.com/search?q=%23querying)
4.  [Web Development and REST APIs](https://www.google.com/search?q=%23web-development-and-rest-apis)
      * [MVC Structure](https://www.google.com/search?q=%23mvc-structure)
      * [REST Annotations](https://www.google.com/search?q=%23rest-annotations)
      * [HTTP Response and Status Codes](https://www.google.com/search?q=%23http-response-and-status-codes)
5.  [Spring Security](https://www.google.com/search?q=%23spring-security)
      * [Security Framework](https://www.google.com/search?q=%23security-framework)
      * [Customization](https://www.google.com/search?q=%23customization)
6.  [Utilities and Configuration](https://www.google.com/search?q=%23utilities-and-configuration)
      * [Lombok](https://www.google.com/search?q=%23lombok)
      * [Transactional Management](https://www.google.com/search?q=%23transactional-management)
      * [External Properties and Profiles](https://www.google.com/search?q=%23external-properties-and-profiles)
7.  [Maven Build Tool](https://www.google.com/search?q=%23maven-build-tool)
      * [Maven Purpose](https://www.google.com/search?q=%23maven-purpose)
      * [POM.xml](https://www.google.com/search?q=%23pomxml)
      * [Maven Lifecycle](https://www.google.com/search?q=%23maven-lifecycle)

-----

## Spring Core: IoC and Dependency Injection (DI)

### DI Advantages

  * **Loose Coupling:** Objects depend on abstractions, and Spring injects the actual implementation.
  * **Easier Testing/Mock Objects:** Leads to cleaner code and better lifecycle management.

### IoC (Inversion of Control) - The Principle

  * **Definition:** Giving control to the framework. Spring creates and manages objects (Beans).
  * **Implementation:** **DI** is the technique used to achieve IoC.
  * **IoC Container:** The Spring container manages the lifecycle, creation, and configuration of objects (Beans) based on config files or annotations.

### Dependency Injection Techniques (DI)

  * **Constructor Injection:** Dependencies are provided via the constructor (Recommended for required dependencies).
  * **Setter Injection:** Dependencies are provided via public setter methods (Good for optional dependencies).
  * **Field Injection:** Dependencies are injected directly into the field using `@Autowired` (Least recommended).

### Bean Definition

  * **Traditional Spring (XML):** To create an object (Bean) in the IoC Container, you write a config file (XML) and use tags like `<bean id="" class="">`.
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
  * **Disadvantage:** Can include unwanted libraries due to convention over configuration.
  * **Running the Application:** Spring Boot **embeds Tomcat** or another server into the JAR file (using `java -jar`), allowing it to run independently.

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

  * `@Entity`: Annotates a class that maps to a **table in the DB**.
  * `@Id`: Declares a variable as the **primary key**.
  * `@GeneratedValue`: To auto-generate the ID.
  * `@Data` (Lombok): Generates **Getters, Setters, `toString()`,** etc., automatically during compilation.
  * `@Repository`: Annotation for the Repository Interface.
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
  * **Session Management:** Basic Auth is stateless. For persistent access, Spring uses **Session Management** (generates a **`JSESSIONID`** cookie) which holds authentication details.
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
  * **`@Profile`:** Specifies which **environment** (`dev` or `prod`) a bean/component belongs to. Used to switch between development and production configurations.
      * Switch profiles using `spring.profiles.active=dev` (e.g., in a property file or command line).

## Maven Build Tool

### Maven Purpose

  * **Build Automation Tool:** Simplifies the build process.
  * **Dependency Management:** Manages external dependencies (libraries).

### POM.xml

  * **`pom.xml` (Project Object Model):** Contains info about the project, dependencies, and build plugins.
      * `<dependencies>`: Information about required external libraries.
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
