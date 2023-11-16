package christmas.service;

import christmas.model.Date;

import static christmas.constants.Constants.DISCOUNT.*;

public class DiscountService {

    private DiscountService() {}

    public static int getDDayDiscountEvent(Date date) {
        return date.getCountDay() * D_DAY_UNIT;
    }

    public static int getWeekDiscount(int quantity) {
        return quantity*WEEK_UNIT;
    }

    public static int getSpecialDiscount(Date date) {
        if (date.isStarDay()) { return SPECIAL_UNIT; }
        return 0;
    }

    public static int getGiftDiscount(Boolean isOvered) {
        if (isOvered) { return GIFT_UNIT; }
        return 0;
    }

}
