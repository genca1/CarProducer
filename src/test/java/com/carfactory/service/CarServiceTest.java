package com.carfactory.service;

import com.carfactory.exception.CarNotFoundException;
import com.carfactory.model.CarRequest;
import com.carfactory.service.factory.CabrioCarFactory;
import com.carfactory.service.factory.CarFactory;
import com.carfactory.service.factory.HatchbackCarFactory;
import com.carfactory.service.factory.SedanCarFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class CarServiceTest {

    Map<String, CarFactory> factories = new HashMap<>();

    CabrioCarFactory cabrioCarFactory = new CabrioCarFactory();
    HatchbackCarFactory hatchbackCarFactory = new HatchbackCarFactory();
    SedanCarFactory sedanCarFactory = new SedanCarFactory();

    CarService carService = new CarService(factories);

    @BeforeEach
    public void init() {
        factories.put("cabrioCarFactory", cabrioCarFactory);
        factories.put("sedanCarFactory", sedanCarFactory);
        factories.put("hatchbackCarFactory", hatchbackCarFactory);
    }

    @Test
    void getCarForCabrio() {
        // Given
        CarRequest carRequest = createCarRequest("Cabrio");

        // When
        String result = carService.getCar(carRequest.getCarTypeName());

        // Then
        Assertions.assertEquals("Cabrio car has produced.", result);
    }

    @Test
    void getCarForHatchback() {
        // Given
        CarRequest carRequest = createCarRequest("Hatchback");

        // When
        String result = carService.getCar(carRequest.getCarTypeName());

        // Then
        Assertions.assertEquals("Hatchback car has produced.", result);
    }

    @Test
    void getCarForSedan() {
        // Given
        CarRequest carRequest = createCarRequest("Sedan");

        // When
        String result = carService.getCar(carRequest.getCarTypeName());

        // Then
        Assertions.assertEquals("Sedan car has produced.", result);
    }

    @Test
    void getCarThatThrowsException() {
        // Given
        Throwable exception = null;
        CarRequest carRequest = createCarRequest("OffRoad");

        // When
        try {
            carService.getCar(carRequest.getCarTypeName());
        } catch (Throwable ex) {
            exception = ex;
        }

        // Then
        Assertions.assertTrue(exception instanceof CarNotFoundException);
    }


    public CarRequest createCarRequest(String type) {
        return CarRequest.builder()
                .carTypeName(type)
                .build();
    }
}
