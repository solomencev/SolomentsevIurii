package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultTest extends AbstractTest {

    @Test
    public void multTest() {
        double res = calculator.mult(3, 2);
        assertThat(res).isEqualTo(6);
    }

    @DataProvider
    public static  Object[][] multCorrectData() {
        return new Object[][] {
                {5.0, 2.0, 10.0},
                {-6.0, 0.0, 0.0}
        };
    }

    @Test(dataProvider = "multCorrectData")
    public void sumDDtTest(double a, double b, double res) {
        var act = calculator.mult(a, b);
        assertThat(act).isEqualTo(res);
    }
}
