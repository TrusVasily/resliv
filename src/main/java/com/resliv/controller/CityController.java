package com.resliv.controller;

import com.resliv.dto.CityDto;
import com.resliv.entity.City;
import com.resliv.service.CityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping(value = "/city")
    public void addCity(@RequestBody CityDto info) {
        cityService.save(info);
    }

    @PutMapping(value = "/city")
    public void updateDescription(@RequestBody CityDto info) {
        cityService.update(info);
    }

    @DeleteMapping(value = "/city/{name}")
    public void deleteCity(@PathVariable("name") String name) {
        cityService.deleteCityByName(name);
    }

    @GetMapping(value = "/cities")
    public List<City> getCities() {
        return cityService.getAllCities();
    }

    @GetMapping(value = "/city/{name}")
    public City getCity(@PathVariable("name") String name) {
        return cityService.getCityByName(name);
    }
}
