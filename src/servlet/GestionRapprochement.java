package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GestionRapprochement
 */
@WebServlet("/GestionRapprochement")
public class GestionRapprochement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionRapprochement() {
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
		
		String listTypeRapprochement[]=request.getParameterValues("typeRapprochement");
		String listMois[]=request.getParameterValues("mois");
		String listAnnee[]=request.getParameterValues("annee");
		
		for(int typeRapprochement=0;typeRapprochement<listTypeRapprochement.length;typeRapprochement++){
			
			for(int mois=0;mois<listTypeRapprochement.length;mois++){
				
				for(int annee=0;annee<listTypeRapprochement.length;annee++){
					
				}
			}
		}
		
		
	}

}
