package racinggame;

import racinggame.domain.Client;
import racinggame.domain.GameManager;
import racinggame.dto.CarList;
import racinggame.view.RacingGameView;

public class Application {

    public static void main(String[] args) {
        // TODO 자동차 경주 게임 구현
        Client client = new Client();
        RacingGameView racingGameView = new RacingGameView();
        GameManager gameManager = new GameManager();

        CarList carList = racingGameView.getInputCarNames(client);
        long gameCount = racingGameView.getInputGameCount(client);

        System.out.println(gameManager.getRacingGameResult(gameCount, carList));
        System.out.println(gameManager.getWinnerCarNames(carList));
    }
}
