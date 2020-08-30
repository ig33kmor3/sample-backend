package org.geek.sample.controller;

import org.geek.sample.model.Car;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = {"http://localhost:4200", "https://www.curiousquirrel.io"})
public class CarController {

    public CarController() { }

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getCars() {
        ArrayList<Car> carArrayList = new ArrayList<>();
        carArrayList.add(new Car("BMW", "3 Series", "2020"));
        carArrayList.add(new Car("Honda", "Civic", "2019"));
        carArrayList.add(new Car("Toyota", "Tacoma", "2018"));
        return ResponseEntity.ok(carArrayList);
    }
}
