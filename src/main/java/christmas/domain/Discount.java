package christmas.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static christmas.service.DiscountService.*;

public class Discount {

    private static final int D_DAY_INDEX = 0;
    private static final int WEEKDAY_INDEX = 1;
    private static final int WEEKEND_INDEX = 2;
    private static final int SPECIAL_INDEX = 3;
    private static final int GIFT_INDEX = 4;

    private List<Integer> discount;

    private Discount(Bill bill, Date date) {
//      [디데이할인, 평일할인, 주말할인, 특별할인, 증정이벤트]
        this.discount = new ArrayList<>(Arrays.asList(0,0,0,0,0));
        if(bill.isDiscountable()) {
            countDiscount(bill,date);
        }
    }

    public static Discount createDiscountOf(Bill bill, Date date) {
        return new Discount(bill, date);
    }

    public void countDiscount(Bill bill, Date date) {
        discount.set(D_DAY_INDEX, getDDayDiscountEvent(date));
        discount.set(WEEKDAY_INDEX, getWeekDiscount(bill.getWeekdayDiscountQuantity(date)));
        discount.set(WEEKEND_INDEX, getWeekDiscount(bill.getWeekendDiscountQuantity(date)));
        discount.set(SPECIAL_INDEX, getSpecialDiscount(date));
        discount.set(GIFT_INDEX, getGiftDiscount(bill.isOverGiftThreshold()));
    }

    public int getEachDiscount(int index) { return discount.get(index); }

    public int getTotalDiscountNGift() {
        int sum = 0;
        for (int num : discount) { sum += num; }
        return sum;
    }

    public int getTotalDiscount() {
        int sum = 0;
        for (int i=0; i<4; i++) { sum += discount.get(i); }
        return sum;
    }

    public String isGivenGift() {
        if (discount.get(GIFT_INDEX) == 25000) { return "샴페인 1개\n"; }
        return "없음\n";
    }

}
