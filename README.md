# Java Socket Chat Application (Server–Client with Swing GUI)

This is a simple **two-person chat application** built using **Java Sockets** and **Swing GUI**.  
It demonstrates how a **Server (Person1)** and **Client (Person2)** can exchange messages in real-time.


## 🚀 Features
- Built with **Java Swing** for GUI.
- Uses **Sockets (TCP/IP)** for communication.
- Separate **Server (Person1)** and **Client (Person2)** classes.
- Messages displayed with **different colors**:
  - 🟦 Blue → Sent messages (Me)  
  - 🟪 Magenta → Received messages  
  - 🟩 Green → Connection status  
  - 🟫 Gray → Server startup logs  
- Simple and lightweight design.


## 📂 Project Structure
ChatApp/

│
├── Person1.java # Server-side code

├── Person2.java # Client-side code

└── README.md # Project documentation



## 🖥️ How to Run

### 1. Clone the Repository
git clone https://github.com/Shruthi018/ChatApp.git

cd ChatApp

### 2. Compile the Java files
javac Person1.java Person2.java

### 3. Start the Server (Person1)
java Person1

A window will open for Person1 (Server).

The server starts on port 1818.

### 4. Start the Client (Person2)
java Person2

A window will open for Person2 (Client).

It connects automatically to the server at localhost:1818.
