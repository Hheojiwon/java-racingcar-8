package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingGame(Cars cars, RandomNumberGenerator randomNumberGenerator) {
        this.cars = cars;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void playOneRound() {
        List<Integer> randomNumbers = generateRandomNumbers();
        cars.moveCars(randomNumbers);
    }

    private List<Integer> generateRandomNumbers() {
        int carCount = cars.size();
        List<Integer> randomNumbers = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            randomNumbers.add(randomNumberGenerator.generate());
        }

        return randomNumbers;
    }

    public List<Car> getCurrentStatus() {
        return cars.getCars();
    }

    public List<String> getWinners() {
        return cars.getWinners();
    }
}