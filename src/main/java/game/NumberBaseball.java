package game;

import java.util.Arrays;

public class NumberBaseball {
    private Integer[] question;

    public void start(Integer[] question) {
        this.question = question;
    }

    public Result checkAnswer(int answer) {
        Result result = new Result();
        int[] numbers = Arrays.stream(String.valueOf(answer).split("")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < 3; i++) {
            checkAnswer(i, numbers, result);
        }

        return result;
    }

    private void checkAnswer(int i, int[] numbers, Result result) {
        if (question[i] == numbers[i]) {
            result.addStrike();
            return;
        }

        if (Arrays.asList(question).contains(numbers[i])) {
            result.addBall();
        }
    }
}
