# L'Aquila Smart Road Plateform

```
For the Project of Software Oriented at @Univaq:

It's built using Spring Boot and Angular, designed as a monitor violation detection system. Its primary goal is to monitor vehicules violations.

The backend is implemented with Spring Boot, while the frontend utilizes Angular and Bootstrap for the user interface.

Beyond standard data querying and modification, the system allows for the submission of speeding violations, resulting in an offense record. Additionally, it enables vehicle owners to view their own violations, giving them easy access to their offense history.
```

# Table of Contents
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
- [Technologies Used](#technologies-used)
- [Technical Architecture](#technical-architecture)
- [Class Diagram](#class-diagram)
- [Backend Services](#backend-services)
    - [Vehicule Service](#Vehicule-service)
    - [Monitor Service](#monitor-service)
    - [amend Service](#amend-service)
    - [Eureka Discovery Service](#eureka-discovery-service)
    - [Gateway Service](#gateway-service)
    - [Data Generator Service](#data-generator-service)
- [Frontend with Angular](#frontend-with-angular)
- [License](#license)


## Getting Started
### Prerequisites
Before running this application, you need to have the following software installed on your system :

```java
- Java Development Kit (JDK) version 11 or later
- Node.js version 14 or later
- Angular CLI version 13 or later
- Docker
```

### Installation
Follow these steps to install and run the application :

1. Clone the repository :
```
git clone https://github.com/adam-bouafia/L-Aquila-Smart-Roads.git
```
2. Navigate to the backend directory and run the following command to start the each Spring Boot project :
```
./mvnw spring-boot:run
```
3. Navigate to the frontend directory and run the following command to install the required packages :
```
npm install
```
4. After the packages are installed, run the following command to start the Angular application :
```
ng serve
```
5. Open your browser and navigate to `http://localhost:4200` to access the application.

## Technologies Used
The following technologies and frameworks are used in this application:

- Spring Boot
- Spring Cloud
- Eureka Descovery
- Angular
- Bootstrap
- MySQL
- Docker

## Functionalities

The application allows performing the following operations:
- Submit a speeding violation.
- View violations of a vehicle owner.
- Modify and view monitor data.
- Modify and view vehicle and owner data.
- Modify and view amend data.

## Technical Architecture

![Architecture](https://github.com/user-attachments/assets/f93f0b69-af53-4741-aa9a-cc6d76366021)


## Class Diagram 

![Class Diagram](https://github.com/user-attachments/assets/48e3bd84-9ae0-4ce9-9365-5a07a27f4704)


## Backend Services

The backend contains 5 services :

### Vehicule Service 

```
Registration microservice manages vehicles owned by owners. Each vehicle belongs to a single owner.
An owner is defined by their ID, name, date of birth, email.
A vehicle is defined by its ID, Vehicule number, brand, fiscal power, and model
```
- Service Structure
<pre>

├───src
│   ├───main
│   │   ├───java
│   │   │   └───univaq
│   │   │       └───disim
                └───sose
│   │   │           └───Vehiculeservice
│   │   │               │   VehiculeServiceApplication.java
│   │   │               │
│   │   │               ├───entites
│   │   │               │       Owner.java
│   │   │               │       OwnerRequest.java
│   │   │               │       Vehicle.java
│   │   │               │
│   │   │               ├───repositories
│   │   │               │       OwnerRepository.java
│   │   │               │       VehicleRepository.java
│   │   │               │
│   │   │               └───web
│   │   │                   ├───graphql
│   │   │                   │       OwnerGraphqlController.java
│   │   │                   │       VehicleGraphqlController.java
│   │   │                   │
│   │   │                   ├───grpc
│   │   │                   │   │   GrpcConfig.java
│   │   │                   │   │   OwnerGrpcService.java
│   │   │                   │   │
│   │   │                   │   └───stub
│   │   │                   │           OwnerGrpcServiceGrpc.java
│   │   │                   │           OwnerService.java
│   │   │                   │
│   │   │                   ├───rest
│   │   │                   │       OwnerRestController.java
│   │   │                   │       VehicleRestController.java
│   │   │                   │
│   │   │                   └───soap
│   │   │                           CXFSoapWebServiceConfig.java
│   │   │                           OwnerSoapController.java
│   │   │                           OwnerSoapService.java
│   │   │
│   │   └───resources
│   │       │   application.properties
│   │       │   owner-service.proto
│   │       │   xsd-schema.xsd
│   │       │
│   │       ├───graphql
│   │       │       schema.graphqls
│   │       │
│   │       ├───static
│   │       └───templates

</pre>
- Web services integration REST, GraphQL, SOAP et GRPC :

> a. REST :

Tests with `Postman`

<table>
    <tr>
        <td >
            <h5 align="center">All Vehicles</h3>
                <p align="center">
![vehicles REST](https://github.com/user-attachments/assets/f9af5e6b-50ad-4da0-8e68-14ff1ff743b5)
                </p>
        </td>
    </tr>
    <tr>
        <td >
            <h5 align="center">Find Vehicle By Id</h3>
                <p align="center">
![vehiclesFindbyID REST](https://github.com/user-attachments/assets/3ccbee78-1f24-41bc-bcd9-961544928878)
                </p>
        </td>
    </tr>
</table>

<table>
    <tr>
        <td >
            <h5 align="center">Delete Vehicle</h3>
                <p align="center">
                    ![DELETEvehiclesFindbyID REST](https://github.com/user-attachments/assets/9cd73ff9-43ce-4b37-b702-9af67171743b)
"
                </p>
        </td>
    </tr>
    <tr>
        <td >
            <h5 align="center">Update Vehicle</h3>
                <p align="center">
                    ![UpdateVehicle](https://github.com/user-attachments/assets/94685139-2406-4189-a301-f5710d5883a9)
"
                </p>
        </td>
    </tr>
</table>


> b. GraphQL :
<table>
    <tr>
        <td>
            <h5 align="center">All Vehicles with specific attributs </h3>
                <p align="center">
                  ![GraphQl](https://github.com/user-attachments/assets/ee937c48-395e-494d-b3c4-1506a6d7ffcd)
                </p>
        </td>
    </tr>
</table>

> c. SOAP :

Tests with `SoapUI`
<table>
    <tr>
        <td >
            <h5 align="center">All Owners </h3>
                <p align="center">
                    ![Soap Service test](https://github.com/user-attachments/assets/78c32391-7c10-41fa-ab5e-ac125bbd6292)
"
                </p>
        </td>
    </tr>
</table>

> d. GRPC :

Tests with `BloomRPC`
<table>
    <tr>
        <td>
            <h5 align="center">All Owners </h3>
                <p align="center">
                         ![OwnerGrpcService_listOwners](https://github.com/user-attachments/assets/becc66a1-bf21-4e93-bc7a-056e3aa0f76e)
                </p>
        </td>
    </tr>
    <tr>
        <td>
            <h5 align="center">Find Owner By Id</h3>
                <p align="center">
                         [OwnerGrpcService_getOwners](https://github.com/user-attachments/assets/12e765b9-ce32-4e8a-8dac-3bbbff860ef1)
                </p>
        </td>
    </tr>
</table>



####

### Monitor Service 

```
Monitor microservice responsible for managing monitors handles monitor entities defined
by their ID, maximum speed limit, and coordinates (longitude and latitude)
```
- Service Structure
<pre>
├───src
│   ├───main
│   │   ├───java
│   │   │   └───univaq
│   │   │       └───disim
                 └───sose
│   │   │           └───monitorservice
│   │   │               │   MonitorServiceApplication.java
│   │   │               │
│   │   │               ├───entites
│   │   │               │       Monitor.java
│   │   │               │
│   │   │               ├───feign
│   │   │               │       amendRestClient.java
│   │   │               │
│   │   │               ├───models
│   │   │               │       amend.java
│   │   │               │       NewData.java
│   │   │               │
│   │   │               ├───repositories
│   │   │               │       MonitorRepository.java
│   │   │               │
│   │   │               └───web
│   │   │                       MonitorRestController.java
│   │   │
│   │   └───resources
│   │       │   application.properties
│   │       │   monitor-service.proto
│   │       │
│   │       ├───static
│   │       └───templates
</pre>

![UI Monitors](https://github.com/user-attachments/assets/afd8a52b-70f9-4e3b-a4af-4b7b5c77355c)


![UI New Monitor](https://github.com/user-attachments/assets/c9ada194-fed3-42b8-b745-c517a846ff4c)



### Amend Service 

```
amend microservice responsible for managing violations handles each violation, which is defined
by its ID, date, the monitor number that detected the offense, the vehicle Vehicule number,
the vehicle's speed, the monitor's maximum speed limit, and the fine amount.
```
- Service Structure
<pre>
├───src
│   ├───main
│   │   ├───java
│   │   │   └───univaq
│   │   │       └───disim
                  └───sose
│   │   │           └───amendservice
│   │   │               │   amendServiceApplication.java
│   │   │               │
│   │   │               ├───entites
│   │   │               │       amend.java
│   │   │               │
│   │   │               ├───feign
│   │   │               │       MonitorRestClient.java
│   │   │               │       VehicleRestClient.java
│   │   │               │
│   │   │               ├───models
│   │   │               │       NewData.java
│   │   │               │       Owner.java
│   │   │               │       Monitor.java
│   │   │               │       Vehicle.java
│   │   │               │
│   │   │               ├───repositories
│   │   │               │       amendRepository.java
│   │   │               │
│   │   │               └───web
│   │   │                       amendRestController.java
│   │   │
│   │   └───resources
│   │       │   application.properties
│   │       │
│   │       ├───static
│   │       └───templates
</pre>

![UI Amends](https://github.com/user-attachments/assets/771ddf2c-8faf-42c5-82b3-86b762e94fd2)



### Eureka Discovery Service
```
server-side component in the Netflix OSS stack that allows services to register
and discover each other in a microservices architecture.
```
- Service Structure
<pre>
├───src
│   ├───main
│   │   ├───java
│   │   │   └───univaq
│   │   │       └───disim
                  └───sose
│   │   │           └───eurekadiscovery
│   │   │                   EurekaDiscoveryApplication.java
│   │   │
│   │   └───resources
│   │           application.properties
│   │
│   └───test
│       └───java
│           └───univaq
│               └───disim
                  └───sose
│                   └───eurekadiscovery
│                           EurekaDiscoveryApplicationTests.java
│
</pre>

![Eureka](https://github.com/user-attachments/assets/3b760cb8-ae61-4684-8d3f-8af9ec68824b)



### Gateway Service
```
Spring Cloud Gateway It provides a centralized entry point for routing and filtering requests
to microservices in a distributed system, enabling dynamic and scalable routing based on various criteria.
```
- Service Structure
<pre>
├───src
│   ├───main
│   │   ├───java
│   │   │   └───univaq
│   │   │       └───disim
                  └───sose
│   │   │           └───gateway
│   │   │                   GatewayApplication.java
│   │   │
│   │   └───resources
│   │           application.properties
│   │           application.yml
</pre>

### Data Generator Service
```
A Java application that simulates a monitor system generating random speeding violations
and sending them to the Monitor-Service.
```

- Service Structure
<pre>
├───src
│   ├───main
│   │   ├───java
│   │   │   └───univaq
│   │   │       └───disim
                  └───sose
│   │   │           └───monitorroad
│   │   │               │   MonitorDetectionService.java
│   │   │               │   MonitorRoadApplication.java
│   │   │               │
│   │   │               └───models
│   │   │                       NewData.java
│   │   │                       Monitor.java
│   │   │                       Vehicle.java
│   │   │
│   │   └───resources
│   │       │   application.properties
│   │       │
│   │       ├───static
│   │       └───templates
</pre>

* Test

<table>
    <tr>
        <td>
            <p align="center">
              roject example"
                    ![Data Generator Service Example](https://github.com/user-attachments/assets/6d757349-0f3d-4dd6-a622-665f04ef41ca)
            </p>
        </td>
    </tr>

</table>

# Frontend with Angular

## Video Demonstration




https://github.com/user-attachments/assets/9307b89d-045d-457d-b22a-9f3ff03d31f3




## Application Sceenshots

<table>
    <tr>
        <td >
            <p align="center">
                <h5 align="center">Login Page</h3>
                ![UI login](https://github.com/user-attachments/assets/d5e5b8dd-7623-4230-9cb7-7f19427ce3ef)

            </p>
        </td>
    </tr>
    <tr>
        <td >
            <p align="center">
                <h5 align="center">Welcome Page</h3>
               ![UI login](https://github.com/user-attachments/assets/87e4b21d-1836-4cac-b17c-f09e5db18f3f)
            </p>
        </td>
    </tr>

</table>

<table>
    <tr>
        <td >
            <p align="center">
                <h5 align="center">Dashboard Statistics</h3>
               ![UI Control Center](https://github.com/user-attachments/assets/6c9386fc-5a80-4605-aedd-5e07ca6ed3fa)
            </p>
        </td>
    </tr>
    <tr>
        <td >
            <p align="center">
                <h5 align="center">Monitors Page</h3>
                ![UI Monitors](https://github.com/user-attachments/assets/049581c5-476a-4026-b7b1-e7b76a7b38b5)"

            </p>
        </td>
    </tr>
</table>


<table>
    <tr>
        <td >
            <p align="center">
                <h5 align="center">Add New Monitor</h3>
                ![UI New Monitor](https://github.com/user-attachments/assets/3f308521-04b3-4230-883f-b4e47eb2f8d2)
            </p>
        </td>
    </tr>
</table>

<table>
    <tr>
        <td >
            <p align="center">
                <h5 align="center">Vehicles and their Owners Page</h3>
                ![UI Vehicles](https://github.com/user-attachments/assets/aa288d75-38da-43bd-9ece-11fcf3cdf85d)
"
            </p>
        </td>
    </tr>
    <tr>
        <td >
            <p align="center">
                <h5 align="center">amends Page</h3>
                ![UI Amends](https://github.com/user-attachments/assets/fbe75a11-b5c6-49fa-b9df-472b8335bd7c)
            </p>
        </td>
    </tr>
</table>


<table>
    <tr>
        <td >
            <p align="center">
                <h5 align="center">Show PDF</h3>
                ![amend pdf](https://github.com/user-attachments/assets/d54e2695-067e-4a13-9db1-79acaef6c6b5)
            </p>
        </td>
    </tr>
</table>

## License
This project is licensed under the GPL-3.0 license - see the LICENSE file for details.
