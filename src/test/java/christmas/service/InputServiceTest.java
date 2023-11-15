package christmas.service;

import christmas.fixture.DishesFixture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputServiceTest {
    @DisplayName("정상적인 입력 분할 테스트")
    @Test
    void createValidInput() {
        Assertions.assertDoesNotThrow(()->InputService.separateUserInputToDishes(DishesFixture.VALID_INPUT.getDishesInput()));

        Assertions.assertDoesNotThrow(()->InputService.separateUserInputToDishes(DishesFixture.ALL_MENU_INPUT.getDishesInput()));

        Assertions.assertDoesNotThrow(()->InputService.separateUserInputToDishes(DishesFixture.FIRST_EXAMPLE_INPUT.getDishesInput()));

        Assertions.assertDoesNotThrow(()->InputService.separateUserInputToDishes(DishesFixture.SECOND_EXAMPLE_INPUT.getDishesInput()));
    }

    @DisplayName("입력 분할 예외 테스트")
    @Test
    void createInvalidInput() {
        assertThatThrownBy(()->InputService.separateUserInputToDishes(DishesFixture.ZERO_QUANTITY_INPUT.getDishesInput()))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()->InputService.separateUserInputToDishes(DishesFixture.DUPLICATED_INPUT.getDishesInput()))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()->InputService.separateUserInputToDishes(DishesFixture.OVER_INTEGER__QUANTITY_INPUT.getDishesInput()))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()->InputService.separateUserInputToDishes(DishesFixture.NOT_INTEGER_QUANTITY_INPUT.getDishesInput()))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()->InputService.separateUserInputToDishes(DishesFixture.NULL_INPUT.getDishesInput()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
