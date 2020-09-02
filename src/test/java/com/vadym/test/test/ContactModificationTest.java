package com.vadym.test.test;

import com.vadym.test.model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {
    @Test(enabled = false)
    public void testGroupModification() {

        app.goTo().goToHomePage();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("test_name", "test_surname", null), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();


    }
}
