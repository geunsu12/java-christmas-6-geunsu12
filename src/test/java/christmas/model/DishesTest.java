package christmas.model;

import christmas.fixture.DishesFixture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DishesTest {

    @DisplayName("정상적인 객체 생성 테스트")
    @Test
    void createValidDishes() {
        Assertions.assertDoesNotThrow(DishesFixture.VALID_INPUT::toEntity);

        Assertions.assertDoesNotThrow(DishesFixture.ALL_MENU_INPUT::toEntity);

        Assertions.assertDoesNotThrow(DishesFixture.FIRST_EXAMPLE_INPUT::toEntity);

        Assertions.assertDoesNotThrow(DishesFixture.SECOND_EXAMPLE_INPUT::toEntity);
    }

    @DisplayName("객체 생성 예외 테스트")
    @Test
    void createInvalidDishes() {

        assertThatThrownBy(DishesFixture.ZERO_QUANTITY_INPUT::toEntity)
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(DishesFixture.DUPLICATED_INPUT::toEntity)
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(DishesFixture.OVER_INTEGER__QUANTITY_INPUT::toEntity)
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(DishesFixture.NOT_INTEGER_QUANTITY_INPUT::toEntity)
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(DishesFixture.NULL_INPUT::toEntity)
                .isInstanceOf(IllegalArgumentException.class);
    }


}
