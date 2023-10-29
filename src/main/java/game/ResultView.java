package game;

public class ResultView {

    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";

    public void result(Result result) {
        String view = "";
        int ball = result.getBall();
        int strike = result.getStrike();

        if (ball == 0 && strike == 0) {
            view += NOTHING;
        }

        if (ball > 0) {
            view += ball + BALL;
        }

        if (!view.isEmpty()) {
            view += " ";
        }

        if (strike > 0) {
            view += strike + STRIKE;
        }

        System.out.println(view);
    }
}
