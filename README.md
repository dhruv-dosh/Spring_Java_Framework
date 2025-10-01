# 🎓 Spring Boot Development & Architecture Handbook

## Content Box

1.  [Spring Core: IoC and Dependency Injection (DI)](https://www.google.com/search?q=%23spring-core-ioc-and-dependency-injection-di)
      * [DI Advantages](https://www.google.com/search?q=%23di-advantages)
      * [IoC (Inversion of Control) - The Principle](https://www.google.com/search?q=%23ioc-inversion-of-control---the-principle)
      * [Dependency Injection Techniques (DI)](https://www.google.com/search?q=%23dependency-injection-techniques-di)
      * [Bean Definition](https://www.google.com/search?q=%23bean-definition)
      * [Core Component/DI Annotations](https://www.google.com/search?q=%23core-componentdi-annotations)
2.  [Spring Boot: Convention and Setup](https://www.google.com/search?q=%23spring-boot-convention-and-setup)
      * [Spring Boot Overview](https://www.google.com/search?q=%23spring-boot-overview)
      * [Spring Boot Annotations](https://www.google.com/search?q=%23spring-boot-annotations)
3.  [Data Persistence: ORM, JPA, and Repositories](https://www.google.com/search?q=%23data-persistence-orm-jpa-and-repositories)
      * [ORM and JPA](https://www.google.com/search?q=%23orm-and-jpa)
      * [Entity and Repository](https://www.google.com/search?q=%23entity-and-repository)
      * [Querying](https://www.google.com/search?q=%23querying)
4.  [Web Development and REST APIs](https://www.google.com/search?q=%23web-development-and-rest-apis)
      * [MVC Structure](https://www.google.com/search?q=%23mvc-structure)
      * [REST Annotations](https://www.google.com/search?q=%23rest-annotations)
      * [HTTP Response and Status Codes](https://www.google.com/search?q=%23http-response-and-status-codes)
5.  [Spring Security](https://www.google.com/search?q=%23spring-security)
      * [Security Framework](https://www.google.com/search?q=%23security-framework)
      * [Customization](https://www.google.com/search?q=%23customization)
6.  [Utilities and Configuration](https://www.google.com/search?q=%23utilities-and-configuration)
      * [Lombok](https://www.google.com/search?q=%23lombok)
      * [Transactional Management](https://www.google.com/search?q=%23transactional-management)
      * [External Properties and Profiles](https://www.google.com/search?q=%23external-properties-and-profiles)
7.  [Maven Build Tool](https://www.google.com/search?q=%23maven-build-tool)
      * [Maven Purpose](https://www.google.com/search?q=%23maven-purpose)
      * [POM.xml](https://www.google.com/search?q=%23pomxml)
      * [Maven Lifecycle](https://www.google.com/search?q=%23maven-lifecycle)

---

## Spring Core: IoC and Dependency Injection (DI)

### DI Advantages

  * **Loose Coupling:** Dependencies are managed by the Spring container, not hardcoded, making components easier to modify and reuse.
  * **Easier Testing/Mock Objects:** Components don't create their dependencies, allowing **mock objects** to be injected easily during unit testing.

### IoC (Inversion of Control) - The Principle

  * **Definition:** A design principle where the framework (Spring) takes control of object creation, configuration, and lifecycle management, instead of the application code doing it manually.
  * **Implementation:** **Dependency Injection (DI)** is the primary pattern used by Spring to implement IoC.
  * **IoC Container:** The core Spring component responsible for creating, configuring, and managing the lifecycle of objects, known as **Beans**.

### Dependency Injection Techniques (DI)

  * **Constructor Injection:** Dependencies are supplied as **constructor arguments**. This is the **recommended method**, as it clearly identifies *required* dependencies and ensures object immutability.
  * **Setter Injection:** Dependencies are provided via public **setter methods**. Best used for *optional* dependencies.
  * **Field Injection:** Dependencies are injected directly into private fields using `@Autowired`. **Least recommended** as it makes the class difficult to instantiate outside of the container and hides its dependencies.

### Bean Definition

  * **Traditional Spring (XML):** Historically, objects (Beans) were defined for the IoC Container using XML configuration files and the `<bean>` tag.
      * Example: `ApplicationContext context = new ClassPathXmlApplicationContext("Demo.xml");`
  * **Spring Boot (Annotations):** Achieved declaratively using **Stereotype Annotations** (e.g., `@Component`, `@Service`).

### Core Component/DI Annotations

  * `@Component`: A **general-purpose stereotype** annotation that marks a class for detection by the component scanning process, registering it as a Bean in the IoC Container.
  * `@Autowired`: Instructs Spring to automatically **resolve and inject** a collaborating Bean into the current object, typically by matching its **Type**.
  * `@Primary`: Used on an implementing class to designate it as the **default choice** when multiple Beans of the same Type are available for injection.
  * `@Qualifier`: Used alongside `@Autowired` to specify the exact **Bean ID (name)** to be injected, resolving ambiguity when multiple candidate Beans exist.

---

## Spring Boot: Convention and Setup

### Spring Boot Overview

  * **Concept:** An "Opinionated Framework" that favors **Convention Over Configuration**, reducing the need for boilerplate setup code.
  * **Goal:** To get a **production-ready** Spring application up and running quickly with minimal effort, offering auto-configuration for common tasks.
  * **Running the Application:** Spring Boot creates an executable **"fat" JAR** file that **embeds a server** (like Tomcat), allowing the application to run independently using `java -jar`.

### Spring Boot Annotations

  * `@SpringBootApplication`: A convenience annotation that combines three key annotations: **`@Configuration`**, **`@EnableAutoConfiguration`**, and **`@ComponentScan`**.
  * `@Configuration`: Indicates that a class declares one or more **`@Bean` methods** and may be processed by the Spring container to generate Bean definitions.
  * `@Component`: General-purpose component. (See Core Component/DI Annotations)
  * `@Service`: A specialized `@Component` typically used to mark classes containing the **business logic/service layer**.
  * `@Repository`: A specialized `@Component` used to mark classes that deal with **Data Access (DAO layer)**, enabling persistence-related exception translation.

---

## Data Persistence: ORM, JPA, and Repositories

### ORM and JPA

  * **ORM (Object-Relational Mapping):** A programming technique that maps data between incompatible type systems (Java objects) and relational databases (tables).
  * **JPA (Java Persistence API):** A **standard Java specification** for managing relational data in applications. Hibernate is a popular **implementation** of the JPA specification.
  * **Spring Data JPA:** An abstraction layer built on top of JPA, significantly simplifying data access implementation by automatically generating repository methods.

### Entity and Repository

  * `@Entity`: Marks a POJO class to represent a **table in the database**.
  * `@Id`: Designates a field as the **primary key** for the entity.
  * `@GeneratedValue`: Specifies how the primary key value is **automatically generated**.
  * `@Data` (Lombok): A Lombok annotation that automatically generates standard methods like **Getters, Setters, `toString()`, `equals()`, and `hashCode()`** during compilation.
  * **Repository Creation:** Repositories are typically defined as an **Interface** that extends Spring Data interfaces like `JpaRepository<Entity, IdType>`.
      * `JpaRepository` provides ready-to-use methods for standard **CRUD** (Create, Read, Update, Delete) operations.
  * **NoSQL (e.g., MongoDB):** JPA is specific to relational databases. For NoSQL, Spring provides specific modules like **Spring Data MongoDB** or **Spring Data Redis**.

### Querying

  * **JPQL (JPA Query Language):** An object-oriented query language used to write queries against the entity objects, not the physical database tables.
  * **`@Query`:** Used within a Repository interface method to define custom queries using **JPQL** or **native SQL**.
  * **Query Method DSL (Domain Specific Language):** Spring Data's powerful feature where the framework automatically generates the required database query based on a specific, convention-based **method name** (e.g., `findByLastNameAndFirstName()`).

---

## Web Development and REST APIs

### MVC Structure

  * **Controller:** The **Presentation Layer**—it receives client requests, delegates business tasks to the Service layer, and formats/sends the response.
  * **Service:** The **Business Logic Layer**—it encapsulates all business rules and transaction boundaries, interacting with the Repository layer.
  * **Repository:** The **Data Access Layer**—it handles communication with the database.

### REST Annotations

  * `@RestController`: A specialized Controller that assumes all method return values should be bound directly to the **HTTP response body** (typically as JSON/XML), combining `@Controller` and `@ResponseBody`.
  * `@RequestMapping("/...")`: Used to map a web request to a specific class or method handler.
  * `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`: Specialized request mapping annotations that map directly to the corresponding **HTTP verbs** for standard CRUD operations.
  * `@RequestBody`: Maps the content of the incoming HTTP request **body** (e.g., JSON data) to a Java object parameter in a handler method.
  * `@PathVariable`: Used to extract and bind variable values from the **URL path** template (e.g., `/products/{id}`).
  * `@RequestParam`: Used to extract and bind **query parameters** from the URL (e.g., `?sort=name&page=1`).
  * **Jackson Library:** The default library used by Spring Boot to automatically handle the conversion (marshalling/unmarshalling) between Java **objects** $\leftrightarrow$ **JSON** data.

### HTTP Response and Status Codes

  * **`ResponseEntity`:** An object used to represent the entire HTTP response, allowing developers to explicitly set the **HTTP Status code**, headers, and body.
  * **2xx (Successful):** Indicates that the client's request was successfully received, understood, and accepted. (e.g., `200 OK`, `201 Created`).
  * **4xx (Client Error):** Indicates that the request contains bad syntax or cannot be fulfilled due to a client-side issue. (e.g., `400 Bad Request`, `404 Not Found`).
  * **5xx (Server Error):** Indicates that the server failed to fulfill an otherwise valid request. (e.g., `500 Internal Server Error`).

---

## Spring Security

### Security Framework

  * **Purpose:** A powerful, highly customizable authentication and access-control framework primarily used to secure Spring applications.
  * **Authentication:** The process of **verifying a user's identity** (i.e., proving who you are).
  * **Authorization:** The process of **determining what an authenticated user is allowed to do** (access control based on roles/permissions).
  * **Default Behavior:** Adding the `spring-boot-starter-security` dependency automatically secures all application endpoints with basic form login using an auto-generated temporary password.

### Customization

  * **Configuration:** Security rules are customized by creating a class annotated with **`@Configuration`** and **`@EnableWebSecurity`**, extending from `WebSecurityConfigurerAdapter` (or its modern equivalent).
  * **Configuration Logic:** Security rules are defined within the `configure(HttpSecurity http)` method:
      * `.authorizeRequests()`: Begins defining access-control rules for HTTP requests.
      * `.antMatchers("/**").permitAll()`: Allows public access to specified paths.
      * `.anyRequest().authenticated()`: Requires all other requests to be authenticated.
      * `.formLogin()`/`.httpBasic()`: Configures the method of authentication.
  * **Session Management:** Spring Security often uses a **HTTP Session** (identified by a `JSESSIONID` cookie) to store the authentication details after a successful login, making the application stateful.
  * **`SecurityContextHolder`:** A central storage location that holds the details of the currently authenticated user (the `SecurityContext`).

---

## Utilities and Configuration

### Lombok

  * **Purpose:** A popular **code generation utility** that reduces Java boilerplate code by automatically generating methods like constructors, getters, and setters during the **compilation phase** based on simple annotations (e.g., `@Data`).

### Transactional Management

  * **`@Transactional`:** An annotation that causes a method to be executed within a **transactional context**.
  * **Behavior:** Guarantees **Atomicity**—if a method fails (throws an exception), all database operations within that method will be **rolled back**; if it succeeds, all changes are **committed**.
  * **Backend:** Managed by the **`PlatformTransactionManager`** interface implementation (e.g., Hibernate's transaction manager).

### External Properties and Profiles

  * **`@Value`:** Used to inject a single configuration value (e.g., a port number or a string) directly from a property source (like `application.properties` or `application.yml`) into a field.
  * **`@ConfigurationProperties`:** Used to map **groups** of related external properties (with a common prefix) directly into a configuration POJO class.
  * **`@Profile`:** Used to mark a component or configuration as being valid only when a specific **environment** (e.g., `dev`, `test`, `prod`) is active.
      * Profile is activated by setting the property `spring.profiles.active`.

---

## Maven Build Tool

### Maven Purpose

  * **Build Automation Tool:** A comprehensive tool that standardizes and automates the entire software build lifecycle, from cleaning and compiling to testing and packaging.
  * **Dependency Management:** Automatically downloads, configures, and manages all required external libraries (**dependencies**), including their transitive dependencies.

### POM.xml

  * **`pom.xml` (Project Object Model):** The **fundamental configuration file** for Maven. It describes the project, its dependencies, the build sequence, and the goals to be achieved.
      * `<dependencies>`: Lists all external **libraries** required for the project.
      * `<parent>`: Defines a **parent POM** (like the Spring Boot parent) from which configuration and dependency versions are inherited.

### Maven Lifecycle

| Phase | Action | Purpose |
| :--- | :--- | :--- |
| **`mvn clean`** | Clear the `target` folder. | Deletes all files generated by the previous build. |
| **`mvn compile`** | Compile the code. | Compiles the source code into bytecode (`.class` files). |
| **`mvn test`** | Run tests. | Executes unit tests using a testing framework. |
| **`mvn package`** | Create the final JAR or WAR file. | Compiles and packages the code into a distributable archive (e.g., JAR/WAR). |
| **`mvn install`** | Place the JAR/WAR file into the local repository. | Installs the packaged artifact into the local Maven repository for use by other local projects. |
| **`mvn deploy`** | Deploy the artifact to a remote repository. | Copies the final artifact to a shared remote repository (e.g., Nexus or Artifactory). |

***

Let me know if you'd like to dive deeper into any of these concepts!
