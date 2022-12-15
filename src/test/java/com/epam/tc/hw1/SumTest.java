package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumTest extends AbstractTest {

    @DataProvider
    public static  Object[][] sumCorrectData() {
        return new Object[][] {
                {1.0, 2.0, 3.0},
                {-1.0, 0.0, -1.0},
                {-0.0, 0.0, 0.0},
                {0.0, 0.0, 0.0},
                {1.0, -1.0, 0.0}
        };
    }

    @Test(dataProvider = "sumCorrectData")
    public void sumDDtTest(double a, double b, double res) {
        var act = calculator.sum(a, b);
        assertThat(act).isEqualTo(res);
    }
}
