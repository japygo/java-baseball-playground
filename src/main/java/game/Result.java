package game;

public class Result {
    private int ball;
    private int strike;

    public Result() {
        this.ball = 0;
        this.strike = 0;
    }

    public Result(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public void addBall() {
        this.ball++;
    }

    public void addStrike() {
        this.strike++;
    }
}
