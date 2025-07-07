# Elevator Simulation Game

This project is a simple Java-based elevator simulation that models people entering a building and using an elevator to reach various floors. It includes core functionalities such as elevator movement, person requests, food wallet balance, and stack-based internal mechanics.

## 📁 Project Structure

- `ElevatorGame.java`  
  The main entry point. Initializes the game and handles the simulation loop.

- `Elevator.java`  
  Controls the elevator's logic: movement, direction, door operations, and floor transitions.

- `ElevatorPerson.java`  
  Represents a person inside the elevator, including destination and movement status.

- `Person.java`  
  Models a person waiting on a floor with a requested destination .

- `MyStack.java`  
  A custom stack implementation used internally in the elevator system.

- `elevatorgame.iml`  
  IntelliJ IDEA module file.

## 🎮 How It Works

1. People enter the building and request elevator rides.
2. Each person has a `FoodWallet` to simulate additional attributes (e.g., simulation extensions).
3. The elevator processes people based on their requested floors.
4. Internally, `MyStack` is used to manage elevator passengers in a stack-like manner.

## ▶️ Running the Project

To run the simulation:

1. Open the project in IntelliJ IDEA or any Java IDE.
2. Compile all `.java` files.
3. Run `ElevatorGame.java`.

You can also run it from the terminal:

```bash
javac *.java
java ElevatorGame
```

## 🔧 Requirements

- Java JDK 8 or higher
- (Optional) IntelliJ IDEA for project structure support

## 🧠 Future Improvements

- Add GUI with JavaFX or Swing.
- Enhance elevator logic (e.g., priority queues, multiple elevators).
- Include CSV or JSON import for person schedules.


