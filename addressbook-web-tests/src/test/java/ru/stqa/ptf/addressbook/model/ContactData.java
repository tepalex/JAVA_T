package ru.stqa.ptf.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

  @XStreamAlias("contact")
  @Entity
  @Table(name = "addressbook")
  public class ContactData {

  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;

  @Expose
  @Column(name = "firstname")
  private String firstname;

  @Expose
  @Column(name = "lastname")
  private String lastname;

  @Expose
  @Column(name = "address")
  @Type(type = "text")
  private String address;

  @Expose
  @Column(name = "home")
  @Type(type = "text")
  private String homePhone;

  @Expose
  @Column(name = "mobile")
  @Type(type = "text")
  private String mobilePhone;

  @Expose
  @Column(name = "work")
  @Type(type = "text")
  private String workPhone;

  @Transient
  private String allPhones;

  @Expose
  @Column(name = "email")
  @Type(type = "text")
  private String email;

  @Expose
  @Column(name = "email2")
  @Type(type = "text")
  private String email2;

  @Expose
  @Column(name = "email3")
  @Type(type = "text")
  private String email3;

  @Transient
  private String allEmails;
/*  @Expose
  @Transient
  private String group;*/

  /*  @Column(name = "photo")
    @Type(type = "text")
    private String photo;

    public File getPhoto() {
      return new File(photo);
    }

    public ContactData withPhoto(File photo) {
      this.photo = photo.getPath();
      return this;
    }*/
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "address_in_groups",
          joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
  private Set<GroupData> groups = new HashSet<GroupData>();

  public String getAllEmails() {
    return allEmails;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public int getId() {
    return id;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withHomephone(String homephone) {
    this.homePhone = homephone;
    return this;
  }

  public ContactData withMobilePhone(String mobilephone) {
    this.mobilePhone = mobilephone;
    return this;
  }

  public ContactData withWorkPhone(String workphone) {
    this.workPhone = workphone;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData inGroup(GroupData group){
    groups.add(group);
    return this;
  }

  public String getFirstName() {
    return firstname;
  }

  public String getLastName() {
    return lastname;
  }

  public String getAddress() {
    return address;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public Groups getGroups() {
    return new Groups(groups);
  }

    @Override
    public String toString() {
      return "ContactData{" +
              "firstname='" + firstname + '\'' +
              ", lastname='" + lastname + '\'' +
              ", address='" + address + '\'' +
              ", homePhone='" + homePhone + '\'' +
              ", mobilePhone='" + mobilePhone + '\'' +
              ", workPhone='" + workPhone + '\'' +
              ", email='" + email + '\'' +
              ", email2='" + email2 + '\'' +
              ", email3='" + email3 + '\'' +
              ", groups=" + groups +
              '}';
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      ContactData that = (ContactData) o;

      if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
      if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
      if (address != null ? !address.equals(that.address) : that.address != null) return false;
      if (homePhone != null ? !homePhone.equals(that.homePhone) : that.homePhone != null) return false;
      if (mobilePhone != null ? !mobilePhone.equals(that.mobilePhone) : that.mobilePhone != null) return false;
      if (workPhone != null ? !workPhone.equals(that.workPhone) : that.workPhone != null) return false;
      if (email != null ? !email.equals(that.email) : that.email != null) return false;
      if (email2 != null ? !email2.equals(that.email2) : that.email2 != null) return false;
      if (email3 != null ? !email3.equals(that.email3) : that.email3 != null) return false;
      return groups != null ? groups.equals(that.groups) : that.groups == null;
    }

    @Override
    public int hashCode() {
      int result = firstname != null ? firstname.hashCode() : 0;
      result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
      result = 31 * result + (address != null ? address.hashCode() : 0);
      result = 31 * result + (homePhone != null ? homePhone.hashCode() : 0);
      result = 31 * result + (mobilePhone != null ? mobilePhone.hashCode() : 0);
      result = 31 * result + (workPhone != null ? workPhone.hashCode() : 0);
      result = 31 * result + (email != null ? email.hashCode() : 0);
      result = 31 * result + (email2 != null ? email2.hashCode() : 0);
      result = 31 * result + (email3 != null ? email3.hashCode() : 0);
      result = 31 * result + (groups != null ? groups.hashCode() : 0);
      return result;
    }
  }
