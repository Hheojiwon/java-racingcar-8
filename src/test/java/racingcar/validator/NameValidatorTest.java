package racingcar.validator;

import org.junit.jupiter.api.Test;
import racingcar.exception.CarException;
import racingcar.exception.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameValidatorTest {

    @Test
    void 정상적인_이름은_검증을_통과한다() {
        String name = "pobi";

        assertThatCode(() -> NameValidator.validate(name))
                .doesNotThrowAnyException();
    }

    @Test
    void 이름이_5글자를_초과할_경우_예외가_발생한다() {
        String name = "woowacourse";

        assertThatThrownBy(() -> NameValidator.validate(name))
                .isInstanceOf(CarException.class)
                .hasMessage(ErrorMessage.INVALID_NAME_LENGTH.getMessage());
    }

    @Test
    void 이름이_비어있는_경우_예외가_발생한다() {
        String name = "";

        assertThatThrownBy(() -> NameValidator.validate(name))
                .isInstanceOf(CarException.class)
                .hasMessage(ErrorMessage.EMPTY_NAME.getMessage());
    }

    @Test
    void 이름이_null값인_경우_예외가_발생한다() {
        String name = null;

        assertThatThrownBy(() -> NameValidator.validate(name))
                .isInstanceOf(CarException.class)
                .hasMessage(ErrorMessage.EMPTY_NAME.getMessage());
    }
}