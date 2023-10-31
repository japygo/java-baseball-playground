package baseball.domain;

public class BaseballResult {
    private int strike;
    private int ball;

    public BaseballResult() {
        this.strike = 0;
        this.ball = 0;
    }

    public void setResult(BaseballStatus baseballStatus) {
        if (baseballStatus.isStrike()) {
            addStrike();
        }
        if (baseballStatus.isBall()) {
            addBall();
        }
    }

    private void addStrike() {
        this.strike++;
    }

    private void addBall() {
        this.ball++;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isEnd() {
        return this.strike == 3;
    }
}
