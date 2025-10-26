package racingcar.exception;

public class CarException extends IllegalArgumentException {

    public CarException(String message) {
        super(message);
    }

    public CarException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }
}