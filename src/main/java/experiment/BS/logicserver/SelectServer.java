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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author redA
 */
@WebServlet("/select")
public class SelectServer extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String cname = req.getParameter("cname");
        SqlSession sqlsession = MybatisUtil.getSession();
        ContactsDao contactsMapper = sqlsession.getMapper(ContactsDao.class);

        List<Contacts> res = new ArrayList<>();
        if(cname.length() <= 0 || cname == null){
            res = contactsMapper.contactsSelectAll();
            System.out.println("all");
        }
        else{
            res = contactsMapper.contactsSelectByName("%"+cname+"%");
        }
        HttpSession session = req.getSession();
        session.setAttribute("selectRes",res);
        resp.setHeader("refresh","1");;
    }
}
