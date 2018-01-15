package ru.stqa.ptf.addressbook.tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.Module.ContactData;
import ru.stqa.ptf.addressbook.Module.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddTest extends TestBase {
  FirefoxDriver wd;

  @Test

  public void testAddContact() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    app.contact().initContact();
    File photo = new File("src/test/resources/cat.png");
    ContactData contact = new ContactData()
            .withFirstname("Alex").withLastname("Teplov").withAddress("Address")
            .withHomephone("4951234567").withMobilePhone("2000000").withWorkPhone("3000000")
            .withEmail("email1@mail.com").withEmail2("email2@gmail.com").withEmail3("email3@gmail.com")
            .withGroup("test1")
            .withPhoto(photo);
    app.contact().fillContactData(contact, true);
    app.contact().submitContactCreation();
    app.contact().returnToHomePage();
    assertThat(app.contact().count(), equalTo(before.size()+1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) ->c.getId()).max().getAsInt()))));

  }
 
/*  public void testBadAddContact() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    app.contact().initContact();
    ContactData contact = new ContactData()
            .withFirstname("Alex").withLastname("Teplov").withHomephone("+74951234567").withEmail("teplovs@mail.com").withGroup("test1");
    app.contact().fillContactData(contact, true);
    app.contact().submitContactCreation();
    app.contact().returnToHomePage();
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));

  }*/
}

