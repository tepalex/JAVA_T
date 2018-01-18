package ru.stqa.ptf.addressbook.tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;
import ru.stqa.ptf.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModifyTest extends TestBase{
  FirefoxDriver wd;

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0){
      app.contact().create(new ContactData()
              .withFirstname("Alex").withLastname("Teplov").withAddress("Address")
              .withHomephone("4951234567").withMobilePhone("2000000").withWorkPhone("3000000")
              .withEmail("email1@mail.com").withEmail2("email2@gmail.com").withEmail3("email3@gmail.com")
              .withGroup("test1"));
    }
  }

  @Test
  public void testModifyContact() {
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId())
            .withFirstname("Alex").withLastname("Teplov").withAddress("Address")
            .withHomephone("+33123456789").withMobilePhone("2000000").withWorkPhone("3000000")
            .withEmail("email1@mail.com").withEmail2("email2@gmail.com").withEmail3("email3@gmail.com")
            .withGroup("test1");
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }


}
