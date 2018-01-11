package ru.stqa.ptf.addressbook.tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.Module.ContactData;

import java.util.List;
import java.util.Set;

public class ContactDeleteTest extends TestBase {
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
  public void deleteContactTest() {
    Set<ContactData> before = app.contact().all();
    ContactData deleteContact = before.iterator().next();
    app.contact().delete(deleteContact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deleteContact);
    Assert.assertEquals(before, after);

  }

}
