package christmas.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    @DisplayName("입력값이 정상 숫자가 아니면 예외가 발생한다.")
    @Test
    void createInputNonInteger() {
        String inputInteger = "1234";
        String inputNull = "";
        String inputString = "test";
        String inputOverflow = "12000000000";

        // 정상 숫자 입력했을 때 예외 미발생
        assertThatNoException().isThrownBy(() -> InputValidator.validateUserInputDate(inputInteger));

        // 문자 입력했을 때 예외 발생
        assertThatThrownBy(()->InputValidator.validateUserInputDate(inputNull))
                .isInstanceOf(IllegalArgumentException.class);

        // Null 입력했을 때 예외 발생
        assertThatThrownBy(()->InputValidator.validateUserInputDate(inputString))
                .isInstanceOf(IllegalArgumentException.class);

        // Integer 범위 밖의 숫자 입력했을 때 예외 발생
        assertThatThrownBy(()->InputValidator.validateUserInputDate(inputOverflow))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 수량이 정상 숫자가 아니면 예외가 발생한다.")
    @Test
    void createInputOutOfInteger() {
        String userInputCorrect = "12";
        String userInputWrong1 = "12000000000";
        String userInputWrong2 = "0";

        // 범위 안의 숫자 입력했을 때 예외 미발생
        assertThatNoException().isThrownBy(() -> InputValidator.validateMenuQuantity(userInputCorrect));

        // 범위 밖의 숫자 입력했을 때 예외 발생
        assertThatThrownBy(()->InputValidator.validateMenuQuantity(userInputWrong1))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()->InputValidator.validateMenuQuantity(userInputWrong2))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("입력값이 숫자 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createInputOutOfRange() {
        int userInputCorrect = 12;
        int userInputWrong = 46;
        int userInputWrong2 = -3;
        int minRange = 1;
        int maxRange = 31;

        // 범위 안의 숫자 입력했을 때 예외 미발생
        assertThatNoException().isThrownBy(() -> InputValidator.validateUserInputOutOfRange(userInputCorrect, minRange, maxRange));

        // 범위 밖의 숫자 입력했을 때 예외 발생
        assertThatThrownBy(()->InputValidator.validateUserInputOutOfRange(userInputWrong, minRange, maxRange))
                .isInstanceOf(IllegalArgumentException.class);

        // 범위 밖의 숫자 입력했을 때 예외 발생
        assertThatThrownBy(()->InputValidator.validateUserInputOutOfRange(userInputWrong2, minRange, maxRange))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 숫자 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createInputExceptionOfRegex() {
        String userInputCorrect = "제로콜라-1";
        String userInputWrong1 = "제로콜라1";
        String userInputWrong2 = "제로콜라=1";
        String userInputWrong3 = "제fh콜라-1";

        // 정상적으로 입력했을 때 예외 미발생
        assertThatNoException().isThrownBy(() -> InputValidator.validateUserMenuInput(userInputCorrect));

        // 비정상적으로 입력했을 때 예외 발생
        assertThatThrownBy(()->InputValidator.validateUserMenuInput(userInputWrong1))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()->InputValidator.validateUserMenuInput(userInputWrong2))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()->InputValidator.validateUserMenuInput(userInputWrong3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("전체 수량이 범위를 벗어나거나 음료수와 같으면 예외가 발생한다.")
    @Test
    void createInputOverLimitOrOnlyDrinks() {
        int sumCorrect = 12;
        int sumWrong1 = 5;
        int sumWrong2 = 21;
        int drinks = 5;


        // 정상적으로 입력했을 때 예외 미발생
        assertThatNoException().isThrownBy(() -> InputValidator.validateTotalQuantity(sumCorrect,drinks));

        // 비정상적으로 입력했을 때 예외 발생
        assertThatThrownBy(()->InputValidator.validateTotalQuantity(sumWrong1, drinks))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()->InputValidator.validateTotalQuantity(sumWrong2, drinks))
                .isInstanceOf(IllegalArgumentException.class);

    }

}
