package io.codelex.myfirstspringapp.cars;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    private CarFactory carFactory;

    public CarController(CarFactory carFactory) {
        this.carFactory = carFactory;
    }

}
