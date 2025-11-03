package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class LottoMachineTest {

    @Test
    @DisplayName("구입 금액은 1000원 단위가 아니면 예외")
    void validate_money() {
        assertThatThrownBy(() -> new LottoMachine(1500))
                .isInstanceOf(IllegalArgumentException.class);
        // 정적 메서드에 대한 직접 검증도 가능
        assertThatThrownBy(() -> LottoMachine.validate(999))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입 금액에 따른 로또 장수 계산")
    void calculate_count() {
        LottoMachine m = new LottoMachine(8000);
        assertThat(m.getLottoCount()).isEqualTo(8);
        assertThat(m.getMoney()).isEqualTo(8000);
    }

    @Test
    @DisplayName("generateLottos는 장수만큼 생성하고 각각 6개, 1~45, 중복 없음")
    void generate_constraints() {
        LottoMachine m = new LottoMachine(3000);
        List<Lotto> lottos = m.generateLottos();

        assertThat(lottos).hasSize(3);

        for (Lotto l : lottos) {
            List<Integer> nums = l.getNumbers();
            assertThat(nums).hasSize(6);
            assertThat(nums).allMatch(n -> 1 <= n && n <= 45);
            assertThat(new HashSet<>(nums)).hasSize(6);
            assertThat(nums).isSorted(); // Lotto가 정렬을 보장하므로
        }
    }
}
