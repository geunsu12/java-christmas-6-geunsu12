package christmas.model;

import christmas.fixture.DateFixture;
import christmas.fixture.DishesFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static christmas.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;

public class DiscountTest {

    @DisplayName("정상적인 객체 생성 테스트")
    @Test
    void createValidDiscount() {

        Dishes dishes = DishesFixture.VALID_INPUT.toEntity();
        Bill bill = Bill.createBillFrom(dishes);

        Date date = DateFixture.VALID_INPUT.toEntity();

        Discount discount = Discount.createDiscountOf(bill, date);
        assertThat(discount.getEachDiscount(D_DAY_INDEX)).isEqualTo(VALID_TEST.D_DAY_DISCOUNT);
        assertThat(discount.getEachDiscount(WEEKDAY_INDEX)).isEqualTo(VALID_TEST.WEEKDAY_DISCOUNT);
        assertThat(discount.getEachDiscount(WEEKEND_INDEX)).isEqualTo(VALID_TEST.WEEKEND_DISCOUNT);
        assertThat(discount.getEachDiscount(SPECIAL_INDEX)).isEqualTo(VALID_TEST.SPECIAL_DISCOUNT);
        assertThat(discount.getEachDiscount(GIFT_INDEX)).isEqualTo(VALID_TEST.GIFT_DISCOUNT);

    }

    @DisplayName("첫번째 예제 할인 테스트")
    @Test
    void createFirstExampleDiscount() {

        Dishes dishes = DishesFixture.FIRST_EXAMPLE_INPUT.toEntity();
        Bill bill = Bill.createBillFrom(dishes);

        Date date = DateFixture.FIRST_EXAMPLE_INPUT.toEntity();

        Discount discount = Discount.createDiscountOf(bill, date);
        assertThat(discount.getEachDiscount(D_DAY_INDEX)).isEqualTo(FIRST_EXAMPLE.D_DAY_DISCOUNT);
        assertThat(discount.getEachDiscount(WEEKDAY_INDEX)).isEqualTo(FIRST_EXAMPLE.WEEKDAY_DISCOUNT);
        assertThat(discount.getEachDiscount(WEEKEND_INDEX)).isEqualTo(FIRST_EXAMPLE.WEEKEND_DISCOUNT);
        assertThat(discount.getEachDiscount(SPECIAL_INDEX)).isEqualTo(FIRST_EXAMPLE.SPECIAL_DISCOUNT);
        assertThat(discount.getEachDiscount(GIFT_INDEX)).isEqualTo(FIRST_EXAMPLE.GIFT_DISCOUNT);

    }

    @DisplayName("두번째 예제 할인 테스트")
    @Test
    void createSecondExampleDiscount() {

        Dishes dishes = DishesFixture.SECOND_EXAMPLE_INPUT.toEntity();
        Bill bill = Bill.createBillFrom(dishes);

        Date date = DateFixture.SECOND_EXAMPLE_INPUT.toEntity();

        Discount discount = Discount.createDiscountOf(bill, date);
        assertThat(discount.getEachDiscount(D_DAY_INDEX)).isEqualTo(SECOND_EXAMPLE.D_DAY_DISCOUNT);
        assertThat(discount.getEachDiscount(WEEKDAY_INDEX)).isEqualTo(SECOND_EXAMPLE.WEEKDAY_DISCOUNT);
        assertThat(discount.getEachDiscount(WEEKEND_INDEX)).isEqualTo(SECOND_EXAMPLE.WEEKEND_DISCOUNT);
        assertThat(discount.getEachDiscount(SPECIAL_INDEX)).isEqualTo(SECOND_EXAMPLE.SPECIAL_DISCOUNT);
        assertThat(discount.getEachDiscount(GIFT_INDEX)).isEqualTo(SECOND_EXAMPLE.GIFT_DISCOUNT);

    }

}
