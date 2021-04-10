package pack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import DAO.loginDAOimp;
import entity.login;


@WebServlet("/loginController")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public loginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//L�ser uppgifter som matas in och kontrollerar att dessa finns i Db genom metoden authenticate
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		
		login l = new login();
		
		l.setName(name);
		l.setPassword(password);
		
		loginDAOimp i = new loginDAOimp();
		String log = i.authenticate(l);
		
		
		if (log.equals("true")) {
			session.setAttribute("name", name);
			response.sendRedirect("PostController?action=LIST");
			
		}else if (log.equals("false")) {
			response.sendRedirect("index.jsp?status=false");
		}
	}

}
