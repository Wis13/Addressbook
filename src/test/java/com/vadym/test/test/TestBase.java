package com.vadym.test.test;

import com.vadym.test.appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeTest
    public void setUp() throws InterruptedException {
        app.init();
    }

    @AfterTest
    public void tearDown() {
        app.stop();
    }

}
