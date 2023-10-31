package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumbersTest {

    @DisplayName("서로 다른 임의의 3자리 수이다")
    @Test
    void numbers_size() {
        BaseballNumber number1 = new BaseballNumber(1);
        BaseballNumber number2 = new BaseballNumber(2);
        BaseballNumber number3 = new BaseballNumber(3);

        List<BaseballNumber> expected = new ArrayList<>();
        expected.add(number1);
        expected.add(number2);
        expected.add(number3);

        BaseballNumbers baseballNumbers = new BaseballNumbers(expected);
        List<BaseballNumber> actual = baseballNumbers.getNumbers();
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("4자리 수이면 에러가 발생한다")
    @Test
    void numbers_size_error() {
        BaseballNumber number1 = new BaseballNumber(1);
        BaseballNumber number2 = new BaseballNumber(2);
        BaseballNumber number3 = new BaseballNumber(3);
        BaseballNumber number4 = new BaseballNumber(4);

        List<BaseballNumber> expected = new ArrayList<>();
        expected.add(number1);
        expected.add(number2);
        expected.add(number3);
        expected.add(number4);

        assertThatThrownBy(() -> {
            BaseballNumbers baseballNumbers = new BaseballNumbers(expected);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("같은 수가 존재하면 에러가 발생한다")
    @Test
    void numbers_same_error() {
        BaseballNumber number1 = new BaseballNumber(1);
        BaseballNumber number2 = new BaseballNumber(2);
        BaseballNumber number3 = new BaseballNumber(2);

        List<BaseballNumber> expected = new ArrayList<>();
        expected.add(number1);
        expected.add(number2);
        expected.add(number3);

        assertThatThrownBy(() -> {
            BaseballNumbers baseballNumbers = new BaseballNumbers(expected);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
