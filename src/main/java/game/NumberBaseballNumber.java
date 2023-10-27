package game;

import java.util.Arrays;
import java.util.Random;

public class NumberBaseballNumber {
    private static final int NUMBER_SIZE = 3;
    private final Random random = new Random();
    private final Integer[] numbers = new Integer[3];

    public Integer[] getNumbers() {
        int count = 0;
        while (count < NUMBER_SIZE) {
            count = setNumber(getNumber(), count);
        }

        return numbers;
    }

    private int setNumber(int number, int count) {
        if (!Arrays.asList(numbers).contains(number)) {
            numbers[count++] = number;
        }

        return count;
    }

    private int getNumber() {
        return random.nextInt(9) + 1;
    }
}
