package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int readLottoMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        LottoMachine.validate(money);
        return money;
    }
}
