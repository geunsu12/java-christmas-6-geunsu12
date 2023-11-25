package christmas.model;

import static christmas.constants.Constants.BADGE;

public class Badge {

    private String badge;

    private Badge(int discount) {
        if (discount >= BADGE.FIRST_THRESHOLD) { this.badge = BADGE.FIRST_BADGE; }
        if (discount >= BADGE.SECOND_THRESHOLD && discount < BADGE.FIRST_THRESHOLD) { this.badge = BADGE.SECOND_BADGE; }
        if (discount >= BADGE.THIRD_THRESHOLD && discount < BADGE.SECOND_THRESHOLD) { this.badge =  BADGE.THIRD_BADGE; }
        if (discount < BADGE.THIRD_THRESHOLD) { this.badge = BADGE.NON_BADGE; }
    }

    public static Badge createBadgeFrom(int discount) {
        return new Badge(discount);
    }

    public String getBadge() { return badge; }

}
