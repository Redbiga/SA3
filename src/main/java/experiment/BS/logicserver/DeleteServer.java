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

@WebServlet("/delete")
public class DeleteServer extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ccode = req.getParameter("ccode");
        SqlSession sqlsession = MybatisUtil.getSession();
        ContactsDao contactsMapper = sqlsession.getMapper(ContactsDao.class);

        contactsMapper.contactsDelete(Integer.parseInt(ccode));
        //手动提交事务
        sqlsession.commit();
    }
}
