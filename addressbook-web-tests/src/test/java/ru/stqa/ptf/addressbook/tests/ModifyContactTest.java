package ru.stqa.ptf.addressbook.tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.Module.ContactData;

public class ModifyContactTest extends TestBase{
  FirefoxDriver wd;

  @Test

  public void testAddContact() {

    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().initModifyContact();
    app.getContactHelper().fillContactData(new ContactData("Alex", "Teplov", "+74951234567", "teplovs@mail.com", null), false);
    app.getContactHelper().submitContactUpdate();
    app.getNavigationHelper().returnToHomePage();

  }
}
