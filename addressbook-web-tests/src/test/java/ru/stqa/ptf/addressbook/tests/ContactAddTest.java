package ru.stqa.ptf.addressbook.tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.Module.ContactData;
import ru.stqa.ptf.addressbook.Module.Contacts;
import ru.stqa.ptf.addressbook.Module.GroupData;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddTest extends TestBase {
  FirefoxDriver wd;

  @DataProvider
  public Iterator<Object[]> validContacts(){
    List<Object[]> list = new ArrayList<Object[]>();
    File photo = new File("src/test/resources/cat.png");
    list.add(new Object[]{new ContactData()
            .withFirstname("Alex").withLastname("Ivanov").withAddress("Address")
            .withHomephone("4951234567").withMobilePhone("2000000").withWorkPhone("3000000")
            .withEmail("email1@mail.com").withEmail2("email2@gmail.com").withEmail3("email3@gmail.com")
            .withGroup("test1").withPhoto(photo)});
    list.add(new Object[]{new ContactData()
            .withFirstname("Alex1").withLastname("Ivanov1").withAddress("Address1")
            .withHomephone("49512345671").withMobilePhone("20000001").withWorkPhone("30000001")
            .withEmail("email1@mail.com").withEmail2("email2@gmail.com").withEmail3("email3@gmail.com")
            .withGroup("test1").withPhoto(photo)});
    list.add(new Object[]{new ContactData()
            .withFirstname("Alex2").withLastname("Ivanov2").withAddress("Address2")
            .withHomephone("49512345672").withMobilePhone("20000002").withWorkPhone("30000002")
            .withEmail("email1@mail.com").withEmail2("email2@gmail.com").withEmail3("email3@gmail.com")
            .withGroup("test1").withPhoto(photo)});
    return list.iterator();
  }


  @Test(dataProvider = "validContacts")

  public void testAddContact(ContactData contact) {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    app.contact().initContact();
    app.contact().fillContactData(contact, true);
    app.contact().submitContactCreation();
    app.contact().returnToHomePage();
    assertThat(app.contact().count(), equalTo(before.size()+1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) ->c.getId()).max().getAsInt()))));

  }

}

