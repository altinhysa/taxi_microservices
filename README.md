# Taxi_Microservices

![Microservices diagram](https://i.imgur.com/94kdIH2.png)

This project is a microservice-based application that manages passengers and their trips. It consists of the following microservices:

* **Passenger Management Service:** Manages passengers and their information.
* **Trip Management Service:** Manages trips and their information.
* **Email Service:** Sends emails to the base of taxi management when a passenger requests for a trip.

## Prerequisites

* Docker

## Installation

1. Clone the repository:

```bash
git clone https://github.com/altinhysa/taxi_microservices/edit/main/README.md
```

Build and start the services:
```bash
docker-compose up -d
```

## Usage

### Passenger Management Service

The Passenger Management Service exposes the following endpoints:

* `/passengers`: Gets a list of all passengers.
* `/passengers/{id}`: Gets a passenger by ID.
* `/passengers`: Creates a new passenger.
* `/passengers/{id}`: Updates an existing passenger.
* `/passengers/{id}`: Deletes a passenger.

### Trip Management Service

The Trip Management Service exposes the following endpoints:

* `/trips`: Gets a list of all trips.
* `/trips/{id}`: Gets a trip by ID.
* `/trips`: Creates a new trip and produces a message in the message topic then the email service consumes it and sends an email.
* `/trips/{id}`: Updates an existing trip.
* `/trips/{id}`: Deletes a trip.


