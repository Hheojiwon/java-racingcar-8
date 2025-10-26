package racingcar.domain;

public class Car {

    private static final int DEFAULT_POSITION = 0;
    private static final int MOVE_THRESHOLD = 4;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = DEFAULT_POSITION;
    }

    public void move(int randomNumber) {
        if (canMove(randomNumber)) {
            position++;
        }
    }

    private boolean canMove(int randomNumber) {
        return randomNumber >= MOVE_THRESHOLD;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
