package lotto;

import java.util.List;

public class LottoJudge {
    public static Rank judge(Lotto lotto, WinningBonusNumbers winningBonusNumbers) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningBonusNumbers.getWinningNumbers();

        int matchCount = 0;
        for (int lottoNumber : lottoNumbers) {
            for (int winningNumber : winningNumbers) {
                if (lottoNumber == winningNumber)
                    matchCount++;
            }
        }

        boolean bonusMatch = false;
        if (matchCount == 5) {
            for (int lottoNumber : lottoNumbers) {
                if (lottoNumber == winningBonusNumbers.getBonusNumber())
                    bonusMatch = true;
            }
        }

        return Rank.from(matchCount, bonusMatch);
    }
}
