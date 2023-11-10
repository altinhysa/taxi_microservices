package com.altin.tripmanagementservice.controllers;

import com.altin.tripmanagementservice.exceptions.PassengerNotFoundException;
import com.altin.tripmanagementservice.models.Passenger;
import com.altin.tripmanagementservice.services.PassengerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/passengers")
public class PassengerController {

    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passenger> getById(@PathVariable long id) throws PassengerNotFoundException {
        Passenger passenger = passengerService.getById(id);
        return new ResponseEntity<>(passenger, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Passenger>> getAll(){
        List<Passenger> passengers = passengerService.getAll();
        return new ResponseEntity<>(passengers,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Passenger> add(@RequestBody Passenger passenger){
        Passenger createdPassenger = passengerService.create(passenger);
        return new ResponseEntity<>(createdPassenger,HttpStatus.CREATED);

    }

    
    @DeleteMapping("/{id}")
    public void delete(long id){
        passengerService.deleteById(id);
    }
}
