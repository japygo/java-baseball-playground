package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumbers {
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
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("3자리 수가 아닙니다");
        }
    }

    public List<BaseballNumber> getNumbers() {
        return this.numbers;
    }
}
