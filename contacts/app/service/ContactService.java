package service;

import java.util.List;
import com.google.inject.ImplementedBy;
import model.Contact;

@ImplementedBy(ContactServiceImpl.class)
public interface ContactService {
  Contact findById(Integer id);
  List<Contact> findAll();
  Contact add(Contact contact);
  Contact update(Contact contact);
  Contact remove(Integer id);
  Integer countContacts();
}
