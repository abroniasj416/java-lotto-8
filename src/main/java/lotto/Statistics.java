package lotto;

import java.util.HashMap;
import java.util.List;

public class Statistics {
    private int lottoCount;
    private HashMap<Rank, Integer> rankCount;

    public Statistics() {
        rankCount = new HashMap<>();
        rankCount.put(Rank.FIRST, 0);
        rankCount.put(Rank.SECOND, 0);
        rankCount.put(Rank.THIRD, 0);
        rankCount.put(Rank.FOURTH, 0);
        rankCount.put(Rank.FIFTH, 0);
        rankCount.put(Rank.NONE, 0);
    }

    public HashMap<Rank, Integer> calculate(List<Lotto> lottos, WinningBonusNumbers winningBonusNumbers) {
        for (Lotto lotto : lottos) {
            Rank rank = LottoJudge.judge(lotto, winningBonusNumbers);
            rankCount.put(rank, rankCount.get(rank) + 1);
        }

        return rankCount;
    }
}
