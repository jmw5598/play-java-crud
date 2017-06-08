package model;

import java.util.Objects;

public class Contact {

  private Integer id;
  private String name;
  private String phone;
  private String email;

  public Contact(Integer id, String name, String phone, String email) {
    this.id = id;
    this.name = name;
    this.phone = phone;
    this.email = email;
  }

  public Contact() {}

  public Integer getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public String getPhone() {
    return this.phone;
  }

  public String getEmail() {
    return this.email;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public boolean equals(Object o) {

    if (o == this) return true;
    if (!(o instanceof Contact)) return false;

    Contact contact = (Contact) o;
    return Objects.equals(id, contact.getId()) &&
           Objects.equals(name, contact.getName()) &&
           Objects.equals(phone, contact.getPhone()) &&
           Objects.equals(email, contact.getEmail());
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, phone, email);
  }

}
