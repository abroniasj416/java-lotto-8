package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoJudge {
    private static final int SECOND_PLACE_MATCH_COUNT = 5;

    public static Rank judge(Lotto lotto, WinningBonusNumbers winningBonusNumbers) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        Set<Integer> winningSet = new HashSet<>(winningBonusNumbers.getWinningNumbers());

        int matchCount = (int) lottoNumbers.stream()
                .filter(winningSet::contains)
                .count();

        boolean bonusMatch = matchCount == SECOND_PLACE_MATCH_COUNT
                && lottoNumbers.contains(winningBonusNumbers.getBonusNumber());

        return Rank.from(matchCount, bonusMatch);
    }
}
