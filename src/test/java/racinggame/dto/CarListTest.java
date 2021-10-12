package racinggame.dto;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racinggame.GameRule;

public class CarListTest {

    @DisplayName("게임참가하는 자동차를 입력받아 CarList 생성테스트")
    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux", "allen,abeob"}, delimiter = ':')
    void 입력값에_따른_CarList_생성_테스트(String carName) {
        // given
        // when
        CarList carList = CarList.separateCarNames(carName);
        // then
        assertThat(carList.getCarList().size()).isEqualTo(carName.split(GameRule.CAR_NAME_SEPARATOR).length);
    }
}
