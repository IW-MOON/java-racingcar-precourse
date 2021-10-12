package racinggame.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import racinggame.dto.Car;
import racinggame.dto.CarList;
import racinggame.dto.CarName;
import racinggame.dto.Distance;

import java.util.Collections;
import java.util.Iterator;

import static org.assertj.core.api.Assertions.*;

public class GameManagerTest {


    @DisplayName("랜덤값에_따른_자동차_전진테스트")
    @ParameterizedTest
    @CsvSource(value = {"ABD:4"}, delimiter = ':')
    void 랜덤값에_따른_자동차_전진테스트_4이상(String carName, int randomNumber) {
        // given
        GameManager gameManager = new GameManager();
        Car car = new Car(new CarName(carName), new Distance());
        // when
        gameManager.getCarMove(car, randomNumber);
        // then
        Assertions.assertTrue(car.getDistance().isSameDistance(new Distance(1L)));

    }

    @DisplayName("랜덤값에_따른_자동차_전진테스트")
    @ParameterizedTest
    @CsvSource(value = {"ABD:3"}, delimiter = ':')
    void 랜덤값에_따른_자동차_전진테스트_4미만(String carName, int randomNumber) {
        // given
        GameManager gameManager = new GameManager();
        Car car = new Car(new CarName(carName), new Distance());
        // when
        gameManager.getCarMove(car, randomNumber);
        // then
        Assertions.assertTrue(car.getDistance().isSameDistance(new Distance()));

    }
    @DisplayName("우승자 확인테스트")
    @ParameterizedTest
    @MethodSource("provideCarListForValidateWinnerCarNames")
    void 우승자_확인(CarList carList) {
        // given
        GameManager gameManager = new GameManager();
        // when
        String msg = gameManager.getWinnerCarNames(carList);
        // then
        assertThat(msg).contains("도우너").contains("홍길동");

    }

    private static Iterator<Arguments> provideCarListForValidateWinnerCarNames() {

        GameManager gameManager = new GameManager();
        CarList carList = new CarList();

        Car car1 = new Car(new CarName("도우너"), new Distance(4L));
        Car car2 = new Car(new CarName("둘리"), new Distance(3L));
        Car car3 = new Car(new CarName("홍길동"), new Distance(4L));

        carList.getCarList().add(car1);
        carList.getCarList().add(car2);
        carList.getCarList().add(car3);
        return Collections.singletonList(Arguments.of(carList)).iterator();
    }
}
