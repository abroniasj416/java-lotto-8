package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int readLottoMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int coin = Integer.parseInt(Console.readLine());
        // TODO : 예외처리) coin 값이 1,000원으로 나누어 떨어지는가?
        // 예를 들어 LottoMachine.validate(coin);
        return coin;
    }
}
