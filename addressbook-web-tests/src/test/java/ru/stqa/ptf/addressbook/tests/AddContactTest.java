package ru.stqa.ptf.addressbook.tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.Module.ContactData;

import java.util.List;

public class AddContactTest extends TestBase {
  FirefoxDriver wd;

  @Test

  public void testAddContact() {
    app.getNavigationHelper().goToHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContact();
    app.getContactHelper().fillContactData(new ContactData("Alex1", "Teplov", "+74951234567", "teplovs@mail.com", "test1"), true);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    System.out.println(after);
    Assert.assertEquals(after.size(), before.size() + 1);



  }
}
