package game;

public class Main {
    public static final InputView inputView = new InputView();
    public static final ResultView resultView = new ResultView();

    public static void main(String[] args) {

        boolean isExit = false;
        while (!isExit) {
            playGame();

            isExit = inputView.exitGame();
        }
    }

    public static void playGame() {
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

        resultView.correctAnswer();
    }
}
