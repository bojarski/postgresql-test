package com.postgresql.test.postgresql.api;

import com.postgresql.test.postgresql.domain.City;
import com.postgresql.test.postgresql.domain.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/test")
class TestEndpoint {

    private final CityRepository cityRepository;

    @Autowired
    public TestEndpoint(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping("/add")
    void test() {
        String id = UUID.randomUUID().toString();
        City city = new City(id, "tor", 23);
        cityRepository.save(city);
    }

    @GetMapping("/get")
    List<City> get() {
        List<City> cities = new ArrayList<>();
        cityRepository.findAll().forEach(v -> cities.add(v));
        return cities;
    }
}
