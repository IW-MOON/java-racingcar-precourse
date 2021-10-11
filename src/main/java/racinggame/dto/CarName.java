package racinggame.dto;


import racinggame.validation.InputValidationCheck;

public class CarName {

    private final String carName;

    public CarName(String carName) {
        InputValidationCheck.validateCarName(carName);
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

}
