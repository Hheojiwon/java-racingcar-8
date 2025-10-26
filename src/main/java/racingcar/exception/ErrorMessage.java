package racingcar.exception;

public enum ErrorMessage {

    EMPTY_NAME("자동차 이름은 비어있을 수 없습니다."),
    INVALID_NAME_LENGTH("자동차 이름은 5자 이하이어야 합니다."),
    NULL_OR_EMPTY_INPUT("입력값이 비어있거나 null 입니다."),
    INVALID_TRY_COUNT("시도 횟수 입력이 잘못된 형식입니다."),
    TRY_COUNT_TOO_LOW("시도 횟수는 1 이상이어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}