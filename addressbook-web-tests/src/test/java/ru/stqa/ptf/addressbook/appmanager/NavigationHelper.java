package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends BaseHelper {

  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }

  public void goToAddNewPage() {
    wd.findElement(By.linkText("add new")).click();
  }
}