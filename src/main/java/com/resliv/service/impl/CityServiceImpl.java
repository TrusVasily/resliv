package com.resliv.service.impl;

import com.resliv.dto.CityDto;
import com.resliv.entity.City;
import com.resliv.exception.CustomValidation;
import com.resliv.repository.CityRepository;
import com.resliv.service.CityService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> getAllCities() {
        Optional<List<City>> list = Optional.of(cityRepository.findAll());
        return list.orElse(Collections.emptyList());
    }

    @Override
    public City getCityByName(String cityName) {
        return Optional.of(cityName)
                .map(cityRepository::findByCityName)
                .orElseThrow(() -> new CustomValidation("City with dat name doesn't exist!"));
    }

    @Transactional
    @Override
    public void deleteCityByName(String cityName) {
        if (Optional.of(cityRepository.findByCityName(cityName)).isPresent()) {
            cityRepository.deleteCityByCityName(cityName);
        } else throw new CustomValidation("City with dat name don't found :(");
    }

    @Override
    public void save(CityDto city) {
        City cityForSave = City.builder()
                .cityName(city.getCityName())
                .description(city.getDescription())
                .build();
        cityRepository.save(cityForSave);
    }

    @Override
    public void update(CityDto city) {
        Optional<City> updatedCity = Optional.of(cityRepository.findByCityName(city.getCityName()));
        if (updatedCity.isPresent()) {
            updatedCity.get().setDescription(city.getDescription());
            cityRepository.save(updatedCity.get());
        } else throw new CustomValidation("City with dat name don't found :(");
    }
}
