package christmas.model;

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
        validateUserInputOutOfRange(dateNumber,MIN_DAY_NUMBER,MAX_DAY_NUMBER);
        return new Date(dateNumber);
    }

    public boolean isWeekend() {
        int remain = date % WEEK_DIVIDER;
        return (remain == FRIDAY || remain == SATURDAY);
    }

    public int getCountDay() {
        if (date > CHRISTMAS_DAY) { return 0; }
        return date-1+COUNT_BIAS;
    }

    public boolean isStarDay() {
        return (date % WEEK_DIVIDER == SUNDAY || date == CHRISTMAS_DAY);
    }

    public int getDate() { return this.date; }

}
