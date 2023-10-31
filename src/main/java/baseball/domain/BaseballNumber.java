package baseball.domain;

public class BaseballNumber {
    private int number;

    public BaseballNumber(int number) {
        validNumber(number);
        this.number = number;
    }

    private void validNumber(int number) {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException("1 ~ 9 사이의 수가 아닙니다");
        }
    }

    public int getNumber() {
        return this.number;
    }
}
