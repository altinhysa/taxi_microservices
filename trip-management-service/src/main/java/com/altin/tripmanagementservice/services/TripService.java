package com.altin.tripmanagementservice.services;

import com.altin.tripmanagementservice.models.Trip;
import java.util.List;
public interface TripService {

    Trip create(Trip trip);

    Trip getById(String id) throws Exception;

    List<Trip> getAll();

    void deleteById(String id);

}
