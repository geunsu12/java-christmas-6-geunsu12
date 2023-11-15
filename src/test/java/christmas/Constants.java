package christmas;

public class Constants {

    private Constants() {};

    public static final int D_DAY_INDEX = 0;
    public static final int WEEKDAY_INDEX = 1;
    public static final int WEEKEND_INDEX = 2;
    public static final int SPECIAL_INDEX = 3;
    public static final int GIFT_INDEX = 4;

    public static class VALID_TEST {
        public static final int D_DAY_DISCOUNT = 2400;
        public static final int WEEKDAY_DISCOUNT = 0;
        public static final int WEEKEND_DISCOUNT = 2023;
        public static final int SPECIAL_DISCOUNT = 0;
        public static final int GIFT_DISCOUNT = 0;

    }

    public static class FIRST_EXAMPLE {
        public static final int D_DAY_DISCOUNT = 0;
        public static final int WEEKDAY_DISCOUNT = 0;
        public static final int WEEKEND_DISCOUNT = 0;
        public static final int SPECIAL_DISCOUNT = 0;
        public static final int GIFT_DISCOUNT = 0;

    }

    public static class SECOND_EXAMPLE {
        public static final int D_DAY_DISCOUNT = 1200;
        public static final int WEEKDAY_DISCOUNT = 4046;
        public static final int WEEKEND_DISCOUNT = 0;
        public static final int SPECIAL_DISCOUNT = 1000;
        public static final int GIFT_DISCOUNT = 25000;

    }
}
