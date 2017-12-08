package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.ptf.addressbook.Module.ContactData;
import ru.stqa.ptf.addressbook.Module.GroupData;


public class ContactHelper extends BaseHelper {

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void fillContactData(ContactData contactData) {
     type(By.name("firstname"), contactData.getFirstname());
     type(By.name("lastname"), contactData.getLastname());
     type(By.name("home"), contactData.getHomephone());
     type(By.name("email"), contactData.getEmail());
  }

  public void submitContactCreation() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

}