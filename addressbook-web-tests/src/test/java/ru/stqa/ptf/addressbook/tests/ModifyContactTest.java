package ru.stqa.ptf.addressbook.tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.Module.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ModifyContactTest extends TestBase{
  FirefoxDriver wd;

  @Test

  public void testModifyContact() {
    app.getNavigationHelper().goToHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Ivan", "Petrov", "+75001234567", "petrovs@gmail.com", "test1"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initModifyContact(before.size() - 1);
    ContactData contact = new ContactData(before.get(before.size()-1).getId(), "Alex", "Teplov", "+700000000", "teplovs@mail.com", "test1");
    app.getContactHelper().fillContactData(contact, false);
    app.getContactHelper().submitContactUpdate();
    app.getContactHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size()-1);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
