package christmas.validator;

import christmas.constants.MenuConstants;

import java.util.*;

import static christmas.constants.Constants.*;

public class InputValidator {

    private static final String ERROR_MESSAGE_DATE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static final String ERROR_MESSAGE_MENU = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    private InputValidator() {}

    public static void validateUserInputDate(String userInput) throws IllegalArgumentException {
        if(!userInput.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(ERROR_MESSAGE_DATE);
        }
    }

    public static void validateUserInputIsNull(String userInput) throws IllegalArgumentException {
        if(userInput.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MENU);
        }
    }

    public static void validateUserInputIsOverflow(String userInput) throws IllegalArgumentException {
        if(userInput.length()>MAX_INT_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MENU);
        }
    }

    public static void validateUserInputOutOfRange(int userInput, int minRange, int maxRange) throws IllegalArgumentException {
        if (userInput < minRange || userInput > maxRange) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateUserMenuInput(String userInput) throws IllegalArgumentException {
        if(!userInput.matches("^[가-힣]+-+[0-9]*$")) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MENU);
        }
    }

    public static void validateMenuDuplicated(String userInputKey, HashMap<String, Integer> result) throws IllegalArgumentException {
        if(result.containsKey(userInputKey)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MENU);
        }
    }

    public static void validateTotalQuantity(int sum, int drinks) throws IllegalArgumentException {
        if (sum > TOTAL_MENU_LIMIT || sum == drinks) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MENU);
        }
    }

    public static void validateMenuQuantity(String quantity) throws IllegalArgumentException {
        validateUserInputIsOverflow(quantity);
        if(quantity.equals("0")) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MENU);
        }
    }
}
