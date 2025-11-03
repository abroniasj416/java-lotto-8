package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinningBonusNumbersTest {

    @Test
    @DisplayName("당첨번호가 6개가 아니면 예외")
    void size_must_be_6() {
        assertThatThrownBy(() -> new WinningBonusNumbers(List.of(1, 2, 3, 4, 5), 7))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinningBonusNumbers(List.of(1, 2, 3, 4, 5, 6, 7), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨번호가 1~45 범위를 벗어나면 예외")
    void number_out_of_range() {
        assertThatThrownBy(() -> new WinningBonusNumbers(List.of(0, 2, 3, 4, 5, 6), 7))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinningBonusNumbers(List.of(1, 2, 3, 4, 5, 46), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨번호에 중복이 있으면 예외")
    void winning_has_duplicates() {
        assertThatThrownBy(() -> new WinningBonusNumbers(List.of(1, 1, 3, 4, 5, 6), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스가 1~45 범위를 벗어나면 예외")
    void bonus_out_of_range() {
        assertThatThrownBy(() -> new WinningBonusNumbers(List.of(1, 2, 3, 4, 5, 6), 0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinningBonusNumbers(List.of(1, 2, 3, 4, 5, 6), 46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스가 당첨번호와 중복이면 예외")
    void bonus_duplicate_with_winning() {
        assertThatThrownBy(() -> new WinningBonusNumbers(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨번호는 오름차순으로 보관됨")
    void winning_sorted() {
        WinningBonusNumbers w = new WinningBonusNumbers(List.of(9, 2, 3, 1, 6, 5), 7);
        assertThat(w.getWinningNumbers()).containsExactly(1, 2, 3, 5, 6, 9);
        assertThat(w.getBonusNumber()).isEqualTo(7);
    }
}

