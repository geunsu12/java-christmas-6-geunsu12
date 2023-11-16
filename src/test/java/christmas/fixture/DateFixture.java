package christmas.fixture;

import christmas.model.Date;

public enum DateFixture {
    VALID_INPUT("15"),
    CHRISTMAS_INPUT("25"),
    WEEKDAY_INPUT("7"),
    WEEKEND_INPUT("8"),
    FIRST_EXAMPLE_INPUT("26"),
    SECOND_EXAMPLE_INPUT("3"),
    OVER_INPUT("32"),
    ZERO_INPUT("0"),
    NOT_INTEGER_INPUT("test"),
    OVER_INTEGER_INPUT("1000000000000");

    private final String date;

    DateFixture(String date) { this.date = date; }

    public Date toEntity() { return Date.createDateFrom(date); }

}
