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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseballNumber number1 = (BaseballNumber) o;

        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return number;
    }
}
