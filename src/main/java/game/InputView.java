package game;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int enterAnswer() {
        System.out.print("숫자를 입력해 주세요 : ");
        return scanner.nextInt();
    }

    public boolean exitGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int number = scanner.nextInt();
        if (number != 1 && number != 2) {
            exitGame();
        }
        return number == 2;
    }
}
