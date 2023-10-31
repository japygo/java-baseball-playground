package baseball.domain;

public enum BaseballStatus {
    BALL("볼"), NOTHING("낫싱"), STRIKE("스트라이크");

    private final String label;

    BaseballStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isBall() {
        return this == BALL;
    }
}
