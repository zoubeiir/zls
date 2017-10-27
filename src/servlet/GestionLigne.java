package servlet;

import java.io.IOException;
import java.util.ArrayList;
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

import entite.LiaisonTypeForfait;
import entite.Type;
import entite.dao.LiaisonTypeForfaitDAO;
import entite.dao.TypeDAO;
import entite.Ligne;
import entite.base.*;
import entite.dao.LigneDAO;
import antlr.StringUtils;

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
		System.out.println(request.getParameter("numeroLigne"));
		
		String numeroLigne=request.getParameter("numeroLigne");
		LigneDAO ligneDAO = new LigneDAO();
		LiaisonTypeForfaitDAO liaisonTypeForfaitDAO = new LiaisonTypeForfaitDAO();
//		PorteurDAO porteurDAO = new PorteurDAO();
//		FactureDAO factureDAO = new FactureDAO();
		
		Ligne ligne = new Ligne();
		ligne=ligneDAO.findByNumero(numeroLigne);
		
		List<LiaisonTypeForfait> listeLiaisonTypeForfait = new ArrayList<LiaisonTypeForfait>();
		listeLiaisonTypeForfait = liaisonTypeForfaitDAO.findByType(ligne.getType());
		
		
		
//		Porteur porteur = new Porteur();
//		porteur=porteurDAO.findByNumero(ligne);
//		
//		List<Facture> listeFacture = new ArrayList<Facture>();
//		listeFacture = factureDAO.findByNumero(ligne);
		
		
		
//		request.getSession().setAttribute("porteur", porteur);
		
		
		request.getSession().setAttribute("ligne", ligne);
		System.out.println("id"+listeLiaisonTypeForfait.get(0).getId()+"--For--"+listeLiaisonTypeForfait.get(0).getType().getId()+"--Type--"+listeLiaisonTypeForfait.get(0).getType().getId());
	
		
		request.getSession().setAttribute("listeLiaisonTypeForfait", listeLiaisonTypeForfait);
		
//		request.getSession().setAttribute("listeFacture", listeFacture);
		
		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ligneConsultation.jsp") ;
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Ligne ligneActuelle = new Ligne();
		List<Ligne> listeLigne = new ArrayList<Ligne>();
		
		LigneDAO ligneDAO = new LigneDAO();
		
		String listCB[] = request.getParameterValues("checkbox");
		
		for(int i=0;i<listCB.length;i++){
			
			ligneActuelle=ligneDAO.findByNumero(listCB[i]);
			System.out.println(ligneActuelle.getNumero());
			if(ligneActuelle!=null)
				listeLigne.add(ligneActuelle);
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ligneRecherche.jsp") ;
		requestDispatcher.forward(request, response);
	}

}
