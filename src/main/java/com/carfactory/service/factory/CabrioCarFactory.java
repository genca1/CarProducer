package com.carfactory.service.factory;

import org.springframework.stereotype.Component;

@Component
public class CabrioCarFactory implements CarFactory {

    @Override
    public String getType() {
        return "Cabrio car has produced.";
    }
}
