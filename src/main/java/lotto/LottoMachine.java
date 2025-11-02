package lotto;

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
}

