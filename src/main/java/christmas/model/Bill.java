package christmas.model;

import christmas.constants.Constants;
import christmas.constants.MenuConstants;

import java.util.*;

import static christmas.constants.MenuConstants.createMenuConstantsFrom;
import static christmas.validator.InputValidator.validateTotalQuantity;

public class Bill {
    private int totalMoney;
    private final List<Integer> bill;

    private Bill(Dishes dishes) {
        this.totalMoney = 0;

//      [appetizer, main_food, desserts, drinks]
        this.bill = new ArrayList<>(Arrays.asList(0,0,0,0));
        createBills(dishes.getDishes());
        validateTotalQuantity(getTotalQuantity(), bill.get(Constants.DRINK_IDX));
    }

    public static Bill createBillFrom(Dishes dishes) {
        return new Bill(dishes);
    }

    private void createBills(Map<String, Integer> dishes) {
        for (Map.Entry<String, Integer> eachDish : dishes.entrySet()) {
            MenuConstants menu = createMenuConstantsFrom(eachDish.getKey());
            bill.set(menu.getType(), bill.get(menu.getType()) + eachDish.getValue());
            totalMoney += (menu.getPrice()*eachDish.getValue());
        }
    }

    public boolean isDiscountable() {
        return totalMoney >= Constants.DISCOUNT_THRESHOLD;
    }

    public int getWeekendDiscountQuantity(Date date) {
        if (date.isWeekend()) { return bill.get(Constants.MAIN_IDX); }
        return 0;
    }

    public int getWeekdayDiscountQuantity(Date date) {
        if (!date.isWeekend()) { return bill.get(Constants.DESSERT_IDX); }
        return 0;
    }

    public boolean isOverGiftThreshold() {
        return totalMoney >= Constants.GIFT_THRESHOLD;
    }

    public int getTotalMoney() { return totalMoney; }

    private int getTotalQuantity() {
        return bill.stream().mapToInt(i->i).sum();
    }
}
