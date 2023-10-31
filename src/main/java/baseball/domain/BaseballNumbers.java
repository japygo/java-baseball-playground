package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumbers {
    private static final int SIZE = 3;

    private final List<BaseballNumber> numbers;

    public BaseballNumbers(List<BaseballNumber> numbers) {
        validSize(numbers);
        validDuplication(numbers);
        this.numbers = numbers;
    }

    private void validDuplication(List<BaseballNumber> numbers) {
        Set<BaseballNumber> set = new HashSet<>(numbers);
        if (numbers.size() != set.size()) {
            throw new IllegalArgumentException("중복된 수가 있습니다");
        }
    }

    private void validSize(List<BaseballNumber> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException("3자리 수가 아닙니다");
        }
    }

    public List<BaseballNumber> getNumbers() {
        return this.numbers;
    }

    public BaseballResult compare(List<BaseballNumber> numberList) {
        BaseballResult baseballResult = new BaseballResult();
        for (int index = 0; index < SIZE; index++) {
            baseballResult.setResult(compare(index, numberList.get(index)));
        }
        return baseballResult;
    }

    public BaseballStatus compare(int index, BaseballNumber baseballNumber) {
        if (!this.numbers.contains(baseballNumber)) {
            return BaseballStatus.NOTHING;
        }
        if (isSame(index, baseballNumber.getNumber())) {
            return BaseballStatus.STRIKE;
        }
        return BaseballStatus.BALL;
    }

    private boolean isSame(int index, int number) {
        return this.numbers.get(index).getNumber() == number;
    }
}
