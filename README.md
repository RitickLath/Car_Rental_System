# Car Rental System

## Overview

The Car Rental System is a simple Java program that simulates a car rental service. It leverages object-oriented programming (OOP) concepts to model cars, customers, and rentals, providing a user-friendly interface for managing car rentals.

## Features

- **Car Management:** Add cars to the system with details such as ID, model, brand, base price, and availability.
  
- **Customer Management:** Add customers to the system with details such as name and ID.

- **Renting Cars:** Rent available cars to customers for a specified number of days. The system calculates the total rental price.

- **Returning Cars:** Mark rented cars as returned, updating their availability status.

- **Menu Interface:** User-friendly menu for easy interaction.

## Concepts Used

### 1. **Object-Oriented Programming (OOP)**

   The Car Rental System employs key OOP principles to model real-world entities as objects with attributes and behaviors. The main OOP concepts used include:

   - **Encapsulation:** Each class (Car, Customer, Rental, CarRentalSystem) encapsulates its data (attributes) and behavior (methods) within a single unit. Access to internal data is controlled through getters and setters.

   - **Inheritance:** The `Car`, `Customer`, and `Rental` classes exhibit a hierarchical relationship. For instance, the `Car` class could be considered a superclass with more specific car types as subclasses.

   - **Polymorphism:** The program uses polymorphism through method overriding. For example, the `priceTotal` method is overridden in the `Car` class to calculate the total rental price.

   - **Abstraction:** The classes abstract away complex details, providing a simplified interface for users to interact with the Car Rental System.

### 2. **ArrayList Usage**

   - The program uses `ArrayList` to dynamically manage lists of cars, customers, and rentals. This facilitates easy addition, removal, and iteration over elements.

## Getting Started

1. Clone the repository to your local machine:

    ```bash
    git clone https://github.com/RitickLath/Car_Rental_System
    ```

2. Open the project in your favorite Java IDE.

3. Run the `Car_Rental.java` file to start the program.

## Usage

1. Upon starting the program, you will be presented with a menu offering options to rent a car, return a car, or exit the system.

2. Choose an option by entering the corresponding number and follow the on-screen prompts.

3. For renting a car, you will be asked to enter your name, choose from available cars, and specify the rental duration.

4. For returning a car, enter the car ID you want to return.

5. Exit the program by selecting the appropriate option.

## Example

```java
public class Car_Rental {

    public static void main(String[] args) {
        // Create an instance of the CarRentalSystem
        CarRentalSystem rentalSystem = new CarRentalSystem();

        // Create some cars and add them to the system
        Car car1 = new Car("C001", "Toyota", "Camry", 60, true);
        Car car2 = new Car("C002", "Honda", "Accord", 70, true);
        Car car3 = new Car("C003", "Mahindra", "Thar", 150, true);
        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);

        // Display the main menu to interact with the system
        rentalSystem.menu();
    }
}
```

## Contributors

- [Ritick Lath](https://github.com/RitickLath/Car_Rental_System)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

---
