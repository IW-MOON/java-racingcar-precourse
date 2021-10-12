package racinggame.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputValidationCheckTest {

    @DisplayName("최소한의 자동차 수 입력 검증")
    @ParameterizedTest
    @MethodSource("provideArraysForValidateCarCountSuccess")
    void 자동차_수_제한_테스트_성공(String[] carNameArr) {
        assertDoesNotThrow(() -> InputValidationCheck.validateCarCount(carNameArr));

    }

    @DisplayName("최소한의 자동차 수 입력 검증")
    @ParameterizedTest
    @MethodSource("provideArraysForValidateCarCountFail")
    void 자동차_수_제한_테스트_예외(String[] carNameArr) {

        assertThrows(IllegalArgumentException.class, () ->InputValidationCheck.validateCarCount(carNameArr));
    }

    private static Iterator<Arguments> provideArraysForValidateCarCountSuccess() {

        return Arrays.asList(
                Arguments.of((Object) new String[]{"pobi","crong"}),
                Arguments.of((Object) new String[]{"pobi","crong","habit"})).iterator();

    }
    private static Iterator<Arguments> provideArraysForValidateCarCountFail() {

        return Collections.singletonList(
                Arguments.of((Object) new String[]{"pobi"})).iterator();
    }

    @DisplayName("게임시도횟수 입력 테스트_성공")
    @ParameterizedTest
    @ValueSource(longs = {1L, Long.MAX_VALUE})
    void 게임시도횟수_입력_테스트_성공(long input) {
        assertDoesNotThrow(() -> InputValidationCheck.parseNumberType(String.valueOf(input)));
    }

    @DisplayName("게임시도횟수 입력 테스트_예외")
    @ParameterizedTest
    @ValueSource(longs = {0L, -1L})
    void 게임시도횟수_입력_테스트_예외(long input) {
        assertThrows(IllegalArgumentException.class, () ->InputValidationCheck.parseNumberType(String.valueOf(input)));
    }
}
