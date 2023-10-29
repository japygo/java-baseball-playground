package game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberBaseballTest {

    @DisplayName("임의의 3개의 숫자가 맞는지 확인한다")
    @Test
    void selectNumber() {
        // given
        Integer[] question = { 1, 2, 3 };

        NumberBaseball numberBaseball = new NumberBaseball();
        numberBaseball.start(question);

        // when
        int answer = 123;
        Result actual = numberBaseball.checkAnswer(answer);

        // then
        assertThat(actual.getStrike()).isEqualTo(3);
    }
}