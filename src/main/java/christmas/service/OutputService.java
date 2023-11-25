package christmas.service;

import christmas.model.*;

import java.util.Map;

public class OutputService {

    private static String linSeperator = System.lineSeparator();

    private OutputService() {}

    public static String generateOutputMessage(Bill bill, Discount discount, Date date, Dishes dishes, Badge badge) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!" + linSeperator, date.getDate()));
        appendDishes(sb, dishes);
        appendTotalMoney(sb, bill);
        appendGift(sb, discount);
        appendDiscountDetail(sb, discount);
        appendTotalDiscount(sb, discount);
        appendTotalPrice(sb, bill, discount);
        appendBadge(sb, badge);
        return sb.toString();
    }

    private static void appendDishes(StringBuilder sb, Dishes dishes) {
        sb.append(linSeperator+"<주문 메뉴>" + linSeperator);
        for (Map.Entry<String, Integer> eachDish : dishes.getDishes().entrySet()) {
            sb.append(String.format("%s %d개" + linSeperator, eachDish.getKey(), eachDish.getValue()));
        }
    }

    private static void appendTotalMoney(StringBuilder sb, Bill bill) {
        sb.append(linSeperator+"<할인 전 총주문 금액>"+linSeperator);
        sb.append(String.format("%,d원"+linSeperator, bill.getTotalMoney()));
    }

    private static void appendGift(StringBuilder sb, Discount discount) {
        sb.append(linSeperator+"<증정 메뉴>"+linSeperator);
        sb.append(discount.isGivenGift());
    }

    private static void appendDiscountDetail(StringBuilder sb, Discount discount) {
        sb.append(linSeperator+"<혜택 내역>"+linSeperator);
        boolean isNotDiscount = true;

        for (Map.Entry<String, Integer> eachDiscount : discount.getDiscount().entrySet()) {
            if (eachDiscount.getValue() != 0) {
                sb.append(String.format("%s : %,d원" + linSeperator, eachDiscount.getKey(), eachDiscount.getValue()));
                isNotDiscount = false;
            }
        }

        if (isNotDiscount) {
            sb.append("없음"+linSeperator);
        }
    }

    private static void appendTotalDiscount(StringBuilder sb, Discount discount) {
        sb.append(linSeperator+"<총혜택 금액>"+linSeperator);
        sb.append(String.format("%,d원"+linSeperator,discount.getTotalDiscountNGift()*-1));
    }

    private static void appendTotalPrice(StringBuilder sb, Bill bill, Discount discount) {
        sb.append(linSeperator+"<할인 후 예상 결제 금액>"+linSeperator);
        sb.append( String.format("%,d원"+linSeperator,bill.getTotalMoney() - discount.getTotalDiscount()));
    }

    private static void appendBadge(StringBuilder sb, Badge badge) {
        sb.append(linSeperator+"<12월 이벤트 배지>"+linSeperator);
        sb.append(badge.getBadge());
    }
}
