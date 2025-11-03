package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RankTest {

    @Test
    @DisplayName("일치 개수/보너스 여부에 따른 등수 매핑")
    void rank_mapping() {
        assertThat(Rank.from(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.from(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.from(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.from(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.from(3, false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.from(2, true)).isEqualTo(Rank.NONE);
        assertThat(Rank.from(0, false)).isEqualTo(Rank.NONE);
    }

    @Test
    @DisplayName("등수별 상금 상수 검증")
    void prize_constants() {
        assertThat(Rank.FIRST.getPrize()).isGreaterThan(Rank.SECOND.getPrize());
        assertThat(Rank.SECOND.getPrize()).isGreaterThan(Rank.THIRD.getPrize());
        assertThat(Rank.FIFTH.getPrize()).isPositive();
        assertThat(Rank.NONE.getPrize()).isZero();
    }
}
