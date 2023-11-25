package christmas.service;

import christmas.constants.Constants.DISCOUNT;
import christmas.model.Date;

import static christmas.constants.Constants.DISCOUNT.*;

public class DiscountService {

    private DiscountService() {}

    public static int getDDayDiscountEvent(Date date) {
        return date.getCountDay() * DISCOUNT.D_DAY_UNIT;
    }

    public static int getWeekDiscount(int quantity) {
        return quantity* DISCOUNT.WEEK_UNIT;
    }

    public static int getSpecialDiscount(Date date) {
        if (date.isStarDay()) { return DISCOUNT.SPECIAL_UNIT; }
        return 0;
    }

    public static int getGiftDiscount(Boolean isOvered) {
        if (isOvered) { return DISCOUNT.GIFT_UNIT; }
        return 0;
    }

}
