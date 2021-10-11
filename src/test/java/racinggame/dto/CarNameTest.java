package racinggame.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;

import static org.junit.jupiter.api.Assertions.*;

public class CarNameTest {

    @DisplayName("자동차 이름 테스트_성공")
    @ParameterizedTest
    @CsvSource(value = {"abcd1", "ab", "bb e"})
    void 자동차_이름_테스트_성공(String carName) {
        assertDoesNotThrow(() -> new CarName(carName));

    }

    @DisplayName("자동차 이름 테스트_예외")
    @ParameterizedTest
    @CsvSource(value = {"abcde1", "aa  ee"})
    void 자동차_이름_테스트_예외(String carName) {
        assertThrows(IllegalArgumentException.class, () -> new CarName(carName));
    }

    @DisplayName("자동차 이름 테스트_예외")
    @ParameterizedTest
    @EmptySource
    void 자동차_이름_테스트_빈값_예외(String carName) {
        assertThrows(IllegalArgumentException.class, () -> new CarName(carName));
    }
}
