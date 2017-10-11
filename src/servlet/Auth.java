package servlet;



import hibernateEntity.base.BaseFactures;
import hibernateEntity.base.BaseLigne;
import hibernateEntity.base.BasePorteur;

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







import com.util.HibernateUtil;




/**
 * Servlet implementation class Auth
 */
@WebServlet("/Auth")
public class Auth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Auth() {
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
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		try {
		if(!sessionFactory.getCurrentSession().getTransaction().isActive()){
			Transaction transaction = sessionFactory.getCurrentSession().getTransaction();
			Transaction tx =sessionFactory.getCurrentSession().beginTransaction();
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(BaseLigne.class);
			System.out.println("===================="+crit.list().size());
			crit = sessionFactory.getCurrentSession().createCriteria(BaseFactures.class);
			System.out.println("===================="+crit.list().size());
			crit = sessionFactory.getCurrentSession().createCriteria(BasePorteur.class);
			System.out.println("===================="+crit.list().size());
		}
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("============" + e + "=============");
//			sessionFactory.close();
//		}
		

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
//		UserDAO userDAO = new UserDAO();
//		List<BaseTest> result = userDAO.findAll();
//		System.out.println("===================="+result.size());
//		System.out.println("username : " + username + "\npassword : "+password);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/menu.html") ;
	    
	    requestDispatcher.forward(request, response) ;
		
	}
	
}
