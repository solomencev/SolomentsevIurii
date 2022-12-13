package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SubTest extends AbstractTest {

    @Test
    public void subTest() {
        double res = calculator.sub(7, 2);
        assertThat(res).isEqualTo(5);
    }


    @DataProvider
    public static  Object[][] subCorrectData() {
        return new Object[][] {
                {10.0, 7.0, 3.0},
                {8.0, 5.0, 3.0}
        };
    }

    @Test(dataProvider = "subCorrectData")
    public void subDDtTest(double a, double b, double res) {
        var act = calculator.sub(a, b);
        assertThat(act).isEqualTo(res);
    }
}
