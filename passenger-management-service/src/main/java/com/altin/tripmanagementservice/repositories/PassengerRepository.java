package com.altin.tripmanagementservice.repositories;

import com.altin.tripmanagementservice.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger,Long> {
}
