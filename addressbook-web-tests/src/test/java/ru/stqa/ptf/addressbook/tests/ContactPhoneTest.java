package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;
import ru.stqa.ptf.addressbook.model.Groups;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0){
      Groups groups = app.db().groups();
      app.goTo().homePage();
      app.contact().create(new ContactData()
              .withFirstname("Alex").withLastname("Teplov").withAddress("Address")
              .withHomephone("4951234567").withMobilePhone("2000000").withWorkPhone("3000000")
              .withEmail("email1@mail.com").withEmail2("email2@gmail.com").withEmail3("email3@gmail.com")
              .inGroup(groups.iterator().next()));
    }
  }
  @Test
  public void testContactPhones(){
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFormEditForm = app.contact().infoFormEditForm(contact);
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFormEditForm)));
    }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(),contact.getMobilePhone(),contact.getWorkPhone())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactPhoneTest::cleaned)
            .collect(Collectors.joining("\n"));

  }

  public static String cleaned (String phone){
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }

}
