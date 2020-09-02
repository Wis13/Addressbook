package com.vadym.test.test;

import com.vadym.test.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {
    @Test(enabled = false)
    public void groupCreationTest() {

        app.goTo().groupPage();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("test_name", "test_surname", "test1"), true);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();
    }
}
