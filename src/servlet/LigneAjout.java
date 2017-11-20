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

import staticReference.ErreurStatic;
import staticReference.EtatStatic;
import entity.Forfait;
import entity.Ligne;
import entity.Localite;
import entity.Type;
import entity.dao.ForfaitDAO;
import entity.dao.LigneDAO;
import entity.dao.LocaliteDAO;
import entity.dao.TypeDAO;

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
			
			String numeroLigne = request.getParameter("numeroLigne");
			String JJ = request.getParameter("jour");
			String MM = request.getParameter("mois");
			String AAAA = request.getParameter("annee");
			
			if(numeroLigne.startsWith("+212")){
			numeroLigne = numeroLigne.substring(1);
			}
			
			String dateCreation = request.getParameter("annee")+"-"+request.getParameter("mois")+"-"+request.getParameter("jour");
			
			String idLocaliteCaractere = request.getParameter("localite");
			String idTypeCaractere = request.getParameter("type");
//			String idForfaitCaractere = request.getParameter("forfait");
			
			
			if(!idTypeCaractere.equals("")){
				
			int idLocalite = Integer.parseInt(idLocaliteCaractere);
			
			LocaliteDAO localiteDAO = new LocaliteDAO();
			Localite localite = new Localite();
			localite = localiteDAO.findByID(idLocalite);
			
			ligne.setLocalite(localite);
			
			}else{
				ligne.setLocalite(null);
			}
			if(!idTypeCaractere.equals("")){
				
			int idType = Integer.parseInt(idTypeCaractere);
			
			TypeDAO typeDAO = new TypeDAO();
			Type type = new Type();
			type = typeDAO.findByID(idType);
			
			ligne.setType(type);
			
			}else{
				ligne.setType(null);
			}
//			int idForfait = Integer.parseInt(idForfaitCaractere);
			
			
			
			
//			TypeDAO typeDAO = new TypeDAO();
//			Type type = new Type();
//			type = typeDAO.findByID(idType);
			
			
			
			
			ligne.setNumero(numeroLigne);
			
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			try {
				if(!JJ.equals("JJ") && !MM.equals("MMMM") && !AAAA.equals("AAAA")){
				ligne.setDateCreation(formatter.parse(dateCreation));
				}else{
					ligne.setDateCreation(null);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			ligne.setEtat(EtatStatic.ETAT_OPERATIONNEL);
			
			LigneDAO ligneDAO = new LigneDAO();
			try {
				ligneDAO.insertLigne(ligne, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				
				request.setAttribute("errorMessage", numeroLigne + ErreurStatic.NUMERO_EXISTANT);
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ligneAjout.jsp") ;
				requestDispatcher.forward(request, response) ;
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
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ligne.jsp") ;
				requestDispatcher.forward(request, response) ;
			}else{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ligneAjout.jsp") ;
			requestDispatcher.forward(request, response) ;
			}
			
			
			
		}else if(request.getParameter("A") != null){
			System.out.println("A");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ligne.jsp") ;
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
