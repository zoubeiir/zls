package servlet;

import hibernateEntity.Ligne;
import hibernateEntity.Porteur;
import hibernateEntity.dao.LigneDAO;
import hibernateEntity.dao.PorteurDAO;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LigneAjout
 */
@WebServlet("/LigneAjout")
public class LigneAjout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LigneAjout() {
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


		// Boutton choisi
		if(request.getParameter("VN") != null || request.getParameter("V") != null){
			
			Ligne ligne = new Ligne();
			Porteur porteur = new Porteur();
			
			//
			porteur =this.getPorteurDB(request);
			ligne = this.fillEntity(porteur,request);
			try {
				this.insertDBLigne(ligne);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// Redirections
			if(request.getParameter("V") != null) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ligne.html") ;
				requestDispatcher.forward(request, response) ;
			}else{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ligneAjout.html") ;
			requestDispatcher.forward(request, response) ;
			}
			
			
			
		}else {
			System.out.println("A");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ligne.html") ;
			requestDispatcher.forward(request, response) ;
		}
		
		
	}

	private void insertDBLigne(Ligne ligne) throws Exception {
		LigneDAO ligneDAO = new LigneDAO();
		boolean uniqueInsert = true;
		ligneDAO.insertLigne(ligne,uniqueInsert);
	}

	private Porteur getPorteurDB(HttpServletRequest request) {
		String numeroLigne = request.getParameter("numeroLigne");
		//récuperer le porteur lié à la ligne ajoutée
		PorteurDAO porteurDAO = new PorteurDAO();
		LigneDAO ligneDAO = new LigneDAO();
		Ligne ligne = new Ligne();
		ligne = ligneDAO.findByNumero(numeroLigne);
		//TODO
		return porteurDAO.findByNumero(ligne);
//		return null;
	}

	private Ligne fillEntity(Porteur porteur, HttpServletRequest request) {
		Ligne ligne= new Ligne();
		ligne.setNumeroLigne(request.getParameter("numeroLigne"));
		String fraisLigne = request.getParameter("fraisLigne") ;
		float fraisLigneFloat = Float.parseFloat(fraisLigne);
		ligne.setFrais(fraisLigneFloat);
		ligne.setEtat(request.getParameter("etat"));
		return ligne;
	}

}
