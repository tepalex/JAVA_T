package ru.stqa.ptf.addressbook.tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DeleteContactTest extends TestBase {
  FirefoxDriver wd;

  @Test

  public void deleteContactTest() {
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().submitContactDeletion();
  }
}
