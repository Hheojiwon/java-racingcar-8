package racingcar.validator;

import racingcar.exception.CarException;
import racingcar.exception.ErrorMessage;

public class AttemptValidator {

    public static int validateAttemptCount(String input) {
        validateNotEmpty(input);
        int count = parseAttemptCount(input);
        validatePositive(count);
        return count;
    }

    private static void validateNotEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new CarException(ErrorMessage.NULL_OR_EMPTY_INPUT);
        }
    }

    private static int parseAttemptCount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new CarException(ErrorMessage.INVALID_TRY_COUNT);
        }
    }

    private static void validatePositive(int count) {
        if (count <= 0) {
            throw new CarException(ErrorMessage.TRY_COUNT_TOO_LOW);
        }
    }
}
