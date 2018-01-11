package ru.stqa.ptf.addressbook.tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.Module.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModifyTest extends TestBase{
  FirefoxDriver wd;

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0){
      app.contact().create(new ContactData()
              .withFirstname("Ivan").withLastname("Petrov").withHomephone("+75001234567").withEmail("petrovs@gmail.com").withGroup("test1"));
    }
  }

  @Test
  public void testModifyContact() {
    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstname("Alex").withLastname("Teplov").withHomephone("+700000000").withEmail("teplovs@mail.com").withGroup("test1");
    app.contact().modify(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);
  }


}
