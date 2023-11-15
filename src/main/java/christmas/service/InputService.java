package christmas.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static christmas.constants.Constants.EACH_DISH_DELIMITER;
import static christmas.constants.Constants.WHOLE_SENTENCE_DELIMITER;
import static christmas.validator.InputValidator.*;

public class InputService {

    private InputService() {}

    public static HashMap<String, Integer> separateUserInputToDishes(String userInput) {
        validateUserInputIsNull(userInput);
        String[] userInputs = userInput.split(WHOLE_SENTENCE_DELIMITER);
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        for(String eachInput : userInputs) {
            validateUserMenuInput(eachInput);
            validateNPutEachInput(eachInput,result);
        }
        return result;
    }

    private static void validateNPutEachInput(String eachInput, HashMap<String, Integer> result) {
        List<String> eachDish = Arrays.asList(eachInput.split(EACH_DISH_DELIMITER));
        validateMenuDuplicated(eachDish.get(0), result);
        validateMenuQuantity(eachDish.get(1));
        result.put(eachDish.get(0),Integer.parseInt(eachDish.get(1)));
    }

}
