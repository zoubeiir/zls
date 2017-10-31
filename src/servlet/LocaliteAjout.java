package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entite.Localite;
import entite.dao.LocaliteDAO;

/**
 * Servlet implementation class LocaliteAjout
 */
@WebServlet("/LocaliteAjout")
public class LocaliteAjout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocaliteAjout() {
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
		
		// Boutton choisi
				if(request.getParameter("VN") != null || request.getParameter("V") != null){

					// get parameters
					String codeLocalite = request.getParameter("codeLocalite");
					String adressePostale = request.getParameter("adressePostale");
					String adresseIP = request.getParameter("adresseIP");
					String responsable = request.getParameter("responsable");
					
					
					Localite localite = new Localite();
					LocaliteDAO localiteDAO = new LocaliteDAO();
					
					// fill entity
					localite.setCode(codeLocalite);
					localite.setAdressePostale(adressePostale);
					localite.setAdresseIP(adresseIP);
					localite.setResponsable(responsable);
					
					//insert entity
					try {
						localiteDAO.insertLocalite(localite, true);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
			
			// Redirections
			if(request.getParameter("V") != null) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/localite.html") ;
				requestDispatcher.forward(request, response) ;
			}else{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/localiteAjout.html") ;
			requestDispatcher.forward(request, response) ;
			}
			
			
			
		}else if(request.getParameter("A") != null){
			System.out.println("A");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/localite.html") ;
			requestDispatcher.forward(request, response) ;
		}else{
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/localiteAjout.html") ;
			requestDispatcher.forward(request, response) ;
		}
		
		
	}
		
}