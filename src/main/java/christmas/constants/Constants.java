package christmas.constants;

public class Constants {

    private Constants() {}

    public static final int MIN_DAY_NUMBER = 1;
    public static final int MAX_DAY_NUMBER = 31;

    public static final String WHOLE_SENTENCE_DELIMITER = ",";
    public static final String EACH_DISH_DELIMITER = "-";

    public static final int TOTAL_MENU_LIMIT = 20;
    public static final int MAX_INT_LENGTH = 9;

    public static final int APPETIZER = 0;
    public static final int MAIN = 1;
    public static final int DESSERT = 2;
    public static final int DRINK = 3;

    public static final int DISCOUNT_THRESHOLD = 10000;
    public static final int GIFT_THRESHOLD = 120000;

    public static class DISCOUNT {
        public static final int D_DAY_UNIT = 100;
        public static final int WEEK_UNIT = 2023;
        public static final int SPECIAL_UNIT = 1000;
        public static final int GIFT_UNIT = 25000;
    }

    public static class BADGE {
        public static final int FIRST_THRESHOLD = 20000;
        public static final int SECOND_THRESHOLD = 10000;
        public static final int THIRD_THRESHOLD = 5000;

        public static final String FIRST_BADGE = "산타";
        public static final String SECOND_BADGE = "트리";
        public static final String THIRD_BADGE = "별";
        public static final String NON_BADGE = "없음";

    }

    public static class CALENDER {
        public static final int WEEK_DIVIDER = 7;
        public static final int MONDAY = 4;
        public static final int TUESDAY = 5;
        public static final int WEDNESDAY = 6;
        public static final int THURSDAY = 0;
        public static final int FRIDAY = 1;
        public static final int SATURDAY = 2;
        public static final int SUNDAY = 3;

        public static final int CHRISTMAS_DAY = 25;

//      디데이 카운트 할인 금액 디폴트값 1000원
        public static final int COUNT_BIAS = 10;
    }

}
