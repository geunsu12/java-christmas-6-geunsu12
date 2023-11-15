package christmas.controller;

import christmas.model.*;
import christmas.template.ExceptionTemplate;
import christmas.view.OutputView;

import static christmas.model.Bill.createBillFrom;
import static christmas.model.Date.createDateFrom;
import static christmas.model.Discount.createDiscountOf;
import static christmas.model.Dishes.createDishesFrom;
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
        ExceptionTemplate.execute(this::createDate);
    }

    private void createDate() {
        date = createDateFrom(readLine());
    }

    public void createDishesNBillWithException() {
        printGetOrderMessage();
        ExceptionTemplate.execute(this::createDishesNBill);
    }

    private void createDishesNBill() {
        dishes = createDishesFrom(readLine());
        bill = createBillFrom(dishes);
    }

    public void runDiscount() {
        discount = createDiscountOf(bill,date);
        badge = Badge.createBadgeFrom(discount.getTotalDiscountNGift());
    }

    public void printResult() {
        printOutputMessage(bill, discount, date, dishes, badge);
    }
}
