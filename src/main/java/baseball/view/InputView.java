package baseball.view;

import baseball.domain.BaseballNumber;
import baseball.domain.BaseballNumbers;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public BaseballNumbers input() {
        System.out.print("숫자를 입력해 주세요 : ");
        String answer = scanner.next();
        return new BaseballNumbers(
                Arrays.stream(answer.split(""))
                        .map(Integer::parseInt)
                        .map(BaseballNumber::new)
                        .collect(Collectors.toList())
        );
    }

    public int restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return scanner.nextInt();
    }
}
