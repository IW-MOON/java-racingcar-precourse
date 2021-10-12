package racinggame.domain;

import racinggame.dto.Car;

import java.util.Comparator;

public class CarComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return Long.compare(o2.getDistance().getDistance(), o1.getDistance().getDistance());
    }
}
