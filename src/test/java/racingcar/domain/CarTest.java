package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Car 도메인 테스트")
public class CarTest {

    @Test
    void 자동차_생성_테스트() {
        //given & when
        Car car = new Car("pobi");

        //then
        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 랜덤값이_4이상이면_전진한다() {
        //given
        Car car = new Car("pobi");
        int randomNumber = 4;

        //when
        car.move(randomNumber);

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 랜덤값이_4미만이면_전진하지_않는다() {
        //given
        Car car = new Car("pobi");

        //when
        int randomNumber = 3;
        car.move(randomNumber);

        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차의_전진값이_누적된다() {
        //given
        Car car = new Car("pobi");

        //when
        car.move(4);
        car.move(5);
        car.move(6);

        //then
        assertThat(car.getPosition()).isEqualTo(3);
    }
}