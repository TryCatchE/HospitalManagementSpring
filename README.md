# Hospital Management System

## Overview
The Hospital Management System is a Java-based application built to manage various aspects of a hospital, including appointments, doctors, patients, and medical histories. This system provides RESTful APIs for creating, reading, updating, and deleting (CRUD) operations for different entities within the hospital.

## Features
- **Doctor Management:** Allows adding, retrieving, updating, and deleting doctor information.
- **Patient Management:** Provides functionality for managing patient details.
- **Appointment Management:** Enables scheduling, updating, and canceling appointments between doctors and patients.
- **Medical History Management:** Allows tracking and updating medical histories for patients.
- **Email Subscription:** Provides an endpoint for subscribing to the hospital's newsletter via email.

## Technologies Used
- **Spring Boot:** For building the RESTful APIs and handling HTTP requests.
- **Spring Data JPA:** For interacting with the database using Java Persistence API.
- **MySQL Database:** Used as the data store for storing hospital-related information.
- **ModelMapper:** For mapping between DTOs (Data Transfer Objects) and entity objects.
- **Java Mail API:** For sending emails to subscribers who sign up for the newsletter.

## Setup Instructions
1. **Clone the Repository:** Clone the project repository from [GitHub Repo URL].
2. **Database Configuration:** Configure the MySQL database connection settings in the `application.properties` file.
3. **Build and Run:** Use Maven or Gradle to build the project, and then run the application using Spring Boot.

## API Endpoints
### Doctors:
- `GET /api/doctors`: Retrieve all doctors.
- `GET /api/doctor/{id}`: Retrieve a specific doctor by ID.
- `POST /api/doctor`: Create a new doctor.
- `PUT /api/doctor/{id}`: Update an existing doctor.
- `DELETE /api/doctor/{id}`: Delete a doctor by ID.

### Patients:
- `GET /api/patients`: Retrieve all patients.
- `GET /api/patient/{id}`: Retrieve a specific patient by ID.
- `POST /api/patient`: Create a new patient.
- `PUT /api/patient/{id}`: Update an existing patient.
- `DELETE /api/patient/{id}`: Delete a patient by ID.

### Appointments:
- `GET /api/doc-appointments/{id}`: Retrieve all appointments for a specific doctor.
- `GET /api/patient-appointments/{id}`: Retrieve all appointments for a specific patient.
- `POST /api/appointment`: Create a new appointment.
- `PUT /api/appointment/{id}`: Update an existing appointment.
- `DELETE /api/appointment/{id}`: Cancel an appointment by ID.

### Newsletter Subscription:
- `POST /api/newsletter`: Subscribe to the hospital newsletter by providing an email address.





