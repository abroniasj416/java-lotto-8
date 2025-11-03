package lotto;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private LottoMachine lottoMachine;

    public void start() {
        int money = readMoneyWithRetry();
        // "구입금액을 입력해주세요."
        lottoMachine = new LottoMachine(money);

        // "n개를 구매하였습니다."
        outputView.printPurchaseCount(lottoMachine.getLottoCount());
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
}
