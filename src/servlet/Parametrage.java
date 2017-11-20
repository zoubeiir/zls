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

import entity.Forfait;
import entity.LiaisonTypeForfait;
import entity.Type;
import entity.dao.ForfaitDAO;
import entity.dao.LiaisonTypeForfaitDAO;
import entity.dao.TypeDAO;

/**
 * Servlet implementation class Parametrage
 */
@WebServlet("/Parametrage")
public class Parametrage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Parametrage() {
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
		
		if(request.getParameter("A") != null ){
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/parametrage.jsp") ;
			requestDispatcher.forward(request, response);
			
		}else if(request.getParameter("MAJForfait") !=null){
			
			int idForfait = Integer.parseInt(request.getParameter("forfait"));
			float coutForfait=Float.parseFloat(request.getParameter("coutForfait"));
			
			Forfait forfait = new Forfait();
			ForfaitDAO forfaitDAO = new ForfaitDAO();
			
			forfait = forfaitDAO.findByID(idForfait);
			forfait.setCout(coutForfait);
			
			forfaitDAO.updateForfait(forfait);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/aamajPrix.jsp") ;
			requestDispatcher.forward(request, response);
			
		}else if(request.getParameter("LTypeForfait") !=null){
			
			int idType = Integer.parseInt(request.getParameter("type"));
			int idForfait = Integer.parseInt(request.getParameter("forfait"));
			
			Forfait forfait = new Forfait();
			ForfaitDAO forfaitDAO = new ForfaitDAO();
			forfait = forfaitDAO.findByID(idForfait);
			
			Type type = new Type();
			TypeDAO typeDAO = new TypeDAO();
			type = typeDAO.findByID(idType);
			
			LiaisonTypeForfait liaisonTypeForfait = new LiaisonTypeForfait();
			LiaisonTypeForfaitDAO liaisonTypeForfaitDAO = new LiaisonTypeForfaitDAO();
			
			liaisonTypeForfait.setForfait(forfait);
			liaisonTypeForfait.setType(type);
			 
			liaisonTypeForfaitDAO.insertLiaisonTypeForfait(liaisonTypeForfait, true);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/aaliaisonTypeForfait.jsp") ;
			requestDispatcher.forward(request, response);
			
			
		}else if(request.getParameter("DTypeForfait") !=null){
			
			int idType = Integer.parseInt(request.getParameter("type"));
			int idForfait = Integer.parseInt(request.getParameter("forfait"));
			boolean exists = false;
			
			Forfait forfait = new Forfait();
			ForfaitDAO forfaitDAO = new ForfaitDAO();
			forfait = forfaitDAO.findByID(idForfait);
			
			Type type = new Type();
			TypeDAO typeDAO = new TypeDAO();
			type = typeDAO.findByID(idType);
			
			List<LiaisonTypeForfait> listeLiaisonTypeForfait = new ArrayList<LiaisonTypeForfait>();
			LiaisonTypeForfaitDAO liaisonTypeForfaitDAO = new LiaisonTypeForfaitDAO();
			
			listeLiaisonTypeForfait = liaisonTypeForfaitDAO.findByType(type);
			
			LiaisonTypeForfait liaisonTypeForfait = new LiaisonTypeForfait();
			
			for(int indexLiaison=0; indexLiaison < listeLiaisonTypeForfait.size(); indexLiaison++){
				
				if(listeLiaisonTypeForfait.get(indexLiaison).getForfait().getId()==forfait.getId()){
					exists=true;
				liaisonTypeForfait=listeLiaisonTypeForfait.get(indexLiaison);
			}}
			
//			liaisonTypeForfait.setForfait(forfait);
//			liaisonTypeForfait.setType(type);
			if(exists){
			try {
				liaisonTypeForfaitDAO.deleteLigne(liaisonTypeForfait, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/aaliaisonTypeForfait.jsp") ;
			requestDispatcher.forward(request, response);
			
			
		}else if(request.getParameter("AType") !=null){
			
			String codeType = request.getParameter("codeType");
			
			Type type = new Type();
			TypeDAO typeDAO = new TypeDAO();
			
			type.setCode(codeType);
			type.setCout((float)0);
			typeDAO.insertType(type,true);
			
		
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/aaajoutTypeForfait.jsp") ;
			requestDispatcher.forward(request, response);
			
		}else if(request.getParameter("AForfait") !=null){
			
			String codeForfait=request.getParameter("codeForfait");
			float coutForfait=Float.parseFloat(request.getParameter("coutForfait"));
			
			Forfait forfait = new Forfait();
			ForfaitDAO forfaitDAO = new ForfaitDAO();
			
			forfait.setCode(codeForfait);
			forfait.setCout(coutForfait);
			
			forfaitDAO.insertForfait(forfait,true);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/aaajoutTypeForfait.jsp") ;
			requestDispatcher.forward(request, response);
		}else if(request.getParameter("SForfait") !=null) {
			
			
			int idForfait = Integer.parseInt(request.getParameter("forfait"));
			
			Forfait forfait = new Forfait();
			ForfaitDAO forfaitDAO = new ForfaitDAO();
			forfait = forfaitDAO.findByID(idForfait);
			
			
			
			List<LiaisonTypeForfait> listeLiaisonTypeForfait = new ArrayList<LiaisonTypeForfait>();
			LiaisonTypeForfaitDAO liaisonTypeForfaitDAO = new LiaisonTypeForfaitDAO();
			
			listeLiaisonTypeForfait = liaisonTypeForfaitDAO.findByForfait(forfait);
			
			if(listeLiaisonTypeForfait.size()>0){
			try {
				liaisonTypeForfaitDAO.deleteListe(listeLiaisonTypeForfait);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
			//TODO
			try {
				forfaitDAO.deleteLigne(forfait,true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
			
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/aaajoutTypeForfait.jsp") ;
			requestDispatcher.forward(request, response);
			
		}else if(request.getParameter("SType") !=null){
			
			int idType = Integer.parseInt(request.getParameter("type"));
			
			Type type = new Type();
			TypeDAO typeDAO = new TypeDAO();
			type = typeDAO.findByID(idType);
			
			List<LiaisonTypeForfait> listeLiaisonTypeForfait = new ArrayList<LiaisonTypeForfait>();
			LiaisonTypeForfaitDAO liaisonTypeForfaitDAO = new LiaisonTypeForfaitDAO();
			
			listeLiaisonTypeForfait = liaisonTypeForfaitDAO.findByType(type);
			
			if(listeLiaisonTypeForfait.size()>0){
			try {
				liaisonTypeForfaitDAO.deleteListe(listeLiaisonTypeForfait);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
			//TODO
			try {
				typeDAO.deleteLigne(type,true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/aaajoutTypeForfait.jsp") ;
			requestDispatcher.forward(request, response);
			
			
		}
		
	}

}
