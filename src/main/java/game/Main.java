package game;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        NumberBaseballNumber numberBaseballNumber = new NumberBaseballNumber();
        Integer[] question = numberBaseballNumber.getNumbers();

        NumberBaseball numberBaseball = new NumberBaseball();
        numberBaseball.start(question);

        boolean isCorrect = false;
        while (!isCorrect) {
            int answer = inputView.enterAnswer();
            Result result = numberBaseball.checkAnswer(answer);
            resultView.result(result);
            isCorrect = result.getStrike() == 3;
        }
    }
}
