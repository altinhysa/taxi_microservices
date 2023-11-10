package com.altin.tripmanagementservice.repositories;

import com.altin.tripmanagementservice.models.Trip;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TripRepository extends MongoRepository<Trip,String> {
}
