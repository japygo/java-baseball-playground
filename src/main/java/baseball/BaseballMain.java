package baseball;

import baseball.domain.Baseball;
import baseball.domain.BaseballNumbers;
import baseball.domain.BaseballResult;
import baseball.view.InputView;
import baseball.view.ResultView;

public class BaseballMain {
    public static void main(String[] args) {
        Baseball baseball = new Baseball();
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        BaseballResult result = new BaseballResult();

        BaseballNumbers question = baseball.generateBaseballNumbers();

        while (!result.isEnd()) {
            BaseballNumbers answer = inputView.input();
            result = question.compare(answer);
            resultView.view(result);
        }
    }
}
