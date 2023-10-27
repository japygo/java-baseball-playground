package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    StringCalculator stringCalculator;

    @BeforeEach
    public void setUp() {
        stringCalculator = new StringCalculator();
    }

    @AfterEach
    public void tearDown() {
        stringCalculator = null;
    }

    @Test
    void calculate() {
        String formula = "2 + 3 * 4 / 2";
        int actual = stringCalculator.calculateFormula(formula);
        assertThat(actual).isEqualTo(10);
    }
}
