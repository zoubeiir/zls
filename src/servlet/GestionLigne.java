package servlet;

import hibernateEntity.Ligne;
import hibernateEntity.Porteur;
import hibernateEntity.dao.LigneDAO;
import hibernateEntity.dao.PorteurDAO;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.util.HibernateUtil;

import antlr.StringUtils;
import hibernateEntity.base.*;

/**
 * Servlet implementation class GestionLigne
 */
@WebServlet("/GestionLigne")
public class GestionLigne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionLigne() {
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
		
		
		
		
		
		if(request.getParameter("VN") != null || request.getParameter("V") != null){
			
			
			
			Ligne ligne = new Ligne();
			Porteur porteur = new Porteur();
			
			
			String numeroLigne = request.getParameter("numeroLigne") ;
			
			PorteurDAO porteurDAO = new PorteurDAO();
			porteur = porteurDAO.findByNumero(numeroLigne);
			
			//TODO
			ligne.setNumeroLigne(porteur);
			
			String fraisLigne = request.getParameter("fraisLigne") ;
			
			float fraisLigneFloat = Float.parseFloat(fraisLigne);
			
			ligne.setFrais(fraisLigneFloat);
			
			
			
			
			
			if(request.getParameter("test1")!=null){
				ligne.setEtat("1");
			}else if(request.getParameter("test2")!=null){
				ligne.setEtat("2");
			}else{
				ligne.setEtat("3");
			}
			
			
			
			
			
			
			
			LigneDAO ligneDAO = new LigneDAO();
			ligneDAO.create(ligne);
			
			if(request.getParameter("V") != null) {
				System.out.println("V");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ligne.html") ;
				requestDispatcher.forward(request, response) ;
			}
			
			System.out.println("VN");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ligneAjout.html") ;
			requestDispatcher.forward(request, response) ;
			
			
			
		}else {
			System.out.println("A");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ligne.html") ;
			requestDispatcher.forward(request, response) ;
		}
		
		
		
		
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/accueil.html") ;
//	    requestDispatcher.forward(request, response) ;
		
	}

}
