# microservice-communication
Implements Microservice Communication using Spring Boot and its advanced features

MicroserviceConfigServer :
Spring Cloud Config Server for holding Microservices configuration

EurekaServerConfig :
Discovery Service implemented using Spring Cloud Netflix Eureka

EmployeeService :
Micorservice for Employee CRUD Operations

DepartmentService :
Department Microservice, which communicates with Employee Service.

OrganizationService :
Organization Microservice which communicates with Employee & Department Services. Spring Cloud Open Feign is used for the Client Communication.
