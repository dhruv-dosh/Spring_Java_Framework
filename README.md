# 🎓Spring Framework & Spring Boot Core Concepts: A Developer's Guide

This document serves as a condensed reference for key concepts across Spring Core, Spring Boot, Data Persistence, Web Development, Security, and essential build tools.

## Content Box

1.  [Spring Core: IoC and Dependency Injection (DI)](https://www.google.com/search?q=%23spring-core-ioc-and-dependency-injection-di)
      * [DI Advantages](https://www.google.com/search?q=%23di-advantages)
      * [IoC (Inversion of Control) - The Principle](https://www.google.com/search?q=%23ioc-inversion-of-control---the-principle)
      * [Dependency Injection Techniques (DI)](https://www.google.com/search?q=%23dependency-injection-techniques-di)
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
      * [Maven Lifecycle](https://www.google.com/search?q=%23maven-lifecycle)

## 1. Spring Core: IoC and Dependency Injection (DI)

### 1.1. IoC (Inversion of Control) - The Principle
* **Definition:** A design principle where the flow of control is inverted. Instead of your code calling a library, the framework calls your code (the "Hollywood Principle": "Don't call us, we'll call you").
* **In Spring:** The Spring **IoC Container** (e.g., `ApplicationContext`) is responsible for instantiating, configuring, and assembling your application's components (beans). This manages the lifecycle of objects, taking control away from the developer's explicit instantiation (`new`).

### 1.2. DI Definition and Advantages
* **Definition (Dependency Injection):** A pattern used to implement IoC. It's the process of supplying an external dependency (an object) to a software component. The container "injects" the dependencies into an object at runtime rather than the object creating or looking up its dependencies.
* **Advantages:**
    * **Loose Coupling:** Components are less dependent on each other's implementation details.
    * **Testability:** Easier to swap out real dependencies with mock/stub objects for unit testing.
    * **Maintainability/Reusability:** Independent components are easier to maintain and reuse in different contexts.

### 1.3. Dependency Injection Techniques (DI)
1.  **Constructor Injection (Preferred):** Dependencies are provided through the class constructor.
    * **Advantage:** Ensures that the object is created with all its necessary dependencies (immutable objects possible).
2.  **Setter Injection:** Dependencies are provided via public setter methods.
    * **Advantage:** Allows for optional dependencies and easy re-configuration.
3.  **Field Injection (Least Preferred):** Dependencies are injected directly into a class field (often using `@Autowired`).
    * **Disadvantage:** Makes the class hard to test without the Spring container.

### 1.4. Bean Definition
* **Bean:** An object that is instantiated, assembled, and managed by the Spring IoC container. They are the backbone of a Spring application.
* **Metadata:** Beans are defined using configuration metadata, which can be:
    * **XML-based** (Legacy)
    * **Annotation-based** (Modern standard)
    * **Java-based** (using `@Configuration` and `@Bean`)

### 1.5. Core Component/DI Annotations
| Annotation | Purpose | Scope |
| :--- | :--- | :--- |
| `@Component` | Generic stereotype for any Spring-managed component. | Class |
| `@Service` | Marks a class as a Service layer component (business logic). | Class |
| `@Repository` | Marks a class as a Data Access Object (DAO) for persistence logic. | Class |
| `@Controller` | Marks a class as a web controller (used with Spring MVC for traditional views). | Class |
| `@RestController` | Combines `@Controller` and `@ResponseBody` (for REST APIs, returns data directly). | Class |
| `@Configuration` | Marks a class that declares one or more `@Bean` methods. | Class |
| `@Bean` | Marks a method that produces a bean to be managed by the IoC container. | Method |
| `@Autowired` | Injects a dependency into a field, constructor, or setter method. | Field/Constructor/Method |
| `@Qualifier("name")` | Used with `@Autowired` to specify which bean to inject when multiple types exist. | Field/Parameter |
| `@Primary` | Designates a bean as the preferred choice for injection when multiple candidates exist. | Class/Method |

---

## 2. Spring Boot: Convention and Setup

### 2.1. Spring Boot Overview
* **Goal:** Simplifies the setup and development of new Spring applications.
* **Key Features:**
    * **Auto-Configuration:** Automatically configures your Spring application based on the JARs on your classpath.
    * **"Opinionated" Starters:** Provides sets of pre-configured dependencies (e.g., `spring-boot-starter-web`) to quickly get started.
    * **Embedded Server:** Embeds web servers like Tomcat or Jetty, allowing you to run the application as a standalone JAR.
    * **Production-Ready Features:** Provides features like health checks and metrics via Spring Boot Actuator.
* **Principle:** **Convention over Configuration**.

### 2.2. Spring Boot Annotations
| Annotation | Purpose |
| :--- | :--- |
| `@SpringBootApplication` | **Primary annotation for a Spring Boot application.** It combines: `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`. |
| `@EnableAutoConfiguration`| Tells Spring Boot to guess and configure beans based on the classpath settings. |
| `@ComponentScan` | Tells Spring to search for components, configurations, and services in the specified package (and sub-packages). |

---

## 3. Data Persistence: ORM, JPA, and Repositories

### 3.1. ORM and JPA
* **ORM (Object-Relational Mapping):** A technique that converts data between incompatible type systems using object-oriented programming languages. In Java, this maps Java objects to relational database tables. (e.g., Hibernate is a popular ORM framework).
* **JPA (Java Persistence API):** A **specification** for persisting Java objects to a relational database. It defines the standard for ORM in Java (Hibernate is a common implementation of the JPA specification).
* **Spring Data JPA:** A Spring project that significantly simplifies data access by providing a higher-level abstraction on top of JPA/ORM.

### 3.2. Entity and Repository
* **Entity:** A simple Java class that represents a table in the database.
    * **Key Annotations:**
        * `@Entity`: Marks the class as a JPA entity.
        * `@Table(name="...")`: Specifies the table name (optional).
        * `@Id`: Designates the primary key field.
        * `@GeneratedValue(strategy=...)`: Specifies how the primary key is generated (e.g., `IDENTITY`).
        * `@Column(name="...")`: Specifies the column name (optional).
* **Repository:** An interface that defines data access methods for an Entity. Spring Data JPA automatically provides a concrete implementation at runtime.
    * **Key Interfaces:**
        * `CrudRepository<Entity, IdType>`: Provides basic CRUD operations (`save`, `findById`, `findAll`, `delete`).
        * `JpaRepository<Entity, IdType>`: Extends `PagingAndSortingRepository` and `CrudRepository`, adding JPA-specific features like flushing and batch deletion.
    * **Annotation:**
        * `@Repository`: Optional on the interface, as Spring Data JPA components are automatically detected.

### 3.3. Querying
Spring Data JPA supports multiple ways to define queries in the Repository interface:
1.  **Query Methods (Derived Queries):** Spring generates the query based on the method name.
    * *Example:* `findByLastName(String lastName)`, `findDistinctByAgeLessThan(int age)`.
2.  **`@Query` Annotation:** Allows defining custom queries using:
    * **JPQL (Java Persistence Query Language):** Query against entities and their fields (e.g., `@Query("SELECT u FROM User u WHERE u.email = ?1")`).
    * **Native SQL:** Raw SQL query by setting `nativeQuery=true` (e.g., `@Query(value="SELECT * FROM users WHERE email = ?1", nativeQuery=true)`).

---

## 4. Web Development and REST APIs

### 4.1. MVC Structure (in the context of REST)
* **Model:** The data and business logic of the application. (In Spring, this is often the Service/Repository layer and the DTO/Entity objects).
* **View:** The presentation layer (not typically used in REST APIs, as the output is raw data like JSON/XML).
* **Controller:** Handles incoming HTTP requests, calls the service layer for business logic, and prepares the response. (In Spring, this is the class annotated with `@RestController`).

### 4.2. REST Annotations
| Annotation | Purpose |
| :--- | :--- |
| `@RestController` | Class-level annotation that marks a class as a REST Controller. |
| `@RequestMapping("/path")` | Class or Method-level: Maps HTTP requests to handler methods. |
| `@GetMapping("/path")` | Maps HTTP **GET** requests (for reading resources). |
| `@PostMapping("/path")` | Maps HTTP **POST** requests (for creating resources). |
| `@PutMapping("/path")` | Maps HTTP **PUT** requests (for replacing/updating resources). |
| `@DeleteMapping("/path")` | Maps HTTP **DELETE** requests (for deleting resources). |
| `@PathVariable` | Extracts a value from the URI path template (e.g., `/users/{id}`). |
| `@RequestParam` | Extracts a value from the request query parameters (e.g., `/users?name=John`). |
| `@RequestBody` | Maps the HTTP request body (e.g., JSON) to a Java object. |
| `@ResponseBody` | Marks a method to bind the return value to the response body (included in `@RestController`). |

### 4.3. HTTP Response and Status Codes
* The HTTP status code is crucial for communicating the outcome of an API request.
* **Key Status Codes:**
    * **200 OK:** Standard response for successful HTTP requests.
    * **201 Created:** The request has succeeded and a new resource has been created (often from a `POST` request).
    * **204 No Content:** The request succeeded, but there is no entity body to return (e.g., a successful `DELETE` request).
    * **400 Bad Request:** The server cannot process the request due to a client error (e.g., malformed syntax, invalid request body).
    * **401 Unauthorized:** Authentication is required and has failed or not been provided.
    * **403 Forbidden:** The server understood the request, but refuses to authorize it (authenticated but no permission).
    * **404 Not Found:** The requested resource could not be found.
    * **500 Internal Server Error:** A generic error message, given when an unexpected condition was encountered.

---

## 5. Spring Security

### 5.1. Security Framework
* **Purpose:** A powerful and highly customizable authentication and access-control framework for Spring applications.
* **Core Concepts:**
    * **Authentication:** The process of validating a user's identity (e.g., checking username/password).
        * **`UserDetailsService`:** Interface used to retrieve user-related data (e.g., from a database).
    * **Authorization:** The process of determining if an authenticated user has permission to access a resource or perform an action.
    * **Principals:** Represents the currently logged-in user.

### 5.2. Customization
* Spring Security uses a `FilterChain` to handle requests. Configuration is typically done via a `@Configuration` class that extends `WebSecurityConfigurerAdapter` (or uses `SecurityFilterChain` bean in Spring Boot 2.7+).
* **Common Customizations:**
    * Defining custom authentication providers (e.g., for JWT or LDAP).
    * Defining URL-based access rules (e.g., `/admin/**` requires `ROLE_ADMIN`).
    * Using method-level security annotations like `@PreAuthorize("hasRole('ADMIN')")` to control access to specific methods.

---

## 6. Utilities and Configuration

### 6.1. Lombok
* **Purpose:** A library that automatically plugs into your build process to generate boilerplate code like getters, setters, constructors, and logging methods.
* **Key Annotations (Reduces Boilerplate):**
    * `@Getter`, `@Setter`: Generates getter/setter methods for all fields.
    * `@NoArgsConstructor`, `@AllArgsConstructor`: Generates a constructor with no arguments and a constructor with all arguments, respectively.
    * `@Data`: A convenient shortcut that bundles `@ToString`, `@EqualsAndHashCode`, `@Getter`, `@Setter`, and `@RequiredArgsConstructor`.
    * `@Builder`: Generates fluent builder APIs for your classes.

### 6.2. Transactional Management
* **Transaction:** A sequence of operations performed as a single logical unit of work, adhering to **ACID** properties (Atomicity, Consistency, Isolation, Durability).
* **`@Transactional` Annotation:** Spring's core annotation for declarative transaction management.
    * **Functionality:** When placed on a class or method, Spring automatically:
        1.  Starts a database transaction before the method executes.
        2.  Commits the transaction if the method completes successfully.
        3.  Rolls back the transaction if an unchecked (runtime) exception is thrown.
    * **Usage:** Typically applied at the **Service layer** to wrap a unit of business logic that might involve multiple repository calls.

### 6.3. External Properties and Profiles
* **External Properties:** Allows configuring an application from external sources (e.g., `.properties`, `.yml` files, environment variables, command-line arguments).
    * **File:** `application.properties` (or `application.yml`) is the default location for configuration.
    * **Injection:** Properties can be injected using the `@Value("${property.name}")` annotation.
* **Profiles:** A mechanism to map different configurations to different environments (e.g., `dev`, `test`, `prod`).
    * **Configuration Files:** Use naming convention `application-{profile}.properties` (e.g., `application-dev.properties`).
    * **Activation:** Activated by setting the `spring.profiles.active` property in `application.properties`, as a command-line argument (`--spring.profiles.active=prod`), or an environment variable.
    * **Annotation:** `@Profile("dev")` can be used on classes/methods to conditionally register beans only when a specific profile is active.

---

## 7. Maven Build Tool

### 7.1. Maven Purpose
* **Definition:** A project management and comprehension tool that provides a complete build lifecycle framework.
* **Primary Goals:**
    1.  **Standardized Project Structure:** Enforces a consistent directory layout (`src/main/java`, `src/test/java`, etc.).
    2.  **Dependency Management:** Manages external libraries (dependencies) using a central repository and transitive dependency resolution.
    3.  **Standardized Build Process:** Defines a clear, ordered set of phases for building, testing, and packaging a project.

### 7.2. POM.xml
* **Definition:** **P**roject **O**bject **M**odel. The fundamental unit of work in Maven. It is an XML file that contains information about the project and configuration details used by Maven to build the project.
* **Key Sections:**
    * `<groupId>`, `<artifactId>`, `<version>`: The unique coordinates of the project artifact.
    * `<packaging>`: Defines the type of artifact (e.g., `jar`, `war`, `pom`).
    * `<dependencies>`: Lists all the external libraries required by the project.
    * `<build>`: Contains configuration for the build process, including plugins.
    * `<parent>`: Defines the parent POM (e.g., `spring-boot-starter-parent` in Spring Boot).

### 7.3. Maven Lifecycle
Maven has three built-in build lifecycles: **`clean`**, **`default` (or `build`)**, and **`site`**.

#### Default Lifecycle (Most Common Phases)
Phases are executed sequentially. Running a phase executes all phases before it.

| Phase | Description |
| :--- | :--- |
| **`validate`** | Validate the project is correct and all necessary information is available. |
| **`compile`** | Compile the source code. |
| **`test`** | Run unit tests against the compiled code. |
| **`package`** | Take the compiled code and package it (e.g., into a JAR or WAR). |
| **`integration-test`**| Process and deploy the package for integration tests. |
| **`verify`** | Run checks to ensure quality criteria are met. |
| **`install`** | Install the package into the **local** repository for use as a dependency in other local projects. |
| **`deploy`** | Copies the final package to the **remote** repository for sharing with other developers. |

#### Other Key Lifecycles
* **Clean Lifecycle:**
    * **`clean`:** Deletes the build directory (usually `target/`).
* **Common Commands:**
    * `mvn clean install`: Cleans the project, runs tests, packages the artifact, and installs it in the local Maven repository.
    * `mvn clean package`: Cleans the project, runs tests, and packages the artifact (without installing locally).
    * `mvn test`: Runs only the unit tests.
