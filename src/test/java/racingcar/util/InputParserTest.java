package racingcar.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputParserTest {

    @Test
    void 쉼표_구분자로_문자열을_나눈다() {
        //given
        String input = "pobi,woni,jun";

        //when
        List<String> result = InputParser.parseInput(input);

        //then
        assertThat(result).isEqualTo(List.of("pobi", "woni", "jun"));
    }

    @Test
    void 공백을_제거하고_문자열을_나눈다() {
        //given
        String input = "pobi ,  woni,  jun";

        //when
        List<String> result = InputParser.parseInput(input);

        //then
        assertThat(result).isEqualTo(List.of("pobi", "woni", "jun"));
    }
}