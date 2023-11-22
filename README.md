# Taxi_Microservices

![Microservices diagram](https://i.imgur.com/94kdIH2.png)

This project is a microservice-based application that manages passengers and their trips. It consists of the following microservices:

* **Passenger Management Service:** Manages passengers and their information.
* **Trip Management Service:** Manages trips and their information.
* **Email Service:** Sends emails to the base of taxi management when a passenger requests for a trip.

## Prerequisites

* Docker
* [Configure Gmail](https://support.google.com/mail/answer/7104828?hl=en&rd=3&visit_id=638362489323657143-4285782795)
* [Create an app password from gmail](https://support.google.com/mail/answer/185833?hl=en-GB&sjid=2256980531190613766-EU)

## Installation

1. Clone the repository:

```bash
git clone https://github.com/altinhysa/taxi_microservices/edit/main/README.md
```

2. Configure Email Service
In [Email Service application.properties](https://github.com/altinhysa/taxi_microservices/blob/main/email-service/src/main/resources/application.properties) change the username to your email address and password to your gmail app password


3. Build and start the services:
```bash
docker-compose up -d
```

## Usage

### Passenger Management Service

The Passenger Management Service exposes the following endpoints:

* GET `/passengers`: Gets a list of all passengers.
* GET `/passengers/{id}`: Gets a passenger by ID.
* POST `/passengers`: Creates a new passenger.
* DELETE `/passengers/{id}`: Deletes a passenger.

### Trip Management Service

The Trip Management Service exposes the following endpoints:

* GET `/trips`: Gets a list of all trips.
* GET `/trips/{id}`: Gets a trip by ID.
* POST `/trips`: Creates a new trip and produces a message in the message topic then the email service consumes it and sends an email.
* GET `/trips/{id}`: Deletes a trip.


