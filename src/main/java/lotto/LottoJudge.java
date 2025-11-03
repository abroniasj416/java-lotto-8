package lotto;

import java.util.HashSet;
import java.util.List;

public class LottoJudge {
    public static Rank judge(Lotto lotto, WinningBonusNumbers winningBonusNumbers) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        Set<Integer> winningSet = new HashSet<>(winningBonusNumbers.getWinningNumbers());

        int matchCount = (int) lottoNumbers.stream()
                .filter(winningSet::contains)
                .count();

        boolean bonusMatch = matchCount == 5
                && lottoNumbers.contains(winningBonusNumbers.getBonusNumber());

        return Rank.from(matchCount, bonusMatch);
    }
}
