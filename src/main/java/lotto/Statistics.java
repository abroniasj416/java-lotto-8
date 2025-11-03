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

    public HashMap<Rank, Integer> calculateRankCount(List<Lotto> lottos, WinningBonusNumbers winningBonusNumbers) {
        for (Lotto lotto : lottos) {
            Rank rank = LottoJudge.judge(lotto, winningBonusNumbers);
            rankCount.put(rank, rankCount.get(rank) + 1);
        }

        return rankCount;
    }

    // 매개변수 totalPurchaseAmount에는 lottoMachine.getMoney()를 대입할 예정
    public double calculateProfitRate(HashMap<Rank, Integer> rankCount, int totalPurchaseAmount) {
        long profit = Rank.FIRST.getPrize() * rankCount.get(Rank.FIRST)
                + Rank.SECOND.getPrize() * rankCount.get(Rank.SECOND)
                + Rank.THIRD.getPrize() * rankCount.get(Rank.THIRD)
                + Rank.FOURTH.getPrize() * rankCount.get(Rank.FOURTH)
                + Rank.FIFTH.getPrize() * rankCount.get(Rank.FIFTH);

        return (double) profit / totalPurchaseAmount * 100;
    }
}
