package christmas.view;

import christmas.domain.*;

import static christmas.service.OutputService.*;

public class OutputView {
    private OutputView() {};

    public static void printWelcomeMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
    }

    public static void printGetOrderMessage() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
    }

    public static void printOutputMessage(Bill bill, Discount discount, Date date, Dishes dishes, Badge badge) {
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!%n%n", date.getDate());
        System.out.printf("<주문 메뉴>%n");
        printDishes(dishes);
        System.out.printf("%n<할인 전 총주문 금액>%n");
        printTotalMoney(bill);
        System.out.printf("%n<증정 메뉴>%n");
        printGift(discount);
        System.out.printf("%n<혜택 내역>%n");
        printDiscountDetail(discount);
        System.out.printf("%n<총혜택 금액>%n");
        printTotalDiscount(discount);
        System.out.printf("%n<할인 후 예상 결제 금액>%n");
        printTotalPrice(bill, discount);
        System.out.printf("%n<12월 이벤트 배지>%n");
        System.out.printf(badge.getBadge());
    }


}
