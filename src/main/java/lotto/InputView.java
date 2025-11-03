package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
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
        StringTokenizer st;
        try {
            st = new StringTokenizer(Console.readLine(), ",");
        }
        catch(NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자와 쉼표 구분자(,)만 입력 가능합니다.");
        }
        List<Integer> numbers = new ArrayList<>();

        while (st.hasMoreTokens()) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }
        return numbers;
    }

    public int readBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

}
