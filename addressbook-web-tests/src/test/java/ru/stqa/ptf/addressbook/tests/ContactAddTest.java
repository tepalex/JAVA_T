package ru.stqa.ptf.addressbook.tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.Module.ContactData;
import ru.stqa.ptf.addressbook.Module.Contacts;
import ru.stqa.ptf.addressbook.Module.GroupData;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddTest extends TestBase {
  FirefoxDriver wd;

  @DataProvider
  public Iterator<Object[]> validContacts() throws IOException {
    List<Object[]> list = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
    String line = reader.readLine();
    while (line != null){
      String[] split = line.split(";");
      list.add(new Object[] {new ContactData()
              .withFirstname(split[0]).withLastname(split[1]).withAddress(split[2])
              .withHomephone(split[3]).withMobilePhone(split[4]).withWorkPhone(split[5])
              .withEmail(split[6]).withEmail2(split[7]).withEmail3(split[8])
              .withGroup(split[9])});
      line = reader.readLine();
    }
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

