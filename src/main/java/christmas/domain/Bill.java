package christmas.domain;

import christmas.constants.MenuConstants;

import java.util.*;

import static christmas.constants.Constants.*;
import static christmas.constants.MenuConstants.createMenuConstantsFrom;
import static christmas.validator.InputValidator.validateTotalQuantity;

public class Bill {
    private int totalMoney;
    private ArrayList<Integer> bill;

    private Bill(Dishes dishes) {
        this.totalMoney = 0;

//      [appetizer, main_food, desserts, drinks]
        this.bill = new ArrayList<>(Arrays.asList(0,0,0,0));
        createBills(dishes.getDishes());
        validateTotalQuantity(getTotalQuantity(), bill.get(DRINK));
    }

    public static Bill createBillFrom(Dishes dishes) {
        return new Bill(dishes);
    }

    private void createBills(HashMap<String, Integer> dishes) {
        for (Map.Entry<String, Integer> eachDish : dishes.entrySet()) {
            MenuConstants menu = createMenuConstantsFrom(eachDish.getKey());
            bill.set(menu.getType(), bill.get(menu.getType()) + eachDish.getValue());
            totalMoney += (menu.getPrice()*eachDish.getValue());
        }
    }

    public boolean isDiscountable() {
        return totalMoney >= DISCOUNT_THRESHOLD;
    }

    public int getWeekendDiscountQuantity(Date date) {
        if (date.isWeekend()) { return bill.get(MAIN); }
        return 0;
    }

    public int getWeekdayDiscountQuantity(Date date) {
        if (!date.isWeekend()) { return bill.get(DESSERT); }
        return 0;
    }

    public boolean isOverGiftThreshold() {
        return totalMoney >= GIFT_THRESHOLD;
    }

    public int getTotalMoney() { return totalMoney; }

    private int getTotalQuantity() {
        return bill.stream().mapToInt(i->i).sum();
    }
}
