package experiment.CS3.logicserver;

import experiment.CS2.dataserver.ContactsDao;
import experiment.CS2.dataserver.MybatisUtil;
import experiment.CS2.entity.Contacts;
import org.apache.ibatis.session.SqlSession;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;

public class LogicServer {
    public static Object[][] select(String userText){
        SqlSession session = MybatisUtil.getSession();
        ContactsDao contactsMapper = session.getMapper(ContactsDao.class);

        List<Contacts> res = new ArrayList<>();
        if(userText.length() <= 0 || userText == null){
            res = contactsMapper.contactsSelectAll();
            System.out.println("all");
        }
        else{
            res = contactsMapper.contactsSelectByName("%"+userText+"%");
        }
        Object[][] res_content = new Object[100][4];
        for(int i=0; i<res.size(); i++){
            Contacts contacts = res.get(i);
            res_content[i][0] = contacts.getCcode();
            res_content[i][1] = contacts.getCname();
            res_content[i][2] = contacts.getCaddress();
            res_content[i][3] = contacts.getCphone();
        }
        return res_content;
    }
    public static void add(String userText1,String userText2,String userText3){
        SqlSession session = MybatisUtil.getSession();
        ContactsDao contactsMapper = session.getMapper(ContactsDao.class);

        Contacts contacts = new Contacts();
        contacts.setCcode(null);
        contacts.setCname(userText1);
        contacts.setCaddress(userText2);
        contacts.setCphone(userText3);

        contactsMapper.contactsAdd(contacts);
        //手动提交事务
        session.commit();
    }
    public static void delete(String userText){
        SqlSession session = MybatisUtil.getSession();
        ContactsDao contactsMapper = session.getMapper(ContactsDao.class);

        contactsMapper.contactsDelete(Integer.parseInt(userText));
        //手动提交事务
        session.commit();
    }
    public static void update(String userText,String userText1,String userText2,String userText3){
        SqlSession session = MybatisUtil.getSession();
        ContactsDao contactsMapper = session.getMapper(ContactsDao.class);

        Contacts contacts = new Contacts();
        contacts.setCcode(Integer.parseInt(userText));
        contacts.setCname(userText1);
        contacts.setCaddress(userText2);
        contacts.setCphone(userText3);
        contactsMapper.contactsUpdate(contacts);
        //手动提交事务
        session.commit();
    }
}
