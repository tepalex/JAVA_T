package ru.stqa.ptf.addressbook.tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.Module.ContactData;

public class AddContactTest extends TestBase {
  FirefoxDriver wd;

  @Test

  public void testAddContact() {
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().initContact();
    app.getContactHelper().fillContactData(new ContactData("Alex", "Teplov", "+74951234567", "teplovs@mail.com", "Test1"), true);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().returnToHomePage();

  }
}
