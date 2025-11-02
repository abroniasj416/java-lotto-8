package lotto;

public class LottoMachine {
    public static void validate(int money) {
        if (money % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 로또 1장의 가격은 1,000원입니다.");
    }
}
