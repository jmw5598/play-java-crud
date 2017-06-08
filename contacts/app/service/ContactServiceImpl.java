package service;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import model.Contact;

public class ContactServiceImpl implements ContactService {

  private List<Contact> contacts;

  public ContactServiceImpl() {
    contacts = new ArrayList<>();
    loadContacts();
  }

  @Override
  public Contact findById(Integer id) {
    return getContact(id);
  }

  @Override
  public List<Contact> findAll() {
    return this.contacts;
  }

  @Override
  public Integer countContacts() {
    return this.contacts.size();
  }

  @Override
  public Contact add(Contact contact) {
    Long c = contacts.stream().filter(e -> e.getId() == contact.getId()).count();
    if(c == 0) {
      contacts.add(contact);
      return contact;
    }
    return null;
  }

  @Override
  public Contact update(Contact contact) {
    Contact c = null;
    if(contact != null && contact.getId() != null) {
      c = getContact(contact.getId());
      c.setName(contact.getName());
      c.setPhone(contact.getPhone());
      c.setEmail(contact.getEmail());
    }
    return c;
  }

  @Override
  public Contact remove(Integer id) {
    Contact contact = getContact(id);
    if(contact != null) contacts.remove(contact);
    return contact;
  }

  private Contact getContact(Integer id) {
    return contacts.stream()
                   .filter(e -> e.getId() == id)
                   .findFirst()
                   .get();
  }

  private void loadContacts() {
    contacts.add(
      new Contact (1, "John Doe", "248-444-4444", "jdoe@gmail.com")
    );
    contacts.add(
      new Contact(2, "Jane Does", "248-333-3333", "jane.doe@gamil.com")
    );
    contacts.add(
      new Contact(3, "Oliver Twist", "248-322-2321", "o.twist@gmail.com")
    );
    contacts.add(
      new Contact(4, "Emma Twist", "248-322-2321", "e.twist@gmail.com")
    );
    contacts.add(
      new Contact(5, "James Twist", "248-322-2221", "james.twist@gmail.com")
    );
  }

}
