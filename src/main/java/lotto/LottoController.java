package lotto;

public class LottoController {
    private final InputView inputView = new InputView();
    private LottoMachine lottoMachine;

    public void start() {
        int money = readMoneyWithRetry();
        lottoMachine = new LottoMachine(money);

        System.out.println(lottoMachine.getLottoCount() + "개를 구매했습니다.");
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
