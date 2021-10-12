package racinggame.domain;

import nextstep.utils.Randoms;
import racinggame.GameMessage;
import racinggame.GameRule;
import racinggame.dto.Car;
import racinggame.dto.CarList;
import racinggame.dto.Distance;

import java.util.List;
import java.util.StringJoiner;

public class GameManager {


    public String getRacingGameResult(long gameCount, CarList carList) {

        StringJoiner carMoveStatus = new StringJoiner("\n");
        for (long count = 0; count < gameCount; count++) {
            carMoveStatus.add(getOneRacingGameResult(carList));
        }
        return carMoveStatus.toString();
    }

    public String getOneRacingGameResult(CarList carList) {

        StringBuilder carMoveStatus = new StringBuilder();
        for (Car car : carList.getCarList()) {
            int randomNumber = Randoms.pickNumberInRange(GameRule.RANDOM_START_NUMBER, GameRule.RANDOM_END_NUMBER);
            carMoveStatus.append(getCarMove(car, randomNumber));
            carMoveStatus.append("\n");
        }
        return carMoveStatus.toString();
    }

    public String getCarMove(Car car, int randomNumber) {

        if (randomNumber >= GameRule.MOVING_CONDITION) {
            car.getDistance().increaseDistance();
        }
       return GameMessage.getCarMovingDistanceMsg(car.getCarName(), getCarMovingDistanceByDash(car.getDistance()));
    }

    private String getCarMovingDistanceByDash(Distance carDistance) {

        long distance = carDistance.getDistance();
        StringBuilder dash = new StringBuilder();
        while (distance > 0) {
            dash.append("-");
            distance--;
        }
        return dash.toString();
    }

    public String getWinnerCarNames(CarList carList){
        StringJoiner winCarNames = new StringJoiner(",");
        CarList winnerCarList = getWinnerCarList(carList);
        for (Car car : winnerCarList.getCarList()) {
            winCarNames.add(car.getCarName().getCarName());
        }
        return GameMessage.getGameWinnerMsg(winCarNames.toString());
    }

    private CarList getWinnerCarList(CarList carList) {

        CarList winnerList = new CarList();
        carList.getCarList().sort(new CarComparator());
        Distance maxDistance = null;
        for(Car car : carList.getCarList()){
            maxDistance = (maxDistance == null) ? car.getDistance() : maxDistance;
            compareDistance(winnerList.getCarList(), car, maxDistance);
        }
        return winnerList;
    }

    private void compareDistance(List<Car> winnerList, Car car, Distance maxDistance) {
        if(maxDistance.isSameDistance(car.getDistance())){
            winnerList.add(car);
        }
    }
}
