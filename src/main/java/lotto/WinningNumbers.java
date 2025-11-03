package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class WinningNumbers {

    public static List<Integer> generateWinningNumbers() {
        StringTokenizer st = new StringTokenizer(Console.readLine(), ",");
        List<Integer> winningNumbers = new ArrayList<>();
        while (st.hasMoreTokens()) {
            winningNumbers.add(Integer.parseInt(st.nextToken()));
        }

        return winningNumbers;
    }

    public static int generateBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }

    private void validateWinningNumbers() {
        // TODO : 예외 처리 구현
        /*
        * 당첨 번호가 쉼표(,)로 올바르게 구분되어 있는가?
        * 당첨 번호가 1~45 범위 내이며 중복되지 않는가?
        * */
    }

    private void validateBonusNumber() {
        // TODO : 예외 처리 구현
        /*
         * 보너스 번호가 1~45 범위 내인가?
         * 보너스 번호가 당첨 번호와 중복되지 않는가?
         * */
    }
}
