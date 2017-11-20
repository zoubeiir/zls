package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import entity.LiaisonTypeForfait;
import entity.Localite;
import entity.Type;
import entity.dao.LiaisonTypeForfaitDAO;
import entity.dao.LocaliteDAO;
import entity.dao.TypeDAO;
import entity.Ligne;
import entity.base.*;
import entity.dao.LigneDAO;
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
		
		// get parameters
		String numeroLigne=request.getParameter("numeroLigne");
		String mf=request.getParameter("mf");

		// initiate DAOs
		LigneDAO ligneDAO = new LigneDAO();
		LiaisonTypeForfaitDAO liaisonTypeForfaitDAO = new LiaisonTypeForfaitDAO();
		
		//initiate and get ligne from DB
		Ligne ligne = new Ligne();
		ligne=ligneDAO.findByNumero(numeroLigne);
		
		// initiate and get listeLiaisonTypeForfait from DB
		List<LiaisonTypeForfait> listeLiaisonTypeForfait = new ArrayList<LiaisonTypeForfait>();
		listeLiaisonTypeForfait = liaisonTypeForfaitDAO.findByType(ligne.getType());
		
		// set attributes
		request.getSession().setAttribute("ligne", ligne);
		request.getSession().setAttribute("mf", mf);
		request.getSession().setAttribute("listeLiaisonTypeForfait", listeLiaisonTypeForfait);
		
		//forwards
		if(mf==null){
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ligneConsultation.jsp") ;
			requestDispatcher.forward(request, response);
		}else if(mf.equals("m")){
		
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ligneModification.jsp") ;
			requestDispatcher.forward(request, response);
			
		}else{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ligneConsultation.jsp") ;
			requestDispatcher.forward(request, response);
		
	}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getParameter("R") != null ){
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ligneRecherche.jsp") ;
			requestDispatcher.forward(request, response);
		}else if (request.getParameter("V") != null){
			
			//get parameter
			
			String JJ = request.getParameter("jour");
			String MM = request.getParameter("mois");
			String AAAA = request.getParameter("annee");
			
			
			String numeroLigne=request.getParameter("numeroLigne");
			String idTypeCaractere = request.getParameter("type");
			String idLocaliteCaractere = request.getParameter("localite");
			String etatCaracter = request.getParameter("etat");
			String dateCreation = request.getParameter("annee")+"-"+request.getParameter("mois")+"-"+request.getParameter("jour");
			
			
			
			int idType;
			if(idTypeCaractere==""){
				idType=-1;
			}else{
			 idType = Integer.parseInt(idTypeCaractere);
			}
			int idLocalite;
			if(idLocaliteCaractere==""){
				idLocalite=-1;
			}else{
			 idLocalite=Integer.parseInt(idLocaliteCaractere);
			}
			int etat=Integer.parseInt(etatCaracter);
			
			boolean isChanged=false;
			
			LigneDAO ligneDAO = new LigneDAO();
			Ligne ligne = new Ligne();
			ligne=ligneDAO.findByNumero(numeroLigne);
			
			
			// MAJ du type
			if(idType==-1 && ligne.getType()==null ){
//				ça change rien
//				ligne.setType(null);
			}else if(idType==-1){
				ligne.setType(null);
				isChanged=true;
			}else if(idType!=-1 && ligne.getType()==null){
				TypeDAO typeDAO = new TypeDAO();
				Type type = new Type();
				type = typeDAO.findByID(idType);
				
				ligne.setType(type);
				isChanged=true;
				
			}else if(idType!=ligne.getType().getId()){
				TypeDAO typeDAO = new TypeDAO();
				Type type = new Type();
				type = typeDAO.findByID(idType);
				
				ligne.setType(type);
				isChanged=true;
			}
			
			
			// MAJ de la localité
			if(idLocalite==-1 && ligne.getLocalite()==null ){
//				ça change rien
//				ligne.setType(null);
			}else if(idLocalite==-1){
				ligne.setLocalite(null);
				isChanged=true;
			}else if(idLocalite!=-1 && ligne.getLocalite()==null){
				LocaliteDAO localiteDAO = new LocaliteDAO();
				Localite localite = new Localite();
				localite = localiteDAO.findByID(idLocalite);
				
				ligne.setLocalite(localite);
				isChanged=true;
				
			}else if(idLocalite!=ligne.getLocalite().getId()){
				LocaliteDAO localiteDAO = new LocaliteDAO();
				Localite localite = new Localite();
				localite = localiteDAO.findByID(idLocalite);
				
				ligne.setLocalite(localite);
				isChanged=true;
			}
//			if(!dateCreation.equals(ligne.getDateCreation().toString())){
				
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				try {
					if(!JJ.equals("JJ") && !MM.equals("MMMM") && !AAAA.equals("AAAA")){
						
					ligne.setDateCreation(formatter.parse(dateCreation));
					if(!dateCreation.equals(ligne.getDateCreation().toString()))
					isChanged=true;
					}else{
						ligne.setDateCreation(null);
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
//				System.out.println(dateCreation+"!!!!!!!"+ligne.getDateCreation().toString());
//				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//				try {
//					ligne.setDateCreation(formatter.parse(dateCreation));
//				} catch (ParseException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				
//			}
			
			if(etat!=ligne.getEtat()){
				
				
				ligne.setEtat(etat);
				isChanged=true;
			}
			
			
			if(isChanged){
				ligneDAO.update(ligne);
			}
			
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ligneRecherche.jsp") ;
			requestDispatcher.forward(request, response);
			
		}else if (request.getParameter("M") != null){
			
			//get parameter
			String numeroLigne=request.getParameter("numeroLigne");
			
			// initiate DAOs
			LigneDAO ligneDAO = new LigneDAO();
			LiaisonTypeForfaitDAO liaisonTypeForfaitDAO = new LiaisonTypeForfaitDAO();
			
			//initiate and get ligne from DB
			Ligne ligne = new Ligne();
			ligne=ligneDAO.findByNumero(numeroLigne);
			
			// initiate and get listeLiaisonTypeForfait from DB
			List<LiaisonTypeForfait> listeLiaisonTypeForfait = new ArrayList<LiaisonTypeForfait>();
			listeLiaisonTypeForfait = liaisonTypeForfaitDAO.findByType(ligne.getType());
			
			// set attributes
			request.getSession().setAttribute("ligne", ligne);
			request.getSession().setAttribute("listeLiaisonTypeForfait", listeLiaisonTypeForfait);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ligneModification.jsp") ;
			requestDispatcher.forward(request, response);
		}
		
		
		
//		Ligne ligneActuelle = new Ligne();
//		List<Ligne> listeLigne = new ArrayList<Ligne>();
//		
//		LigneDAO ligneDAO = new LigneDAO();
//		
//		String listCB[] = request.getParameterValues("checkbox");
//		
//		for(int i=0;i<listCB.length;i++){
//			
//			ligneActuelle=ligneDAO.findByNumero(listCB[i]);
//			System.out.println(ligneActuelle.getNumero());
//			if(ligneActuelle!=null)
//				listeLigne.add(ligneActuelle);
//		}
//
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ligneRecherche.jsp") ;
//		requestDispatcher.forward(request, response);
	}

}
