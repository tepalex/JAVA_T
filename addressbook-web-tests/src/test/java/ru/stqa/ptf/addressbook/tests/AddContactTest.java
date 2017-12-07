package ru.stqa.ptf.addressbook.tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class AddContactTest extends TestBase {
  FirefoxDriver wd;

  @Test

  public void testAddContact() {

    app.getNavigationHelper().goToAddNewPage();
    app.getContactHelper().addContactTest();


  }
}
