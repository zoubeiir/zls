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

import entity.LiaisonTypeForfait;
import entity.Ligne;
import entity.Localite;
import entity.Localite;
import entity.Type;
import entity.dao.LiaisonTypeForfaitDAO;
import entity.dao.LigneDAO;
import entity.dao.LocaliteDAO;
import entity.dao.LocaliteDAO;
import entity.dao.TypeDAO;

/**
 * Servlet implementation class GestionLocalite
 */
@WebServlet("/GestionLocalite")
public class GestionLocalite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionLocalite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
				// get parameters
				String codeLocalite=request.getParameter("codeLocalite");
				String mf=request.getParameter("mf");

				// initiate DAOs
				LocaliteDAO localiteDAO = new LocaliteDAO();
				
				//initiate and get localite from DB
				Localite localite = new Localite();
				localite = localiteDAO.findByCode(codeLocalite);
				
				// initiate and get listeLiaisonTypeForfait from DB
				List<Ligne> listeLigne = new ArrayList<Ligne>();
				LigneDAO ligneDAO = new LigneDAO();
				listeLigne=ligneDAO.findbylocalite(localite);
				
				// set attributes
				request.getSession().setAttribute("localite", localite);
				request.getSession().setAttribute("listeLigne", listeLigne);
				request.getSession().setAttribute("mf", mf);
				
				//forwards
				if(mf==null){
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/localiteConsultation.jsp") ;
					requestDispatcher.forward(request, response);
				}else if(mf.equals("m")){
				
					localite = this.prepareToModification(localite);
					request.getSession().setAttribute("localite", localite);
					
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/localiteModification.jsp") ;
					requestDispatcher.forward(request, response);
					
				}else{
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/localiteConsultation.jsp") ;
					requestDispatcher.forward(request, response);
				
			}
				
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getParameter("R") != null ){
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/localiteRecherche.jsp") ;
			requestDispatcher.forward(request, response);
		}else if (request.getParameter("V") != null){
			
			//get parameter
			String codeLocalite = request.getParameter("codeLocalite");
			String adressePostale = request.getParameter("adressePostale");
			String adresseIP = request.getParameter("adresseIP");
			String responsable = request.getParameter("responsable");
			
			boolean isChanged=false;
			
			LocaliteDAO localiteDAO = new LocaliteDAO();
			Localite localite = new Localite();
			localite=localiteDAO.findByCode(codeLocalite);
			
			if(adressePostale.replace(" ", "")!=localite.getAdressePostale().replace(" ", "")){
				
				localite.setAdressePostale(adressePostale);
				isChanged=true;
				
			}
			if(adresseIP.replace(" ", "")!=localite.getAdresseIP().replace(" ", "")){
				
				localite.setAdresseIP(adresseIP);
				isChanged=true;
				
			}
			
			if(responsable.replace(" ", "")!=localite.getResponsable().replace(" ", "")){
				
				localite.setResponsable(responsable);
				isChanged=true;
			}
			
			if(isChanged){
				localiteDAO.update(localite);
			}
			
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/localiteRecherche.jsp") ;
			requestDispatcher.forward(request, response);
			
		}else if (request.getParameter("M") != null){
			
			String codeLocalite=request.getParameter("codeLocalite");
			String mf=request.getParameter("mf");

			// initiate DAOs
			LocaliteDAO localiteDAO = new LocaliteDAO();
			
			//initiate and get localite from DB
			Localite localite = new Localite();
			localite = localiteDAO.findByCode(codeLocalite);
			
			localite = this.prepareToModification(localite);
			
			
			// initiate and get listeLiaisonTypeForfait from DB
			List<Ligne> listeLigne = new ArrayList<Ligne>();
			LigneDAO ligneDAO = new LigneDAO();
			listeLigne=ligneDAO.findbylocalite(localite);
			
			// set attributes
			request.getSession().setAttribute("localite", localite);
			request.getSession().setAttribute("listeLigne", listeLigne);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/localiteModification.jsp") ;
			requestDispatcher.forward(request, response);
		}
		
		
		

	}

	private Localite prepareToModification(Localite localite) {
		// TODO Auto-generated method stub
		
		String adressePostale= localite.getAdressePostale();
		String adresseIP = localite.getAdresseIP();
		String responsable = localite.getResponsable();
		
		adressePostale = adressePostale.replace("  ", "");
		adresseIP = adresseIP.replace("  ", "");
		responsable = responsable.replace("  ", "");
		
		localite.setAdressePostale(adressePostale);
		localite.setAdresseIP(adresseIP);
		localite.setResponsable(responsable);
		
		return localite;
	}

}
