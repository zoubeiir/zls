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

import entite.Ligne;
import entite.dao.LigneDAO;

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
		
		
		if(request.getParameter("R") != null){
			
			request.getSession().removeAttribute("listeLigne");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ligneRecherche.jsp") ;
			requestDispatcher.forward(request, response);
			
		}else if(request.getParameter("A") != null){
			
//			request.getSession().removeAttribute("listeLigne");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ligne.html") ;
			requestDispatcher.forward(request, response);
			
			
			
		}else if (request.getParameter("C") != null){ 
		
		
		
		Ligne ligne = new Ligne();
//		Porteur porteur = new Porteur();
		LigneDAO ligneDAO = new LigneDAO();
		List<Ligne> listeLigne = new ArrayList<Ligne>();
		
		List<Ligne> listeLigneRecherche = new ArrayList<Ligne>();
		
		
		
		
		
		String numeroLigne = request.getParameter("numeroLigne") ;
		String localite = request.getParameter("localite") ;
		String type = request.getParameter("type") ;
		
//		PorteurDAO porteurDAO = new PorteurDAO();
//		porteur = porteurDAO.findByNumero(numeroLigne);
		
//		porteur.setLigne(numeroLigne);
		//TODO
		
		if(numeroLigne=="" || numeroLigne.equals("+212")){
			listeLigne = ligneDAO.findAll();
		
			
			if(localite!=""){
			for(int i = 0 ; i < listeLigne.size() ; i++){
				
				if(!listeLigne.get(i).getLocalite().getId().toString().equals(localite)){
//					listeLigne.remove(i);
				}else{
					listeLigneRecherche.add(listeLigne.get(i));
					System.out.println(listeLigne.get(i).getLocalite().getCode());
				}
			}
			if(type!=""){
				for(int i = 0 ; i < listeLigne.size() ; i++){
					
					if(!listeLigne.get(i).getType().getId().toString().equals(type)){
						listeLigneRecherche.remove(listeLigne.get(i));
					}else{
						System.out.println(listeLigne.get(i).getLocalite().getCode());
					}
				}
			}
			}else{
//				listeLigneRecherche = listeLigne;
				if(type!=""){
					for(int i = 0 ; i < listeLigne.size() ; i++){
						
						if(!listeLigne.get(i).getType().getId().toString().equals(type)){
//							listeLigneRecherche.remove(listeLigne.get(i));
						}else{
							System.out.println(listeLigne.get(i).getLocalite().getCode());
							listeLigneRecherche.add(listeLigne.get(i));
						}
					}
				}else{
					listeLigneRecherche=listeLigne;
				}
			}
			
			
		}else {
		
//			listeLigneRecherche=ligneDAO.findAll();
			numeroLigne = numeroLigne.replace(" ", "");
			numeroLigne = numeroLigne.replace("\t", "");
			if(numeroLigne.startsWith("+212"))
		numeroLigne =numeroLigne.replace("+212", "212");
		ligne.setNumero(numeroLigne);
		
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
		
		
		
		
		
		
		
		try {
			listeLigneRecherche = ligneDAO.search(ligne);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		System.out.println(listeLigne.get(0).getFrais());
//		System.out.println(listeLigne.get(1).getFrais());
		
		}
		
		request.getSession().removeAttribute("listeLigne");
		request.getSession().setAttribute("listeLigne", listeLigneRecherche);
		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ligneRecherche.jsp") ;
		requestDispatcher.forward(request, response);
	}}

}
