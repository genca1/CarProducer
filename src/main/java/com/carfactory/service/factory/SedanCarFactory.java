package com.carfactory.service.factory;

import org.springframework.stereotype.Component;

@Component
public class SedanCarFactory implements CarFactory {

    @Override
    public String getType() {
        return "Sedan car has produced.";
    }
}
