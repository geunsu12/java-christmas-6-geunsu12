package christmas.controller;

import christmas.domain.*;
import christmas.view.OutputView;

import static christmas.domain.Bill.createBillFrom;
import static christmas.domain.Date.createDateFrom;
import static christmas.domain.Discount.createDiscountOf;
import static christmas.domain.Dishes.createDishesFrom;
import static christmas.view.InputView.readLine;
import static christmas.view.OutputView.printGetOrderMessage;
import static christmas.view.OutputView.printOutputMessage;

public class MainController {

    private Date date;
    private Dishes dishes;
    private Bill bill;
    private Discount discount;
    private Badge badge;

    public MainController() {}

    public void createDateWithException() {
        OutputView.printWelcomeMessage();
        while (true) {
            try {
                date = createDateFrom(readLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public void createDishesNBillWithException() {
        printGetOrderMessage();
        while (true) {
            try {
                dishes = createDishesFrom(readLine());
                bill = createBillFrom(dishes);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void runDiscount() {
        discount = createDiscountOf(bill,date);
        badge = Badge.createBadgeFrom(discount.getTotalDiscountNGift());
    }

    public void printResult() {
        printOutputMessage(bill, discount, date, dishes, badge);
    }
}
