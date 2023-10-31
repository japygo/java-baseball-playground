package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Baseball {
    private final Random random = new Random();

    public BaseballNumbers generateBaseballNumbers() {
        List<BaseballNumber> baseballNumbers = new ArrayList<>();
        while (baseballNumbers.size() < 3) {
            int number = generateRandomNumber();
            addBaseballNumber(baseballNumbers, new BaseballNumber(number));
        }
        return new BaseballNumbers(baseballNumbers);
    }

    private void addBaseballNumber(List<BaseballNumber> baseballNumbers, BaseballNumber baseballNumber) {
        if (!baseballNumbers.contains(baseballNumber)) {
            baseballNumbers.add(baseballNumber);
        }
    }

    private int generateRandomNumber() {
        return random.nextInt(9) + 1;
    }
}
