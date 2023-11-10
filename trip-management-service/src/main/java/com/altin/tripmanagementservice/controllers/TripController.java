package com.altin.tripmanagementservice.controllers;

import com.altin.tripmanagementservice.models.Passenger;
import com.altin.tripmanagementservice.models.Trip;
import com.altin.tripmanagementservice.services.TripService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;
@RestController
@RequestMapping("trips")
public class TripController {


    private final TripService tripService;

    public TripController(TripService tripService) {

        this.tripService = tripService;
    }


    @PostMapping
    public ResponseEntity<Trip> createTrip(@RequestBody Trip tripRequest) {
        Trip trip = tripService.create(tripRequest);
        return new ResponseEntity<>(trip,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Trip>> getAll(){
        List<Trip> tripList = tripService.getAll();
        return new ResponseEntity<>(tripList,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trip> getById(@PathVariable String id) throws Exception {
        Trip trip = tripService.getById(id);
        return new ResponseEntity<>(trip,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable String id){
        tripService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
