package com.epam.tc.hw5.steps;

import com.epam.tc.hw5.DriverSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {

    @Before
    public void setupDriver() {
        DriverSetup.setup();
    }

    @After
    public void teardownDriver() {
        DriverSetup.teardown();
    }
}
