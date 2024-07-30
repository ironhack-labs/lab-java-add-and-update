package com.ironhack.labweek10.controller;


import com.ironhack.labweek10.model.Location;
import com.ironhack.labweek10.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
@RequiredArgsConstructor

public class LocationController {
    private final LocationService locationService;

    @GetMapping
    public List<Location> findAll() {
        return LocationService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Location addLocation(@RequestBody @Validated Location location) {
        return locationService.addLocation(location);
    }

    @PutMapping("/{locationId}")
    public Location updateLocation(@PathVariable("locationId") Long locationId,
                                   @RequestBody Location location) {
        return locationService.updateLocation(locationId, location);
    }

    @DeleteMapping("/{locationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLocation(@PathVariable("locationId") Long locationId) {
        locationService.deleteLocation(locationId);
    }

}