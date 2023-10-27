package game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberBaseballNumberTest {

    @DisplayName("1에서 9까지 서로 다른 임의의 수 3개를 생성한다")
    @Test
    void getNumber() {
        // given
        NumberBaseballNumber numberBaseballNumber = new NumberBaseballNumber();

        // when
        Integer[] actual = numberBaseballNumber.getNumbers();

        // then
        assertThat(actual).hasSize(3)
                .allMatch(integer -> integer > 0 && integer < 10);
    }
}