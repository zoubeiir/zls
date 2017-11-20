package servlet;



//import hibernateEntity.base.BaseFactures;
//import hibernateEntity.base.BaseLigne;
//import hibernateEntity.base.BasePorteur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;








import staticReference.UserStatic;

import com.util.HibernateUtil;




/**
 * Servlet implementation class Auth
 */
@WebServlet("/Auth")
public class ZAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZAuth() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equals(UserStatic.username) && password.equals(UserStatic.password)){
			
			
			request.getSession().setAttribute("username",username);
			request.getSession().setAttribute("login","1");
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/accueil.jsp") ;
		    
		    requestDispatcher.forward(request, response) ;
		    
//		    String password = "password";
//			MessageDigest md = MessageDigest.getInstance("MD5");
//			md.update(password.getBytes());
//			byte[] md5 = md.digest();
			
		}else{
		
			request.getSession().setAttribute("username","LOGOUT");
			request.getSession().setAttribute("login","0");
			
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp") ;
	    
	    requestDispatcher.forward(request, response) ;
		}
	}
	
}
