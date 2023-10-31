package baseball.domain;

public enum BaseballStatus {
    BALL, NOTHING, STRIKE;

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isBall() {
        return this == BALL;
    }
}
