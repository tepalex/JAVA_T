package ru.stqa.ptf.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;
import ru.stqa.ptf.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    if(app.db().groups().size()==0){
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }
  }
  @Test
  public void testGroupDeletion() {
    Groups before = app.db().groups();
    GroupData deletedGroup = before.iterator().next();
    app.goTo().groupPage();
    app.group().delete(deletedGroup);
    assertThat(app.group().count(), equalTo(before.size()-1));
    Groups after = app.db().groups();
    assertThat(after, equalTo(before.without(deletedGroup)));
    }
}
