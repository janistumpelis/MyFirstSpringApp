package io.codelex.myfirstspringapp.cars;

import org.springframework.stereotype.Component;

@Component
public class CarFactory {

    private Owner owner;

    public CarFactory(Owner owner) {
        this.owner = owner;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
