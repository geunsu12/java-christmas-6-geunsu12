package christmas.view;

import christmas.model.*;

import static christmas.service.OutputService.*;

public class OutputView {
    private OutputView() {};

    public static void printWelcomeMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.%n12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
    }

    public static void printGetOrderMessage() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
    }

    public static void printOutputMessage(Bill bill, Discount discount, Date date, Dishes dishes, Badge badge) {
        System.out.println(generateOutputMessage(bill, discount, date, dishes, badge));
    }


}
