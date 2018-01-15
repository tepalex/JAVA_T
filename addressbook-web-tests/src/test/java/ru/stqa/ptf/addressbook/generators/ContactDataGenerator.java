package ru.stqa.ptf.addressbook.generators;

import ru.stqa.ptf.addressbook.Module.ContactData;
import ru.stqa.ptf.addressbook.Module.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  public static void main (String[] args) throws IOException {
      int count = Integer.parseInt(args[0]);
      File file = new File(args[1]);

      List<ContactData> contacts = generateContacts (count);
      save(contacts, file);
    }

  private static void save(List<ContactData> contacts, File file) throws IOException {
    Writer writer = new FileWriter(file);
    System.out.println(new File(".").getAbsolutePath());
    for (ContactData contact : contacts){
      writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n", contact.getFirstName(),contact.getLastName(),
              contact.getAddress(),contact.getHomePhone(),contact.getMobilePhone(),contact.getWorkPhone(),
              contact.getEmail(),contact.getEmail2(),contact.getEmail3(),contact.getGroup()));
    }
    writer.close();
  }

  private static List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData()
              .withFirstname(String.format("firstname %s.", i))
              .withLastname(String.format("lastanme %s.", i))
              .withAddress(String.format("address %s.", i))
              .withHomephone(String.format("homePhone %s", i))
              .withMobilePhone(String.format("mobilePhone %s", i))
              .withWorkPhone(String.format("workPhone %s", i))
              .withEmail(String.format("email %s", i))
              .withEmail2(String.format("email2 %s", i))
              .withEmail3(String.format("email3 %s", i))
              .withGroup(String.format("group %s", i)));
    }
    return contacts;
  }
}
