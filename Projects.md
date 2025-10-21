# Advanced Java Projects

This document highlights two Java-based web applications built using Servlets, JSP, JDBC, Hibernate, and MySQL. Each project demonstrates key concepts of full-stack Java development, including authentication, CRUD operations, and database integration.

---

## 🔐 Project 1: UserAuthPortal

**GitHub Repo**: [UserAuthPortal](https://github.com/solocoder9/UserAuthPortal)

**Summary**:  
UserAuthPortal is a Java web application that allows users to register and log in using their email ID and password. The system ensures both client-side and server-side validation of user credentials. It leverages JSP, Servlets, JDBC, and MySQL for a robust authentication mechanism.

### ✅ Key Features
- User registration and login
- Client-side and server-side form validation
- JDBC-based database interaction

### 🛠️ Tech Stack
Java, JSP, Servlets, JDBC, MySQL, Apache Tomcat

### ⚙️ Setup
1. Clone the repo and import into Eclipse  
2. Create database: `CREATE DATABASE user_auth_db;`  
3. Update DB config (URL, username, password)  
4. Deploy on Tomcat at `http://localhost:8080/UserAuthPortal`

---

## 📝 Project 2: NoteTaker

**GitHub Repo**: [NoteTaker](https://github.com/solocoder9/NoteTaker)

**Summary**:  
NoteTaker is a Java-based web application that allows users to create, edit, view, and delete notes. It utilizes JSP, Servlets, Hibernate, MySQL, and Bootstrap for an intuitive and efficient note management system.

### ✅ Key Features
- Create, view, edit, and delete notes
- Hibernate ORM for database operations
- Responsive user interface with Bootstrap

### 🛠️ Tech Stack
Java, JSP, Servlets, Hibernate, MySQL, Maven, Bootstrap, Apache Tomcat

### ⚙️ Setup
1. Clone the repo and import as a Maven project in Eclipse  
2. Create database: `CREATE DATABASE notetaker_db;`  
3. Configure `hibernate.cfg.xml` with your DB credentials  
4. Deploy on Tomcat at `http://localhost:8080/NoteTaker`

---

## 📄 License
Both projects are licensed under the MIT License. See individual repositories for more details.
