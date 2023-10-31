package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumberTest {

    @DisplayName("1 ~ 9 사이의 수이다")
    @Test
    void number_range() {
        int expected = 1;
        BaseballNumber baseballNumber = new BaseballNumber(expected);
        int actual = baseballNumber.getNumber();
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("1 ~ 9 사이의 수가 아니면 에러가 발생한다")
    @Test
    void number_range_error() {
        int number = 11;
        assertThatThrownBy(() -> {
            BaseballNumber baseballNumber = new BaseballNumber(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
