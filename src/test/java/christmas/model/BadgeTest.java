package christmas.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static christmas.constants.Constants.BADGE.*;
import static org.assertj.core.api.Assertions.assertThat;

public class BadgeTest {

    @DisplayName("할인 내역이 20000원 이상이면 배지 타입이 산타")
    @Test
    void createBadgeOverFirstThreshold() {
        Badge badgeOverFirst = Badge.createBadgeFrom(FIRST_THRESHOLD);
        assertThat(badgeOverFirst.getBadge()).isEqualTo(FIRST_BADGE);
    }

    @DisplayName("할인 내역이 10000원 이상이면 배지 타입이 트리")
    @Test
    void createBadgeOverSecondThreshold() {
        Badge badgeOverFirst = Badge.createBadgeFrom(SECOND_THRESHOLD);
        assertThat(badgeOverFirst.getBadge()).isEqualTo(SECOND_BADGE);
    }

    @DisplayName("할인 내역이 5000원 이상이면 배지 타입이 별")
    @Test
    void createBadgeOverThirdThreshold() {
        Badge badgeOverFirst = Badge.createBadgeFrom(THIRD_THRESHOLD);
        assertThat(badgeOverFirst.getBadge()).isEqualTo(THIRD_BADGE);
    }

    @DisplayName("할인 내역이 5000원 미만이면 배지 타입이 없음")
    @Test
    void createBadgeUnderThirdThreshold() {
        Badge badgeOverFirst = Badge.createBadgeFrom(THIRD_THRESHOLD-1);
        assertThat(badgeOverFirst.getBadge()).isEqualTo(NON_BADGE);
    }

}
