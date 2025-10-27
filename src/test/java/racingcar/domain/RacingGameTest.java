package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.RandomNumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RacingGame 도메인 테스트")
public class RacingGameTest {

    @Test
    void 경주가_시작되면_모든_차가_이동한다() {
        //given
        RandomNumberGenerator mockGenerator = () -> 5;
        Cars cars = new Cars(List.of("pobi", "woni", "jun"));
        RacingGame game = new RacingGame(cars, mockGenerator);

        //when
        game.playOneRound();

        //then
        List<Car> carList = game.getCurrentStatus();
        assertThat(carList.get(0).getPosition()).isEqualTo(1);
        assertThat(carList.get(1).getPosition()).isEqualTo(1);
        assertThat(carList.get(2).getPosition()).isEqualTo(1);
    }

    @Test
    void 랜덤_값에_따라_전진여부가_결정된다() {
        //given
        final int[] values = {5, 3, 4};
        final int[] index = {0};

        RandomNumberGenerator mockGenerator = () -> values[index[0]++];

        Cars cars = new Cars(List.of("pobi", "woni", "jun"));
        RacingGame game = new RacingGame(cars, mockGenerator);

        //when
        game.playOneRound();

        // Then
        List<Car> carList = game.getCurrentStatus();
        assertThat(carList.get(0).getPosition()).isEqualTo(1);
        assertThat(carList.get(1).getPosition()).isEqualTo(0);
        assertThat(carList.get(2).getPosition()).isEqualTo(1);
    }

    @Test
    void 우승자를_올바르게_반환한다() {
        //given
        final int[] values = {
                5, 3, 4,
                5, 3, 4
        };
        final int[] index = {0};
        RandomNumberGenerator mockGenerator = () -> values[index[0]++];

        Cars cars = new Cars(List.of("pobi", "woni", "jun"));
        RacingGame game = new RacingGame(cars, mockGenerator);

        //when
        game.playOneRound();
        game.playOneRound();

        List<String> winners = game.getWinners();

        // Then
        assertThat(winners).isEqualTo(List.of("pobi", "jun"));
    }
}