package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoAdditionalTest {

    @Test
    @DisplayName("생성 시 오름차순 정렬 보장")
    void sorted_on_construct() {
        Lotto lotto = new Lotto(List.of(9, 2, 3, 1, 6, 5));
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 5, 6, 9);
    }

    @Test
    @DisplayName("getNumbers는 방어적 복사본을 반환(외부 변경이 내부에 영향 없음)")
    void defensive_copy() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> copy = lotto.getNumbers();
        copy.set(0, 45); // 외부 리스트만 변경

        assertThat(copy.get(0)).isEqualTo(45);
        assertThat(lotto.getNumbers().get(0)).isEqualTo(1); // 내부 상태는 그대로
    }
}
