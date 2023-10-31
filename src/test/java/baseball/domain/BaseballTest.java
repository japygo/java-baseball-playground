package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballTest {

    @DisplayName("1 ~ 9 사이의 서로 다른 임의의 수 3개를 생성한다")
    @Test
    void generate_numbers() {
        Baseball baseball = new Baseball();
        BaseballNumbers baseballNumbers = baseball.generateBaseballNumbers();
        assertThat(baseballNumbers.getNumbers()).hasSize(3);
    }
}
