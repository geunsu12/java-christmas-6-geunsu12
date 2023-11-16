package christmas.model;

import christmas.fixture.DateFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DateTest {

    @DisplayName("객체 생성 테스트")
    @Test
    void createValidDate() {
        Date date = DateFixture.VALID_INPUT.toEntity();
        assertThat(date.getDate()).isEqualTo(15);
    }

    @DisplayName("특별 할인 날짜 테스트")
    @Test
    void createStarDate() {
        Date date = DateFixture.CHRISTMAS_INPUT.toEntity();
        assertThat(date.getDate()).isEqualTo(25);
        assertThat(date.isStarDay()).isEqualTo(true);
        assertThat(date.isWeekend()).isEqualTo(false);
        assertThat(date.getCountDay()).isEqualTo(34);
    }

    @DisplayName("평일 날짜 테스트")
    @Test
    void createWeekDayDate() {
        Date date = DateFixture.WEEKDAY_INPUT.toEntity();
        assertThat(date.getDate()).isEqualTo(7);
        assertThat(date.isStarDay()).isEqualTo(false);
        assertThat(date.isWeekend()).isEqualTo(false);
        assertThat(date.getCountDay()).isEqualTo(16);
    }

    @DisplayName("주말 날짜 테스트")
    @Test
    void createWeekendDate() {
        Date date = DateFixture.WEEKEND_INPUT.toEntity();
        assertThat(date.getDate()).isEqualTo(8);
        assertThat(date.isStarDay()).isEqualTo(false);
        assertThat(date.isWeekend()).isEqualTo(true);
        assertThat(date.getCountDay()).isEqualTo(17);
    }

    @DisplayName("날짜 예외 테스트")
    @Test
    void createInvalidDate() {
        assertThatThrownBy(DateFixture.OVER_INPUT::toEntity)
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(DateFixture.ZERO_INPUT::toEntity)
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(DateFixture.NOT_INTEGER_INPUT::toEntity)
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(DateFixture.OVER_INTEGER_INPUT::toEntity)
                .isInstanceOf(IllegalArgumentException.class);
    }

}
