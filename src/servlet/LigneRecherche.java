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

/**
 * Servlet implementation class LigneRecherche
 */
@WebServlet("/LigneRecherche")
public class LigneRecherche extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LigneRecherche() {
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
		
		Ligne ligne = new Ligne();
		Porteur porteur = new Porteur();
		
		
		String numeroLigne = request.getParameter("numeroLigne") ;
		
//		PorteurDAO porteurDAO = new PorteurDAO();
//		porteur = porteurDAO.findByNumero(numeroLigne);
		
		porteur.setLigne(numeroLigne);
		//TODO
		ligne.setNumeroLigne(porteur);
		
//		String fraisLigne = request.getParameter("fraisLigne") ;
//		
//		float fraisLigneFloat = Float.parseFloat(fraisLigne);
//		
//		ligne.setFrais(fraisLigneFloat);
		
		
		
		
		
//		if(request.getParameter("test1")!=null){
//			ligne.setEtat("1");
//		}else if(request.getParameter("test2")!=null){
//			ligne.setEtat("2");
//		}else{
//			ligne.setEtat("3");
//		}
		
		
		
		
		
		
		
		LigneDAO ligneDAO = new LigneDAO();
//		ligneDAO.search(ligne);
		List<Ligne> listeLigne = ligneDAO.search(ligne);
		
		System.out.println(listeLigne.get(0).getFrais());
		System.out.println(listeLigne.get(1).getFrais());
		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ligneRecherche.html") ;
		requestDispatcher.forward(request, response);
	}

}
