package com.carfactory.controller;

import com.carfactory.exception.CarNotFoundException;
import com.carfactory.model.CarRequest;
import com.carfactory.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@AllArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping("/")
    public ResponseEntity<String> getCarByType(@RequestBody CarRequest carRequest) throws CarNotFoundException {
        return new ResponseEntity<>(carService.getCar(carRequest.getCarTypeName()), HttpStatus.OK);
    }
}
