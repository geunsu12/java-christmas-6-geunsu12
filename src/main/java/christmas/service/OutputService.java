package christmas.service;

import christmas.model.*;

import java.util.Map;

public class OutputService {

    private static String LINE_SEPERATOR = System.lineSeparator();

    private OutputService() {}

    public static String generateOutputMessage(Bill bill, Discount discount, Date date, Dishes dishes, Badge badge) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!" + LINE_SEPERATOR, date.getDate()));
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
        sb.append(LINE_SEPERATOR+"<주문 메뉴>" + LINE_SEPERATOR);
        for (Map.Entry<String, Integer> eachDish : dishes.getDishes().entrySet()) {
            sb.append(String.format("%s %d개" + LINE_SEPERATOR, eachDish.getKey(), eachDish.getValue()));
        }
    }

    private static void appendTotalMoney(StringBuilder sb, Bill bill) {
        sb.append(LINE_SEPERATOR+"<할인 전 총주문 금액>"+LINE_SEPERATOR);
        sb.append(String.format("%,d원"+LINE_SEPERATOR, bill.getTotalMoney()));
    }

    private static void appendGift(StringBuilder sb, Discount discount) {
        sb.append(LINE_SEPERATOR+"<증정 메뉴>"+LINE_SEPERATOR);
        sb.append(discount.isGivenGift());
    }

    private static void appendDiscountDetail(StringBuilder sb, Discount discount) {
        sb.append(LINE_SEPERATOR+"<혜택 내역>"+LINE_SEPERATOR);
        boolean isNotDiscount = true;

        for (Map.Entry<String, Integer> eachDiscount : discount.getDiscount().entrySet()) {
            if (eachDiscount.getValue() != 0) {
                sb.append(String.format("%s : %,d원" + LINE_SEPERATOR, eachDiscount.getKey(), eachDiscount.getValue()));
                isNotDiscount = false;
            }
        }

        if (isNotDiscount) {
            sb.append("없음"+LINE_SEPERATOR);
        }
    }

    private static void appendTotalDiscount(StringBuilder sb, Discount discount) {
        sb.append(LINE_SEPERATOR+"<총혜택 금액>"+LINE_SEPERATOR);
        sb.append(String.format("%,d원"+LINE_SEPERATOR,discount.getTotalDiscountNGift()*-1));
    }

    private static void appendTotalPrice(StringBuilder sb, Bill bill, Discount discount) {
        sb.append(LINE_SEPERATOR+"<할인 후 예상 결제 금액>"+LINE_SEPERATOR);
        sb.append( String.format("%,d원"+LINE_SEPERATOR,bill.getTotalMoney() - discount.getTotalDiscount()));
    }

    private static void appendBadge(StringBuilder sb, Badge badge) {
        sb.append(LINE_SEPERATOR+"<12월 이벤트 배지>"+LINE_SEPERATOR);
        sb.append(badge.getBadge());
    }
}
