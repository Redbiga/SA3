package experiment.CS2.dataserver;

import experiment.CS2.entity.Contacts;

import java.util.List;

public interface ContactsDao {

    void contactsAdd(Contacts contacts);
    void contactsDelete(Integer ccode);
    void contactsUpdate(Contacts contacts);

    List<Contacts> contactsSelectByName(String cname);
    List<Contacts> contactsSelectAll();
}
