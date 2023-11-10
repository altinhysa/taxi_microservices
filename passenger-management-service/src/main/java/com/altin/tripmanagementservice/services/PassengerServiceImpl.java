package com.altin.tripmanagementservice.services;

import com.altin.tripmanagementservice.exceptions.PassengerNotFoundException;
import com.altin.tripmanagementservice.repositories.PassengerRepository;
import com.altin.tripmanagementservice.models.Passenger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService{

    private final PassengerRepository passengerRepository;

    public PassengerServiceImpl(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public Passenger create(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @Override
    public Passenger getById(long id) throws PassengerNotFoundException {
        return passengerRepository.findById(id).orElseThrow(PassengerNotFoundException::new);
    }

    @Override
    public List<Passenger> getAll() {
        return passengerRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        passengerRepository.deleteById(id);
    }
}
