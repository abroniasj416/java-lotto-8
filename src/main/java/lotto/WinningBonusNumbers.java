package lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WinningBonusNumbers {
    private static final int WINNING_NUMBER_COUNT = 6; // 당첨 번호 개수
    private static final int MIN_NUMBER = 1; // 최소 번호
    private static final int MAX_NUMBER = 45; // 최대 번호

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningBonusNumbers(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumbers(winningNumbers);
        validateBonusNumber(bonusNumber, winningNumbers);

        List<Integer> sorted = new ArrayList<>(winningNumbers);
        sortByAsc(sorted);
        this.winningNumbers = sorted;
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningNumbers(List<Integer> numbers) {
        // TODO : 구현
        // 당첨번호가 6개인가?
        if (numbers.size() != WINNING_NUMBER_COUNT)
            throw new IllegalArgumentException("[ERROR] 당첨번호는 6개여야 합니다.");

        // 당첨번호가 1~45 사이인가?
        for (int number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER)
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이의 숫자여야 합니다.");
        }
        // 당첨번호가 중복되지는 않는가?
        if (numbers.size() != numbers.stream().distinct().count())
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
    }

    private void validateBonusNumber(int bonus, List<Integer> numbers) {
        // TODO : 구현
        // 보너스 번호가 1~45 사이인가?
        if (bonus < MIN_NUMBER || bonus > MAX_NUMBER)
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이의 숫자여야 합니다.");
        // 보너스 번호가 당첨번호와 중복되지는 않는가?
        if (numbers.contains(bonus))
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    private void sortByAsc(List<Integer> numbers) {
        // TODO : 오름차순 정렬 구현
        numbers.sort(Comparator.naturalOrder());
    }

    public List<Integer> getWinningNumbers() {
        // TODO : 구현
        return winningNumbers;
    }

    public int getBonusNumber() {
        // TODO : 구현
        return bonusNumber;
    }
}
