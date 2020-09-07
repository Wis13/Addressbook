package com.vadym.test.test;

import com.vadym.test.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class ContactCreationTest extends TestBase {

    @Test
    public void contactCreationTest() {
        app.goTo().HomePage();
        app.contact().initContactCreation();
        File photo = new File("./mord.png");
        app.contact().fillContactForm(new ContactData().withFirstname("Dura").withLastname("Polnaya").withPhoto(photo), true);
//        ContactData contact = new ContactData().withFirstname("test55").withLastname("best55").withPhoto(photo);
        app.contact().submitContactCreation();
        app.contact().returnToHomePage();
    }
}
