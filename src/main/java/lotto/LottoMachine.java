package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    // TODO : 구입 금액만큼 로또 발행 수 계산
    private int money;
    private int lottoCount;

    public LottoMachine(int money) {
        validate(money);
        this.money = money;
        this.lottoCount = calculateLottoCount(this.money);
    }
    public static void validate(int money) {
        if (money % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 로또 1장의 가격은 1,000원입니다.");
    }

    private int calculateLottoCount(int money) {
        return money / 1000;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    private Lotto generateSingleLotto() {
        // TODO: 구현
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public void generateLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(generateSingleLotto());
        }

        return lottos;
    }
}

