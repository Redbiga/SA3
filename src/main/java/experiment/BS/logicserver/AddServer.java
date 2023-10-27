package experiment.BS.logicserver;

import experiment.CS2.dataserver.ContactsDao;
import experiment.CS2.dataserver.MybatisUtil;
import experiment.CS2.entity.Contacts;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddServer extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cname = req.getParameter("cname");
        String caddress = req.getParameter("caddress");
        String cphone = req.getParameter("cphone");
        SqlSession sqlsession = MybatisUtil.getSession();
        ContactsDao contactsMapper = sqlsession.getMapper(ContactsDao.class);

        Contacts contacts = new Contacts();
        contacts.setCcode(null);
        contacts.setCname(cname);
        contacts.setCaddress(caddress);
        contacts.setCphone(cphone);

        contactsMapper.contactsAdd(contacts);
        //手动提交事务
        sqlsession.commit();
    }
}
