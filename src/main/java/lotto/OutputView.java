package lotto;

import java.util.List;

public class OutputView {
    public void printPurchaseCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.print("[");

            // TODO : 조건식으로 Lotto의 numbers 리스트의 길이(size())가 와야 한다.
            // numbers가 private이라 현재까지는 접근 불가능. Lotto 내에 추가 메서드 필요
            int lastIdx = lotto.getNumbers().size() - 1;
            for (int idx = 0; idx < lastIdx; idx++) {
                System.out.print(lotto.getNumbers().get(idx) + ", ");
            }
            System.out.println(lotto.getNumbers().get(lastIdx) + "]");
            System.out.println();
        }
    }

}
