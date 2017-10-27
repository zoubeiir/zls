package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import staticReference.EtatStatic;
import entite.Forfait;
import entite.Ligne;
import entite.Localite;
import entite.Type;
import entite.dao.ForfaitDAO;
import entite.dao.LigneDAO;
import entite.dao.LocaliteDAO;
import entite.dao.TypeDAO;

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
			
			
			
			
			String numeroLigne = request.getParameter("numeroLigne");
			String dateCreation = request.getParameter("dateCreation");
			String idLocaliteCaractere = request.getParameter("localite");
			String idTypeCaractere = request.getParameter("type");
			String idForfaitCaractere = request.getParameter("forfait");
			
			int idLocalite = Integer.parseInt(idLocaliteCaractere);
			int idType = Integer.parseInt(idTypeCaractere);
//			int idForfait = Integer.parseInt(idForfaitCaractere);
			
			
			LocaliteDAO localiteDAO = new LocaliteDAO();
			Localite localite = new Localite();
			localite = localiteDAO.findByID(idLocalite);
			
//			TypeDAO typeDAO = new TypeDAO();
//			Type type = new Type();
//			type = typeDAO.findByID(idType);
			
			TypeDAO typeDAO = new TypeDAO();
			Type type = new Type();
			type = typeDAO.findByID(idType);
			
			Ligne ligne = new Ligne();
			ligne.setNumero(numeroLigne);
			
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			try {
				ligne.setDateCreation(formatter.parse(dateCreation));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ligne.setLocalite(localite);
			ligne.setType(type);
			
			ligne.setEtat(EtatStatic.ETAT_OPERATIONNEL);
			
			LigneDAO ligneDAO = new LigneDAO();
			try {
				ligneDAO.insertLigne(ligne, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
//			Ligne ligne = new Ligne();
//			Porteur porteur = new Porteur();
			
			//
//			porteur =this.getPorteurDB(request);
//			ligne = this.fillentite(porteur,request);
//			try {
//				this.insertDBLigne(ligne);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			// Redirections
			if(request.getParameter("V") != null) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ligne.html") ;
				requestDispatcher.forward(request, response) ;
			}else{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ligneAjout.jsp") ;
			requestDispatcher.forward(request, response) ;
			}
			
			
			
		}else if(request.getParameter("A") != null){
			System.out.println("A");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ligne.html") ;
			requestDispatcher.forward(request, response) ;
		}else{
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ligneAjout.jsp") ;
			requestDispatcher.forward(request, response) ;
		}
		
		
	}

//	private void insertDBLigne(Ligne ligne) throws Exception {
//		LigneDAO ligneDAO = new LigneDAO();
//		boolean uniqueInsert = true;
////		ligneDAO.insertLigne(ligne,uniqueInsert);
//	}

//	private Porteur getPorteurDB(HttpServletRequest request) {
//		String numeroLigne = request.getParameter("numeroLigne");
//		//récuperer le porteur lié à la ligne ajoutée
//		PorteurDAO porteurDAO = new PorteurDAO();
//		LigneDAO ligneDAO = new LigneDAO();
//		Ligne ligne = new Ligne();
//		ligne = ligneDAO.findByNumero(numeroLigne);
//		//TODO
//		return porteurDAO.findByNumero(ligne);
////		return null;
//	}
//
//	private Ligne fillentite(Porteur porteur, HttpServletRequest request) {
//		Ligne ligne= new Ligne();
//		ligne.setNumero(request.getParameter("numeroLigne"));
//		String fraisLigne = request.getParameter("fraisLigne") ;
//		float fraisLigneFloat = Float.parseFloat(fraisLigne);
////		ligne.setFrais(fraisLigneFloat);
////		ligne.setEtat(request.getParameter("etat"));
//		return ligne;
//	}

}
