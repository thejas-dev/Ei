# Creational Design Patterns

This folder contains implementations of various creational design patterns. Each pattern is demonstrated through a different example, showcasing its application and benefits. Below are the details for each pattern:

## 1. Builder Pattern: URL Builder Application

The **Builder Pattern** is used to construct complex objects step-by-step. In this example, a URL is built with various components such as protocol, domain name, top-level domain, port, and path. The pattern provides a flexible way to create URLs by allowing incremental construction and ensuring immutability of the final object.

- **Product Class**: `URL`
- **Builder Class**: `URLBuilder`
- **Client Code**: `BuilderPattern.java`

---

## 2. Factory Pattern: Vehicle Factory Application
The **Factory Pattern** provides an interface for creating objects without specifying the exact class of object that will be created. This implementation includes a factory that creates instances of different vehicle types, encapsulating the object creation logic and providing a clean interface for object creation.

- **Product Interface**: `Vehicle`
- **Concrete Products**: `Car, Bike`
- **Factory**: `VehicleFactory`
- **Client Code**: `FactoryPattern.java`
 
---
## 3. Singleton Pattern: Train Ticket Booking System
The **Singleton Pattern** ensures that a class has only one instance and provides a global point of access to that instance. This example demonstrates a train ticket booking system where the Train class is a singleton, ensuring only one instance manages ticket reservations.

- **Singleton Class**: `Train`
- **Client Code**: `SinglethonPattern.java`

---