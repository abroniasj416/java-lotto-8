package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000; // 로또 1장의 가격
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    // TODO : 구입 금액만큼 로또 발행 수 계산
    private int money;
    private int lottoCount;

    public LottoMachine(int money) {
        validate(money);
        this.money = money;
        this.lottoCount = calculateLottoCount(this.money);
    }
    public static void validate(int money) {
        if (money % LOTTO_PRICE != 0)
            throw new IllegalArgumentException("[ERROR] 로또 1장의 가격은 1,000원입니다.");
    }

    private int calculateLottoCount(int money) {
        return money / LOTTO_PRICE;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    private Lotto generateSingleLotto() {
        // TODO: 구현
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_COUNT);
        return new Lotto(numbers);
    }

    public List<Lotto> generateLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(generateSingleLotto());
        }

        return lottos;
    }

    public int getMoney() {
        return money;
    }
}

