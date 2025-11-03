package lotto;

import java.util.List;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private LottoMachine lottoMachine;

    public void start() {
        // "구입금액을 입력해주세요."
        int money = readMoneyWithRetry();
        lottoMachine = new LottoMachine(money);

        // "n개를 구매하였습니다."
        outputView.printPurchaseCount(lottoMachine.getLottoCount());
        outputView.printLottos(lottoMachine.generateLottos());

        // "당첨 번호를 입력해 주세요."
        List<Integer> winningNumbers = readWinningNumbersWithRetry();

        // "보너스 번호를 입력해 주세요."
        int bonusNumber = readBonusNumberWithRetry();
    }

    private int readMoneyWithRetry() {
        while (true) {
            try {
                return inputView.readLottoMoney();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // [ERROR]로 시작하는 메시지 출력
            }
        }
    }

    private List<Integer> readWinningNumbersWithRetry() {
        while (true) {
            try {
                return inputView.readWinningNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // [ERROR]로 시작하는 메시지 출력
            }
        }
    }

    private int readBonusNumberWithRetry() {
        while (true) {
            try {
                return inputView.readBonusNumber();
            }
            catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
