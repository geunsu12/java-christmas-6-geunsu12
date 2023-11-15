package christmas.service;

import christmas.domain.*;

import java.util.Map;

public class OutputService {
    private static final String[] discountOut = new String[]{
        "크리스마스 디데이 할인", "평일 할인", "주말 할인", "특별 할인", "증정 이벤트"
    };

    private OutputService() {}

    public static String generateOutputMessage(Bill bill, Discount discount, Date date, Dishes dishes, Badge badge) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n", date.getDate()));
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
        sb.append("\n<주문 메뉴>\n");
        for (Map.Entry<String, Integer> eachDish : dishes.getDishes().entrySet()) {
            sb.append(String.format("%s %d개\n", eachDish.getKey(), eachDish.getValue()));
        }
    }

    private static void appendTotalMoney(StringBuilder sb, Bill bill) {
        sb.append("\n<할인 전 총주문 금액>\n");
        sb.append(String.format("%,d원\n", bill.getTotalMoney()));
    }

    private static void appendGift(StringBuilder sb, Discount discount) {
        sb.append("\n<증정 메뉴>\n");
        sb.append(discount.isGivenGift());
    }

    private static void appendDiscountDetail(StringBuilder sb, Discount discount) {
        sb.append("\n<혜택 내역>\n");
        boolean isNotDiscount = true;
        for(int i=0;i<5;i++) {
            int tmp = discount.getEachDiscount(i)*-1;
            if (tmp != 0) {
                sb.append(String.format("%s : %,d원\n",discountOut[i],tmp));
                isNotDiscount = false;
            }
        }
        if (isNotDiscount) {
            sb.append("없음\n");
        }
    }

    private static void appendTotalDiscount(StringBuilder sb, Discount discount) {
        sb.append("\n<총혜택 금액>\n");
        sb.append(String.format("%,d원\n",discount.getTotalDiscountNGift()*-1));
    }

    private static void appendTotalPrice(StringBuilder sb, Bill bill, Discount discount) {
        sb.append("\n<할인 후 예상 결제 금액>\n");
        sb.append( String.format("%,d원\n",bill.getTotalMoney() - discount.getTotalDiscount()));
    }

    private static void appendBadge(StringBuilder sb, Badge badge) {
        sb.append("\n<12월 이벤트 배지>\n");
        sb.append(badge.getBadge());
    }
}
