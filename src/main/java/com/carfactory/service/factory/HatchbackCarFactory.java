package com.carfactory.service.factory;

import org.springframework.stereotype.Component;

@Component
public class HatchbackCarFactory implements CarFactory {

    @Override
    public String getType() {
        return "Hatchback car has produced.";
    }
}
