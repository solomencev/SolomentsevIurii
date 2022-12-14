package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultTest extends AbstractTest {

    @DataProvider
    public static Object[][] multCorrectData() {
        return new Object[][] {
                {5.0, 2.0, 10.0},
                {-6.0, 0.0, 0.0},
                {0.1, 9, 0.9},
                {-1000.0, 0.1, -100.0}
        };
    }

    @Test(dataProvider = "multCorrectData")
    public void sumDDtTest(double a, double b, double res) {
        var act = calculator.mult(a, b);
        assertThat(act).isEqualTo(res);
    }
}
