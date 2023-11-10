package com.altin.tripmanagementservice.services;

import com.altin.tripmanagementservice.models.Passenger;
import com.altin.tripmanagementservice.models.Trip;
import com.altin.tripmanagementservice.repositories.TripRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TripServiceImpl implements TripService{
    private final TripRepository tripRepository;
    private final String passengerServiceUrl = "http://passenger-management-service/passengers";
    private final RestTemplate restTemplate;
    private final KafkaTemplate kafkaTemplate;

    public TripServiceImpl(TripRepository tripRepository, RestTemplate restTemplate, KafkaTemplate kafkaTemplate) {
        this.tripRepository = tripRepository;
        this.restTemplate = restTemplate;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public Trip create(Trip trip) {
        Passenger passenger = restTemplate.getForObject((passengerServiceUrl + "/" + trip.getPassengerId()).trim(), Passenger.class);

        if (passenger == null) throw new RuntimeException("Passenger does not exist");

        Trip newTrip = new Trip();
        newTrip.setPassengerId(trip.getPassengerId());
        newTrip.setOrigin(trip.getOrigin());
        newTrip.setDestination(trip.getDestination());
        String message = String.format("Passenger: %s requested a trip to: %s%n Phone number: %s%n Location: %s",passenger.getName(),newTrip.getDestination(),passenger.getTelephone(),newTrip.getOrigin());
        kafkaTemplate.send("message-topic",message);
        return tripRepository.save(trip);
    }

    @Override
    public Trip getById(String id) throws Exception {
        return tripRepository.findById(id).orElseThrow(Exception::new);
    }

    @Override
    public List<Trip> getAll() {
        return tripRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        tripRepository.deleteById(id);
    }
}
