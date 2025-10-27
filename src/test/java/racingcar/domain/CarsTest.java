package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Cars 도메인 태스트")
public class CarsTest {

    @Test
    void 자동차_이름_리스트로_Cars를_생성한다() {
        //given
        List<String> names = List.of("pobi", "woni", "jun");

        //when
        Cars cars = new Cars(names);

        //then
        assertThat(cars.size()).isEqualTo(3);
        assertThat(cars.getCars()).hasSize(3);

    }

    @Test
    void 여러대의_자동차를_전진시킨다() {
        //given
        Cars cars = new Cars(List.of("pobi", "woni", "jun"));
        List<Integer> randomNumbers = List.of(4, 3, 5);

        //when
        cars.moveCars(randomNumbers);

        //then
        assertThat(cars.getCars().get(0).getPosition()).isEqualTo(1);
        assertThat(cars.getCars().get(1).getPosition()).isEqualTo(0);
        assertThat(cars.getCars().get(2).getPosition()).isEqualTo(1);
    }

    @Test
    void 가장_멀리간_자동차가_우승자가_된다() {
        //given
        Cars cars = new Cars(List.of("pobi", "woni", "jun"));
        cars.moveCars(List.of(3, 4, 5));
        cars.moveCars(List.of(3, 3, 5));
        cars.moveCars(List.of(3, 3, 5));

        //when
        List<String> winners = cars.getWinners();

        //then
        assertThat(winners)
                .hasSize(1)
                .containsExactly("jun");
    }

    @Test
    void 우승자가_한명인경우_한명을_반환한다() {
        //given
        Cars cars = new Cars(List.of("pobi", "woni", "jun"));
        cars.moveCars(List.of(5, 3, 3));

        //when
        List<String> winners = cars.getWinners();

        //then
        assertThat(winners).hasSize(1);
        assertThat(winners).isEqualTo(List.of("pobi"));
    }

    @Test
    void 우승자가_여러명인_경우_우승자를_모두_반환한다() {
        //given
        Cars cars = new Cars(List.of("pobi", "woni", "jun"));
        cars.moveCars(List.of(5, 3, 5));

        //when
        List<String> winners = cars.getWinners();

        //then
        assertThat(winners).hasSize(2);
        assertThat(winners).isEqualTo(List.of("pobi", "jun"));
    }
}