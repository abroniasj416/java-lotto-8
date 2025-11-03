package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningBonusNumbers {
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
    }

    private void validateBonusNumber(int bonus, List<Integer> numbers) {
        // TODO : 구현
    }

    private void sortByAsc(List<Integer> numbers) {
        // TODO : 오름차순 정렬 구현
    }

    public List<Integer> getWinningNumbers() {
        // TODO : 구현
    }

    public int getBonusNumber() {
        // TODO : 구현
    }
}
