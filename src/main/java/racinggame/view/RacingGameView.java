package racinggame.view;

import racinggame.GameMessage;
import racinggame.domain.Client;
import racinggame.dto.CarList;
import racinggame.validation.InputValidationCheck;


public class RacingGameView {

    public CarList getInputCarNames(Client client) {

        System.out.println(GameMessage.CAR_NAME_INPUT);
        String input = client.getClientInput();
        try {
            return CarList.separateCarNames(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInputCarNames(client);
        }
    }

    public long getInputGameCount(Client client) {
        System.out.println(GameMessage.TRY_COUNT_INPUT);
        String input = client.getClientInput();
        try {
            return InputValidationCheck.parseNumberType(input);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return getInputGameCount(client);
        }
    }

}
