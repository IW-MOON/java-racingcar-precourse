package racinggame;

import racinggame.dto.CarName;

public class GameMessage {

    public final static String CAR_NAME_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public final static String TRY_COUNT_INPUT = "시도할 횟수는 몇회인가요?";

    public final static String ERR_MSG = "[ERROR]";
    public final static String ERR_CAR_NAME_LENGTH = "자동차 이름은 " + GameRule.MAX_CAR_NAME_LENGTH + "자 이내로 입력해주세요.";
    public final static String ERR_GAME_COUNT = "0이 넘는 숫자만 입력해주세요.";
    public final static String ERR_CAR_COUNT = "게임 가능한 최소 자동차의 수는 " + GameRule.MIN_PLAYABLE_CAR_COUNT + "대 입니다.";

    public static String invalidInputMsg(String msg) {
        return String.format("%s %s", ERR_MSG, msg);
    }

    public static String getCarMovingDistanceMsg(CarName carName, String distanceByDash) {
        return String.format("%s %s %s", carName.getCarName(), ":", distanceByDash);
    }

    public static String getGameWinnerMsg(String winnerList) {
        return String.format("최종 우승자는 %s 입니다.", winnerList);
    }

}
