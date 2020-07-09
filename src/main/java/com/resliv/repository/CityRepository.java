package com.resliv.repository;

import com.resliv.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    City findByCityName(String name);
    void deleteCityByCityName(String name);
}
