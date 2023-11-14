package christmas.domain;

import static christmas.constants.Constants.BADGE.*;

public class Badge {

    private String badge;

    private Badge(int discount) {
        if (discount >= FIRST_THRESHOLD) { this.badge = FIRST_BADGE; }
        if (discount >= SECOND_THRESHOLD && discount < FIRST_THRESHOLD) { this.badge = SECOND_BADGE; }
        if (discount >= THIRD_THRESHOLD && discount < SECOND_THRESHOLD) { this.badge =  THIRD_BADGE; }
        if (discount < THIRD_THRESHOLD) { this.badge = "없음"; }
    }

    public static Badge createBadgeFrom(int discount) {
        return new Badge(discount);
    }

    public String getBadge() { return badge; }

}
