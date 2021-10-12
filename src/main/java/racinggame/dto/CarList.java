package racinggame.dto;

import racinggame.validation.InputValidationCheck;

import java.util.ArrayList;
import java.util.List;

public class CarList {

    private List<Car> carList = new ArrayList<Car>();

    public CarList(List<Car> carList) {
        this.carList = carList;
    }
    public CarList() {

    }
    public List<Car> getCarList() {
        return carList;
    }

    public static CarList separateCarNames(String carNames) {

        List<Car> carList = new ArrayList<>();
        String[] carNameArr = carNames.split(",");
        InputValidationCheck.validateCarCount(carNameArr);

        for (String carName : carNameArr) {
            carList.add(new Car(new CarName(carName), new Distance()));
        }
        return new CarList(carList);
    }
}
