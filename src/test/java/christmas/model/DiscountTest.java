package christmas.model;

import christmas.fixture.DateFixture;
import christmas.fixture.DishesFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static christmas.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;

public class DiscountTest {

    private final String D_DAY = "크리스마스 디데이 할인";
    private final String WEEKDAY = "평일 할인";
    private final String WEEKEND = "주말 할인";
    private final String SPECIAL = "특별 할인";
    private final String GIFT = "증정 이벤트";

    @DisplayName("정상적인 객체 생성 테스트")
    @Test
    void createValidDiscount() {

        Dishes dishes = DishesFixture.VALID_INPUT.toEntity();
        Bill bill = Bill.createBillFrom(dishes);

        Date date = DateFixture.VALID_INPUT.toEntity();

        Discount discount = Discount.createDiscountOf(bill, date);
        assertThat(discount.getDiscount().get(D_DAY)).isEqualTo(VALID_TEST.D_DAY_DISCOUNT);
        assertThat(discount.getDiscount().get(WEEKDAY)).isEqualTo(VALID_TEST.WEEKDAY_DISCOUNT);
        assertThat(discount.getDiscount().get(WEEKEND)).isEqualTo(VALID_TEST.WEEKEND_DISCOUNT);
        assertThat(discount.getDiscount().get(SPECIAL)).isEqualTo(VALID_TEST.SPECIAL_DISCOUNT);
        assertThat(discount.getDiscount().get(GIFT)).isEqualTo(VALID_TEST.GIFT_DISCOUNT);

    }

    @DisplayName("첫번째 예제 할인 테스트")
    @Test
    void createFirstExampleDiscount() {

        Dishes dishes = DishesFixture.FIRST_EXAMPLE_INPUT.toEntity();
        Bill bill = Bill.createBillFrom(dishes);

        Date date = DateFixture.FIRST_EXAMPLE_INPUT.toEntity();

        Discount discount = Discount.createDiscountOf(bill, date);
        assertThat(discount.getDiscount().get(D_DAY)).isEqualTo(FIRST_EXAMPLE.D_DAY_DISCOUNT);
        assertThat(discount.getDiscount().get(WEEKDAY)).isEqualTo(FIRST_EXAMPLE.WEEKDAY_DISCOUNT);
        assertThat(discount.getDiscount().get(WEEKEND)).isEqualTo(FIRST_EXAMPLE.WEEKEND_DISCOUNT);
        assertThat(discount.getDiscount().get(SPECIAL)).isEqualTo(FIRST_EXAMPLE.SPECIAL_DISCOUNT);
        assertThat(discount.getDiscount().get(GIFT)).isEqualTo(FIRST_EXAMPLE.GIFT_DISCOUNT);

    }

    @DisplayName("두번째 예제 할인 테스트")
    @Test
    void createSecondExampleDiscount() {

        Dishes dishes = DishesFixture.SECOND_EXAMPLE_INPUT.toEntity();
        Bill bill = Bill.createBillFrom(dishes);

        Date date = DateFixture.SECOND_EXAMPLE_INPUT.toEntity();

        Discount discount = Discount.createDiscountOf(bill, date);
        assertThat(discount.getDiscount().get(D_DAY)).isEqualTo(SECOND_EXAMPLE.D_DAY_DISCOUNT);
        assertThat(discount.getDiscount().get(WEEKDAY)).isEqualTo(SECOND_EXAMPLE.WEEKDAY_DISCOUNT);
        assertThat(discount.getDiscount().get(WEEKEND)).isEqualTo(SECOND_EXAMPLE.WEEKEND_DISCOUNT);
        assertThat(discount.getDiscount().get(SPECIAL)).isEqualTo(SECOND_EXAMPLE.SPECIAL_DISCOUNT);
        assertThat(discount.getDiscount().get(GIFT)).isEqualTo(SECOND_EXAMPLE.GIFT_DISCOUNT);

    }

}
