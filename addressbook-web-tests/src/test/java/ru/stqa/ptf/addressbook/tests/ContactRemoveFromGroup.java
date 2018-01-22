package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;
import ru.stqa.ptf.addressbook.model.Contacts;
import ru.stqa.ptf.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactRemoveFromGroup extends TestBase {


  @BeforeMethod
  public void ensurePreconditions() {
    if(app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().create(new ContactData()
              .withFirstname("Alex").withLastname("Teplov").withAddress("Address")
              .withHomephone("4951234567").withMobilePhone("2000000").withWorkPhone("3000000")
              .withEmail("email1@mail.com").withEmail2("email2@gmail.com").withEmail3("email3@gmail.com"));
    }else if (app.db().groups().size()==0){
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("group1").withHeader("group_header").withFooter("group_footer"));
    }
  }

  @Test

  public void testContactRemoveFromGroup() {
    Contacts before = app.db().contacts();
    ContactData removeGroup = before.iterator().next();
    app.contact().contactRemoveFromGroup(removeGroup);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before));
    verifyContactListInUI();
  }
}

