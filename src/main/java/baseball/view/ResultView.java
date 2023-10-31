package baseball.view;

import baseball.domain.BaseballResult;
import baseball.domain.BaseballStatus;

public class ResultView {

    public void view(BaseballResult baseballResult) {
        System.out.println(result(baseballResult));
    }

    private String result(BaseballResult baseballResult) {
        String result = "";
        int strike = baseballResult.getStrike();
        int ball = baseballResult.getBall();

        if (strike == 0 && ball == 0) {
            return BaseballStatus.NOTHING.getLabel();
        }

        if (ball > 0) {
            result += ball + BaseballStatus.BALL.getLabel();
        }

        if (ball != 0) {
            result += " ";
        }

        if (strike > 0) {
            result += strike + BaseballStatus.STRIKE.getLabel();
        }

        return result;
    }

    public void end() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}