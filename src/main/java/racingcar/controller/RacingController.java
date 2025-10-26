package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.Car;
import racingcar.exception.CarException;
import racingcar.exception.ErrorMessage;
import racingcar.util.InputParser;
import racingcar.util.RandomNumberGeneratorImpl;
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
        if (input == null || input.isEmpty()) {
            throw new CarException(ErrorMessage.NULL_OR_EMPTY_INPUT);
        }
        return parseAndValidateAttemptCount(input);
    }

    private int parseAndValidateAttemptCount(String input) {
        try {
            int count = Integer.parseInt(input);
            if (count <= 0) {
                throw new CarException(ErrorMessage.TRY_COUNT_TOO_LOW);
            }
            return count;
        } catch (NumberFormatException e) {
            throw new CarException(ErrorMessage.INVALID_TRY_COUNT);
        }
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