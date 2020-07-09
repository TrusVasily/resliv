package com.resliv.service;

import com.resliv.dto.CityDto;
import com.resliv.entity.City;

import java.util.List;

public interface CityService {
    List<City> getAllCities();

    City getCityByName(String cityName);

    void deleteCityByName(String cityName);

    void save(CityDto city);

    void update(CityDto city);
}
