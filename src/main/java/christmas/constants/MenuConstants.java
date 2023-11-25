package christmas.constants;

import java.util.Arrays;

import static christmas.constants.Constants.*;

public enum MenuConstants {

    MUSHROOM_SOUP("양송이수프", APPETIZER_IDX, 6000),
    TAPAS("타파스", APPETIZER_IDX, 5500),
    CAESAR_SALAD("씨저샐러드",APPETIZER_IDX, 8000),
    TBONE_STEAK("티본스테이크", MAIN_IDX, 55000),
    BARBECUE_RIP("바비큐립",  MAIN_IDX, 54000),
    SEAFOOD_PASTA("해산물파스타", MAIN_IDX, 35000),
    CHRISTMAS_PASTA("크리스마스파스타", MAIN_IDX, 25000),
    CHOCO_CAKE("초코케이크",DESSERT_IDX, 15000),
    ICE_CREAM("아이스크림", DESSERT_IDX, 5000),
    ZERO_COKE("제로콜라", DRINK_IDX, 3000),
    RED_WINE("레드와인", DRINK_IDX, 60000),
    CHAMPAGNE("샴페인", DRINK_IDX, 25000);

    private final String name;
    private final int type;
    private final int price;

    MenuConstants(String name, int type, int price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public static MenuConstants createMenuConstantsFrom(String menu) {
        return Arrays.stream(values())
                .filter(v -> menu.equals(v.name))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."));
    }

}
