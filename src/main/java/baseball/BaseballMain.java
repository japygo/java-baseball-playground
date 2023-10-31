package baseball;

import baseball.domain.Baseball;
import baseball.domain.BaseballNumbers;
import baseball.domain.BaseballResult;
import baseball.view.InputView;
import baseball.view.ResultView;

public class BaseballMain {
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();
    private static final Baseball baseball = new Baseball();

    public static void main(String[] args) {
        do {
            start(baseball.generateBaseballNumbers());
        } while (isRestart());
    }

    public static void start(BaseballNumbers question) {
        BaseballResult result = new BaseballResult();
        while (!result.isEnd()) {
            BaseballNumbers answer = inputView.input();
            result = question.compare(answer);
            resultView.view(result);
        }
        resultView.end();
    }

    public static boolean isRestart() {
        return inputView.restart() == 1;
    }
}
