package christmas.service;

import christmas.domain.Bill;
import christmas.domain.Discount;
import christmas.domain.Dishes;

import java.util.Map;

import static christmas.util.utils.addComma;

public class OutputService {
    private static final String[] discountOut = new String[]{
        "크리스마스 디데이 할인", "평일 할인", "주말 할인", "특별 할인", "증정 이벤트"
    };

    private OutputService() {}

    public static void printTotalMoney(Bill bill) {
        System.out.println(addComma(bill.getTotalMoney())+"원");
    }

    public static void printDishes(Dishes dishes) {
        for (Map.Entry<String, Integer> eachDish : dishes.getDishes().entrySet()) {
            System.out.println(eachDish.getKey() + String.format(" %d개", eachDish.getValue()));
        }
    }

    public static void printGift(Discount discount) {
        System.out.println(discount.isGivenGift());
    }

    public static void printDiscountDetail(Discount discount) {
        boolean isNotDiscount = true;
        for(int i=0;i<5;i++) {
            int tmp = discount.getEachDiscount(i)*-1;
            if (tmp != 0) {
                System.out.println(discountOut[i] + ": " + addComma(tmp) + "원");
                isNotDiscount = false;
            }
        }
        if (isNotDiscount) {
            System.out.println("없음");
        }
    }

    public static void printTotalDiscount(Discount discount) {
        int sum = discount.getTotalDiscountNGift()*-1;
        System.out.println(addComma(sum) + "원");
    }

    public static void printTotalPrice(Bill bill, Discount discount) {
        int totalPrice = bill.getTotalMoney() - discount.getTotalDiscount();
        System.out.println( addComma(totalPrice) + "원");

    }

}
