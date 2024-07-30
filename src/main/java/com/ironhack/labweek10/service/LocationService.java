package com.ironhack.labweek10.service;

import ironhack.com.helloplantmanagment.Repository.LocationRepository;
import ironhack.com.helloplantmanagment.model.Location;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class LocationService {
    private final LocationRepository locationRepository;

    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    //add a location
    public Location addLocation(Location location) {
        log.info("Adding a new location{}", location);
        return locationRepository.save(location);
    }

    //update a location
    public Location updateLocation(Long locationId, Location location) {
        log.info("updating a location with id{}", locationId);
        var locationToUpdate = locationRepository.findById(locationId).orElseThrow();
        locationToUpdate.setName(location.getName());
        return locationRepository.save(locationToUpdate);
    }

    //delete location
    public void deleteLocation(Long locationId) {
        log.info("Deleting a location with ID{}", locationId);
        locationRepository.deleteById(locationId);
    }
}
