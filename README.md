# 🍕 CerTan Pizza: Design Patterns Project

A comprehensive Java console application demonstrating the implementation and integration of **7 distinct Gang of Four (GoF) Design Patterns** within a unified pizza store ecosystem.

---

## Implemented Design Patterns

### 1. <b>Facade Pattern</b>

* **Location:** `Facade.PizzaStoreFacade`
* **Purpose:** Provides a simplified interface to a complex set of subsystems including **Lighting**, **Inventory**, **Personnel**, and **Cleaning**.
* **Logic:** The client (`Main`) calls high-level methods like `openStore()` or `closeStore()`, which then orchestrate the specific timing and order of subsystem operations like turning on lights and checking staff presence.

### 2. <b>Builder Pattern</b>

* **Location:** `Builder.PizzaBuilder`, `Builder.ThinCrustPizzaBuilder`, `Builder.StuffedCrustPizzaBuilder`
* **Purpose:** Separates the construction of a complex **PizzaOrder** object from its representation.
* **Logic:** Allows the store to produce different crust varieties (**Thin** or **Stuffed**) while keeping the step-by-step construction logic (adding sauce, cheese, etc.) uniform.

### 3. <b>Memento Pattern</b>

* **Location:** `Memento.Memento`, `Memento.PizzaCaretaker`, `Builder.PizzaOrder`
* **Purpose:** Captures and restores the internal state of a **PizzaOrder** without violating encapsulation.
* **Logic:** Powering the <b>"Transparency Process,"</b> it saves snapshots of the pizza at every preparation step so the customer can "replay" the chef's work via the `showTransparencyProcess` method.

### 4. <b>Bridge Pattern</b>

* **Location:** `Bridge.DeliveryFulfillment`, `Bridge.DeliveryService`
* **Purpose:** Decouples a delivery abstraction from its implementation.
* **Logic:** Separates <b>Delivery Fulfillment</b> (Standard or Express pricing) from <b>Delivery Service</b> (Courier or Self-Service), allowing them to vary independently.

### 5. <b>Observer Pattern</b>

* **Location:** `ObserverPublisher.PromotionPublisher`, `ObserverPublisher.CustomerSubscriber`
* **Purpose:** Defines a one-to-many dependency between the store and its members.
* **Logic:** When the <b>PromotionPublisher</b> broadcasts a discount, all registered **CustomerSubscriber** objects receive the update automatically via the `upcomingMessage` method.

### 6. <b>Iterator Pattern</b>

* **Purpose:** Standardizes the traversal of different collections within the store.
* **Logic:** Allows a manager to navigate through <b>Inventory Materials</b> (stored in an ArrayList) and <b>Pending Orders</b> (stored in a HashMap) using a common interface without exposing internal data structures.

---

## Getting Started

### <b>Prerequisites</b>

* **Java SDK 8** or higher.
* **IDE**: IntelliJ IDEA, Eclipse, or any standard terminal.

### <b>Execution</b>

1. Open the project in your preferred Java environment.
2. Compile the source files within the `src/` directory.
3. Run the `Main.java` class to start the application.

---

## User Journey

1. <b>Store Initialization</b>: The Facade triggers the opening sequence for subsystems (Lights, Inventory, Personnel).
2. <b>Membership Check</b>: Enter a member ID or register to join the Observer list for promotions.
3. <b>Delivery Configuration</b>: Choose a delivery method and speed (Bridge Pattern).
4. <b>Pizza Ordering</b>: Select a pizza type and crust; the Director takes over the construction.
5. <b>Transparency Replay</b>: Watch the Memento system deconstruct the preparation process for quality verification.
6. <b>Final Receipt</b>: View the total cost, combining the Builder's pizza price and the Bridge's delivery fee.

---

## Project Structure

* <b>`Bridge/`</b>: Delivery abstraction and implementation logic.
* <b>`Builder/`</b>: Pizza construction, Product, and Director logic.
* <b>`Facade/`</b>: Store management and internal subsystem classes.
* <b>`Memento/`</b>: Snapshot storage and caretaker logic.
* <b>`ObserverPublisher/`</b>: Subscription and messaging system.
* <b>`Iterator/`</b>: Iteration package for Collections, also providing mock data to show different usages.
* <b>`Main.java`</b>: The Client class that coordinates all design patterns.
