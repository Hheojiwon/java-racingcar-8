package racingcar.validator;

import racingcar.exception.CarException;
import racingcar.exception.ErrorMessage;

public class NameValidator {

    private final static int NAME_MAX_LENGTH = 5;

    public static void validate(String name){
        if (name == null || name.isBlank()){
            throw new CarException(ErrorMessage.EMPTY_NAME);
        }
        if (!checkNameLength(name)){
            throw new CarException(ErrorMessage.INVALID_NAME_LENGTH);
        }
    }

    private static boolean checkNameLength(String name){
        return name.length() <= NAME_MAX_LENGTH;
    }
}