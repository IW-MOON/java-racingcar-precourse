package racinggame.validation;

import racinggame.GameMessage;
import racinggame.GameRule;

public class InputValidationCheck {

    public static void validateCarName(String carName) {
        if(carName.isEmpty()){
            throw new IllegalArgumentException(GameMessage.invalidInputMsg(GameMessage.ERR_CAR_NAME_LENGTH));
        }

        if (carName.length() > GameRule.MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(GameMessage.invalidInputMsg(GameMessage.ERR_CAR_NAME_LENGTH));
        }
    }

    public static void validateCarCount(String[] carNameArr) {
        if(carNameArr.length < GameRule.MIN_PLAYABLE_CAR_COUNT){
            throw new IllegalArgumentException(GameMessage.ERR_CAR_COUNT);
        }
    }

    private static void checkMoreZero(long count){
        if(count <= 0){
            throw new NumberFormatException();
        }
    }
    public static long parseNumberType(String input) {

        try {
            long count = Long.parseLong(input);
            checkMoreZero(count);
            return count;
        } catch (NumberFormatException e) {
            throw new NumberFormatException(GameMessage.invalidInputMsg(GameMessage.ERR_GAME_COUNT));
        }

    }
}
