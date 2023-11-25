package christmas.model;

import christmas.constants.Constants;

import static christmas.constants.Constants.*;
import static christmas.constants.Constants.CALENDER.*;
import static christmas.validator.InputValidator.*;

public class Date {

    private final int date;

    private Date(int date) {
        this.date = date;
    }

    public static Date createDateFrom(String date) {
        validateUserInputDate(date);
        int dateNumber = Integer.parseInt(date);
        validateUserInputOutOfRange(dateNumber, Constants.MIN_DAY_NUMBER,Constants.MAX_DAY_NUMBER);
        return new Date(dateNumber);
    }

    public boolean isWeekend() {
        int remain = date % CALENDER.WEEK_DIVIDER;
        return (remain == CALENDER.FRIDAY || remain == CALENDER.SATURDAY);
    }

    public int getCountDay() {
        if (date > CALENDER.CHRISTMAS_DAY) { return 0; }
        return date-1+CALENDER.COUNT_BIAS;
    }

    public boolean isStarDay() {
        return (date % CALENDER.WEEK_DIVIDER == CALENDER.SUNDAY || date == CALENDER.CHRISTMAS_DAY);
    }

    public int getDate() { return this.date; }

}
