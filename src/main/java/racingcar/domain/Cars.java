package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    public List<Car> cars;

    public Cars(List<String> names) {
        this.cars = new ArrayList<>();
        for (String name : names) {
            this.cars.add(new Car(name));
        }
    }

    public void moveCars(List<Integer> randomNumbers) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).move(randomNumbers.get(i));
        }
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    public int getMaxPosition() {
        int maxPosition = 0;

        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        return maxPosition;
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public int size() {
        return cars.size();
    }
}