package com.altin.tripmanagementservice.services;

import com.altin.tripmanagementservice.exceptions.PassengerNotFoundException;
import com.altin.tripmanagementservice.models.Passenger;
import java.util.List;
public interface PassengerService {
    Passenger create(Passenger passenger);

    Passenger getById(long id) throws PassengerNotFoundException;

    List<Passenger> getAll();

    void deleteById(long id);
}
