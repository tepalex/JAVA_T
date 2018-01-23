package ru.stqa.ptf.addressbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@javax.persistence.Table(name = "address_in_groups")
public class ContactsInGroupsData {

  @Id
  @Column(name = "id")
  private int Id;

  @Column(name = "group_id")
  private int groupId;

}