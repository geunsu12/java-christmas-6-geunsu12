package christmas.fixture;

import christmas.model.Dishes;

public enum DishesFixture {
    VALID_INPUT("양송이수프-1,티본스테이크-1,초코케이크-1,아이스크림-1,제로콜라-1"),
    ALL_MENU_INPUT("양송이수프-1,타파스-1,씨저샐러드-1,티본스테이크-1,바비큐립-1,해산물파스타-1,크리스마스파스타-1,초코케이크-1,아이스크림-1,제로콜라-1,레드와인-1,샴페인-1"),
    FIRST_EXAMPLE_INPUT("타파스-1,제로콜라-1"),
    SECOND_EXAMPLE_INPUT("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1"),

    ZERO_QUANTITY_INPUT("티본스테이크-0,바비큐립-1,초코케이크-2,제로콜라-1"),
    DUPLICATED_INPUT("리본스테이크-1,바비큐립-1,바비큐립-1,초코케이크-2,제로콜라-1"),
    OVER_INTEGER__QUANTITY_INPUT("티본스테이크-10000000000,바비큐립-1,초코케이크-2,제로콜라-1"),
    NOT_INTEGER_QUANTITY_INPUT("티본스테이크-test,바비큐립-1"),
    NULL_INPUT(""),

    NOT_IN_MENU_INPUT("리본스테이크-10,바비큐립서비스-2"),
    OVER_QUANTITIES_INPUT("티본스테이크-20,바비큐립-1,초코케이크-2,제로콜라-1");



    private final String dishesInput;

    DishesFixture(String dishesInput) { this.dishesInput = dishesInput; }

    public Dishes toEntity() { return Dishes.createDishesFrom(dishesInput); }

    public String getDishesInput() {return dishesInput; }

}
