package racinggame.dto;

public class Car {

    private final CarName carName;
    private final Distance distance;

    public Car(CarName carName, Distance distance) {
        this.carName = carName;
        this.distance = distance;
    }

    public CarName getCarName() {
        return carName;
    }

    public Distance getDistance() {
        return distance;
    }
}
