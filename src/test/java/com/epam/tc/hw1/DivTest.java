package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivTest  extends AbstractTest {

    @Test
    public void divTest() {
        double res = calculator.div(4, 2);
        assertThat(res).isEqualTo(2);
    }

    @DataProvider
    public static  Object[][] divCorrectData() {
        return new Object[][] {
                {21.0, 3.0, 7.0},
                {81.0, 9.0, 9.0}
        };
    }

    @Test(dataProvider = "divCorrectData")
    public void divDDtTest(double a, double b, double res) {
        var act = calculator.div(a, b);
        assertThat(act).isEqualTo(res);
    }
}
