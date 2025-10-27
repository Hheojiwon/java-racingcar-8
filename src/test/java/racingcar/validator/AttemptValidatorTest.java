package racingcar.validator;

import org.junit.jupiter.api.Test;
import racingcar.exception.CarException;
import racingcar.exception.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AttemptValidatorTest {

    @Test
    void 유효한_시도_횟수는_검증을_통과한다() {
        String input = "3";

        assertThatCode(() -> AttemptValidator.validateAttemptCount(input))
                .doesNotThrowAnyException();
    }

    @Test
    void 시도_횟수가_null인_경우_예외가_발생한다() {
        String input = null;

        assertThatThrownBy(() -> AttemptValidator.validateAttemptCount(input))
                .isInstanceOf(CarException.class)
                .hasMessage(ErrorMessage.NULL_OR_EMPTY_INPUT.getMessage());
    }

    @Test
    void 시도_횟수가_빈_문자열인_경우_예외가_발생한다() {
        String input = "";

        assertThatThrownBy(() -> AttemptValidator.validateAttemptCount(input))
                .isInstanceOf(CarException.class)
                .hasMessage(ErrorMessage.NULL_OR_EMPTY_INPUT.getMessage());
    }

    @Test
    void 시도_횟수가_0_이하인_경우_예외가_발생한다() {
        String input = "0";

        assertThatThrownBy(() -> AttemptValidator.validateAttemptCount(input))
                .isInstanceOf(CarException.class)
                .hasMessage(ErrorMessage.TRY_COUNT_TOO_LOW.getMessage());
    }

    @Test
    void 시도_횟수가_음수인_경우_예외가_발생한다() {
        String input = "-5";

        assertThatThrownBy(() -> AttemptValidator.validateAttemptCount(input))
                .isInstanceOf(CarException.class)
                .hasMessage(ErrorMessage.TRY_COUNT_TOO_LOW.getMessage());
    }

    @Test
    void 시도_횟수가_숫자가_아닌_경우_예외가_발생한다() {
        String input = "three";

        assertThatThrownBy(() -> AttemptValidator.validateAttemptCount(input))
                .isInstanceOf(CarException.class)
                .hasMessage(ErrorMessage.INVALID_TRY_COUNT.getMessage());
    }
}