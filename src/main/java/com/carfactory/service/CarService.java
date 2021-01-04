package com.carfactory.service;

import com.carfactory.exception.CarNotFoundException;
import com.carfactory.service.factory.CarFactory;
import com.carfactory.model.CarTypeEnum;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Map;

@Service
@AllArgsConstructor
public class CarService{

    private final Map<String, CarFactory> factories;

    public String getCar(String carType) throws CarNotFoundException {
        if (carType.equals(CarTypeEnum.Cabrio.toString())) {
            return factories.get("cabrioCarFactory").getType();
        }
        else if(carType.equals(CarTypeEnum.Sedan.toString())) {
            return factories.get("sedanCarFactory").getType();
        }
        else if(carType.equals(CarTypeEnum.Hatchback.toString())) {
            return factories.get("hatchbackCarFactory").getType();
        }
        else throw new CarNotFoundException();
    }
}
