package christmas.domain;

import christmas.service.InputService;

import java.util.HashMap;

public class Dishes {
    private final HashMap<String, Integer> dishes;

    private Dishes(String userInput) {
        this.dishes = InputService.separateUserInputToDishes(userInput);
    }

    public static Dishes createDishesFrom(String userInput) {
        return new Dishes(userInput);
    }

    public HashMap<String, Integer> getDishes() {
        return dishes;
    }
}
