package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoJudgeTest {

    @Test
    @DisplayName("6개 일치 → 1등")
    void first_prize() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningBonusNumbers win = new WinningBonusNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(LottoJudge.judge(lotto, win)).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("5개+보너스 일치 → 2등")
    void second_prize() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningBonusNumbers win = new WinningBonusNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(LottoJudge.judge(lotto, win)).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("5개만 일치 → 3등")
    void third_prize() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        WinningBonusNumbers win = new WinningBonusNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(LottoJudge.judge(lotto, win)).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("4개 일치 → 4등, 3개 일치 → 5등, 그 외 → NONE")
    void other_prizes() {
        WinningBonusNumbers win = new WinningBonusNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        assertThat(LottoJudge.judge(new Lotto(List.of(1, 2, 3, 4, 8, 9)), win)).isEqualTo(Rank.FOURTH);
        assertThat(LottoJudge.judge(new Lotto(List.of(1, 2, 3, 8, 9, 10)), win)).isEqualTo(Rank.FIFTH);
        assertThat(LottoJudge.judge(new Lotto(List.of(1, 2, 8, 9, 10, 11)), win)).isEqualTo(Rank.NONE);
    }
}
