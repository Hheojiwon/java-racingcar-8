package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.Car;
import racingcar.util.InputParser;
import racingcar.util.RandomNumberGeneratorImpl;
import racingcar.validator.AttemptValidator;
import racingcar.validator.NameValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        List<String> carNames = getCarNames();
        int attemptCount = getAttemptCount();

        Cars cars = new Cars(carNames);
        RacingGame game = new RacingGame(cars, new RandomNumberGeneratorImpl());

        playGame(game, attemptCount);
        announceWinners(game);
        inputView.close();
    }

    private List<String> getCarNames() {
        outputView.printCarNameInputMessage();
        String input = inputView.readInput();

        List<String> names = InputParser.parseInput(input);
        for (String name : names) {
            NameValidator.validate(name);
        }
        return names;
    }

    private int getAttemptCount() {
        outputView.printAttemptCountInputMessage();
        String input = inputView.readInput();
        return AttemptValidator.validateAttemptCount(input);
    }

    private void playGame(RacingGame game, int attemptCount) {
        outputView.printResultHeader();

        for (int i = 0; i < attemptCount; i++) {
            game.playOneRound();
            printRoundResult(game.getCurrentStatus());
        }
    }

    private void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            outputView.printCarStatus(car.getName(), car.getPosition());
        }
        System.out.println();
    }

    private void announceWinners(RacingGame game) {
        List<String> winners = game.getWinners();
        outputView.printWinnerResult(winners);
    }
}