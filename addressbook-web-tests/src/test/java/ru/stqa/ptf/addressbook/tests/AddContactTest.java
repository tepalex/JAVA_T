package ru.stqa.ptf.addressbook.tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.Module.ContactData;

public class AddContactTest extends TestBase {
  FirefoxDriver wd;

  @Test

  public void testAddContact() {

    app.getNavigationHelper().goToAddNewPage();
    app.getContactHelper().fillContactData(new ContactData("Alex", "Teplov", "+74951234567", "teplovs@mail.com"));
    app.getContactHelper().submitContactCreation();

  }
}
