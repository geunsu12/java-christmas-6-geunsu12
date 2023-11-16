package christmas.model;

import christmas.fixture.DishesFixture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BillTest {

    @DisplayName("정상적인 객체 생성 테스트")
    @Test
    void createValidBill() {
        Dishes dishes = DishesFixture.VALID_INPUT.toEntity();
        Assertions.assertDoesNotThrow(() -> Bill.createBillFrom(dishes));
    }

    @DisplayName("모든 메뉴 인식 테스트")
    @Test
    void createAllMenuBill() {

        int TOTAL_PRICE = 296500;

        Dishes dishes = DishesFixture.ALL_MENU_INPUT.toEntity();
        Bill bill = Bill.createBillFrom(dishes);
        assertThat(bill.getTotalMoney()).isEqualTo(TOTAL_PRICE);
    }

    @DisplayName("객체 생성 예외 테스트")
    @Test
    void createInvalidBill() {
        Dishes notInMenuDishes = DishesFixture.NOT_IN_MENU_INPUT.toEntity();
        Dishes overDishes = DishesFixture.OVER_QUANTITIES_INPUT.toEntity();

        assertThatThrownBy(()-> Bill.createBillFrom(notInMenuDishes))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()-> Bill.createBillFrom(overDishes))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
