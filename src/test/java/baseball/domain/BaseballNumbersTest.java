package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumbersTest {
    private BaseballNumbers baseballNumbers;

    @BeforeEach
    void setUp() {
        List<BaseballNumber> numberList = new ArrayList<>();
        numberList.add(new BaseballNumber(1));
        numberList.add(new BaseballNumber(2));
        numberList.add(new BaseballNumber(3));

        baseballNumbers = new BaseballNumbers(numberList);
    }

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

    @DisplayName("같은 자리에 같은 수가 있으면 스트라이크이다")
    @Test
    void strike() {
        assertThat(baseballNumbers.compare(0, new BaseballNumber(1))).isEqualTo(BaseballStatus.STRIKE);
    }

    @DisplayName("다른 자리에 같은 수가 있으면 볼이다")
    @Test
    void ball() {
        assertThat(baseballNumbers.compare(1, new BaseballNumber(1))).isEqualTo(BaseballStatus.BALL);
    }

    @DisplayName("같은 수가 없으면 낫싱이다")
    @Test
    void nothing() {
        assertThat(baseballNumbers.compare(1, new BaseballNumber(4))).isEqualTo(BaseballStatus.NOTHING);
    }

    @ParameterizedTest
    @MethodSource("provideForCompareStatus")
    void compare_status(int index, int number, BaseballStatus status) {
        assertThat(baseballNumbers.compare(index, new BaseballNumber(number))).isEqualTo(status);
    }

    private static Stream<Arguments> provideForCompareStatus() {
        return Stream.of(
                Arguments.of(0, 1, BaseballStatus.STRIKE),
                Arguments.of(1, 1, BaseballStatus.BALL),
                Arguments.of(0, 4, BaseballStatus.NOTHING)
        );
    }

    @ParameterizedTest
    @CsvSource({"1,2,3,3,0", "4,1,2,0,2", "1,3,2,1,2"})
    void compare(int number1, int number2, int number3, int strike, int ball) {
        List<BaseballNumber> numberList = new ArrayList<>();
        numberList.add(new BaseballNumber(number1));
        numberList.add(new BaseballNumber(number2));
        numberList.add(new BaseballNumber(number3));

        BaseballResult actual = baseballNumbers.compare(numberList);

        assertThat(actual.getStrike()).isEqualTo(strike);
        assertThat(actual.getBall()).isEqualTo(ball);
    }
}
