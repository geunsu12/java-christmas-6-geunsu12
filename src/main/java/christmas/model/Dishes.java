package christmas.model;

import christmas.service.InputService;

import java.util.HashMap;
import java.util.Map;

public class Dishes {
    private final Map<String, Integer> dishes;

    private Dishes(String userInput) {
        this.dishes = InputService.separateUserInputToDishes(userInput);
    }

    public static Dishes createDishesFrom(String userInput) {
        return new Dishes(userInput);
    }

    public Map<String, Integer> getDishes() { return new HashMap<String, Integer>(dishes); }
}
