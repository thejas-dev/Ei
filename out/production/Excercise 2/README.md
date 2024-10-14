# Structural Design Patterns

This folder contains implementations of various structural design patterns. Each pattern is demonstrated through a different example, showcasing its application and benefits. Below are the details for each pattern:

## 1. Adapter Pattern: Media Player

The **Adapter Pattern** allows incompatible interfaces to work together. In this example, the `VlcPlayer` class has a method incompatible with the `MediaPlayer` interface. The `VlcPlayerAdapter` adapts the `VlcPlayer` to the `MediaPlayer` interface, allowing it to be used by client code that expects a `MediaPlayer`.

- **Target Interface**: `MediaPlayer`
- **Adaptee**: `VlcPlayer`
- **Adapter**: `VlcPlayerAdapter`
- **Client Code**: `AdapterPatternDemo.java`
---
## 2. Facade Pattern: Home Theater System
The **Facade Pattern** provides a simplified interface to a complex subsystem. In this example, the HomeTheaterFacade class provides a simplified interface to control various components of a home theater system, such as a DVD player, projector, and sound system.

- **Subsystems**: `DvdPlayer, Projector, SoundSystem`
- **Facade**: `HomeTheaterFacade`
- **Client Code**: `FacadePattern.java`
---
## 3. Proxy Pattern: Bank Application
The **Proxy Pattern** provides an intermediary to control access to an object. In this example, the BankAccountProxy class controls access to a RealBankAccount, ensuring that all operations (deposits, withdrawals, and balance checks) are mediated through the proxy.

**Subject Interface**: `BankAccount`
**Real Subject**: `RealBankAccount`
**Proxy**: `BankAccountProxy`
**Client Code**: `ProxyPattern.java`

---