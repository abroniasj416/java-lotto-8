package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.StringTokenizer;

public class InputView {

    public int readLottoMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        LottoMachine.validate(money);
        return money;
    }

    public List<Integer> readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return WinningNumbers.generateWinningNumbers();
    }

    public int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return WinningNumbers.generateBonusNumber();
    }

}
