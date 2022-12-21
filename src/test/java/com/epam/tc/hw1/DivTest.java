package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivTest extends AbstractTest {

    @DataProvider
    public static  Object[][] divCorrectData() {
        return new Object[][] {
                {21.0, 3.0, 7.0},
                {81.0, 9.0, 9.0},
                {-9223372036854775808.0, 1L, -9223372036854775808.0},
                {0.0, 1.0, 0.0},
                {-10.0, 10.0, -1.0},
                {-0.9, -0.25, 3.6}
        };
    }

    @Test(dataProvider = "divCorrectData")
    public void divDDtTest(double a, double b, double res) {
        var act = calculator.div(a, b);
        assertThat(act).isEqualTo(res);
    }
}
