package ru.stqa.ptf.addressbook.tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.Module.ContactData;

public class DeleteContactTest extends TestBase {
  FirefoxDriver wd;

  @Test

  public void deleteContactTest() {
    app.getNavigationHelper().goToHomePage();
    int before = app.getContactHelper().getContactCount();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Ivan", "Petrov", "+75001234567", "petrovs@gmail.com", "test1"));
    }

    app.getContactHelper().selectContact(before - 1);
    app.getContactHelper().submitContactDeletion();
    app.getContactHelper().returnToHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before-1);
  }
}
