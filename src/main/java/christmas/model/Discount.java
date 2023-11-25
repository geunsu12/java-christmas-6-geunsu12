package christmas.model;

import christmas.constants.Constants.DISCOUNT;

import java.util.*;

import static christmas.service.DiscountService.*;

public class Discount {

    private final Map<String,Integer> discount;

    private Discount(Bill bill, Date date) {
//      [디데이할인, 평일할인, 주말할인, 특별할인, 증정이벤트]
        this.discount = new HashMap<String, Integer>();
        discount.put(DISCOUNT.D_DAY, 0);
        discount.put(DISCOUNT.WEEKDAY, 0);
        discount.put(DISCOUNT.WEEKEND, 0);
        discount.put(DISCOUNT.SPECIAL, 0);
        discount.put(DISCOUNT.GIFT, 0);
        if(bill.isDiscountable()) {
            countDiscount(bill,date);
        }
    }

    public static Discount createDiscountOf(Bill bill, Date date) {
        return new Discount(bill, date);
    }

    public void countDiscount(Bill bill, Date date) {
        discount.put(DISCOUNT.D_DAY, getDDayDiscountEvent(date));
        discount.put(DISCOUNT.WEEKDAY, getWeekDiscount(bill.getWeekdayDiscountQuantity(date)));
        discount.put(DISCOUNT.WEEKEND, getWeekDiscount(bill.getWeekendDiscountQuantity(date)));
        discount.put(DISCOUNT.SPECIAL, getSpecialDiscount(date));
        discount.put(DISCOUNT.GIFT, getGiftDiscount(bill.isOverGiftThreshold()));
    }

    public Map<String, Integer> getDiscount() { return new HashMap<String, Integer>(discount); }

    public int getTotalDiscountNGift() {
        int sum = 0;
        for (Integer num : discount.values()) { sum += num; }
        return sum;
    }

    public int getTotalDiscount() {
        int sum = 0;
        for (Map.Entry<String, Integer> eachDiscount : discount.entrySet()) {
            if (eachDiscount.getKey() != DISCOUNT.GIFT) {
                sum += eachDiscount.getValue();
            }
        }
        return sum;
    }

    public String isGivenGift() {
        if (discount.get(DISCOUNT.GIFT) == 25000) { return "샴페인 1개"+System.lineSeparator(); }
        return "없음"+System.lineSeparator();
    }

}
