package ru.stqa.ptf.addressbook.tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.Module.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactAddTest extends TestBase {
  FirefoxDriver wd;

  @Test

  public void testAddContact() {
    app.goTo().homePage();
    Set<ContactData> before = app.contact().all();
    app.contact().initContact();
    ContactData contact = new ContactData()
            .withFirstname("Alex").withLastname("Teplov").withHomephone("+74951234567").withEmail("teplovs@mail.com").withGroup("test1");
    app.contact().fillContactData(contact, true);
    app.contact().submitContactCreation();
    app.contact().returnToHomePage();
    Set<ContactData> after = app.contact().all();
    System.out.println(after);
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((c) ->c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}
