package christmas.service;

import christmas.fixture.DateFixture;
import christmas.model.Date;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static christmas.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;

public class DiscountServiceTest {
    @DisplayName("정상적인 객체 생성 테스트")
    @Test
    void createValidDiscount() {

        Date date = DateFixture.VALID_INPUT.toEntity();

        assertThat(DiscountService.getDDayDiscountEvent(date)).isEqualTo(VALID_TEST.D_DAY_DISCOUNT);
        assertThat(DiscountService.getSpecialDiscount(date)).isEqualTo(VALID_TEST.SPECIAL_DISCOUNT);

    }

    @DisplayName("첫번째 예제 할인 테스트")
    @Test
    void createFirstExampleDiscount() {

        Date date = DateFixture.FIRST_EXAMPLE_INPUT.toEntity();

        assertThat(DiscountService.getDDayDiscountEvent(date)).isEqualTo(FIRST_EXAMPLE.D_DAY_DISCOUNT);
        assertThat(DiscountService.getSpecialDiscount(date)).isEqualTo(FIRST_EXAMPLE.SPECIAL_DISCOUNT);

    }

    @DisplayName("두번째 예제 할인 테스트")
    @Test
    void createSecondExampleDiscount() {

        Date date = DateFixture.SECOND_EXAMPLE_INPUT.toEntity();

        assertThat(DiscountService.getDDayDiscountEvent(date)).isEqualTo(SECOND_EXAMPLE.D_DAY_DISCOUNT);
        assertThat(DiscountService.getSpecialDiscount(date)).isEqualTo(SECOND_EXAMPLE.SPECIAL_DISCOUNT);

    }

}
