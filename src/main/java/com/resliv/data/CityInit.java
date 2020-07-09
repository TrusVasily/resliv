package com.resliv.data;

import com.resliv.entity.City;
import com.resliv.repository.CityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CityInit implements CommandLineRunner {

    private final CityRepository cityRepository;

    public CityInit(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        addCities();
    }

    private void addCities() {
        City moscow = new City("Moscow", "Don't forget to visit Red Square.Well, you don't have to go into the Central Department Store!");
        City minsk = new City("Minsk", "You can visit the national library!");
        City kyiv = new City("Kyiv", "Don't forget to try the borscht :)");

        cityRepository.save(moscow);
        cityRepository.save(kyiv);
        cityRepository.save(minsk);

    }
}
