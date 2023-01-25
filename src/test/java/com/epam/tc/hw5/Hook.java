package com.epam.tc.hw5;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook  {

    @Before
    public void setupDriver() {
        DriverSetup.setup();
    }

    @After
    public void teardownDriver() {
        DriverSetup.teardown();
    }
}
