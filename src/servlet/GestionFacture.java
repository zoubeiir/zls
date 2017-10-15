package servlet;

import hibernateEntity.Facture;
import hibernateEntity.Ligne;
import hibernateEntity.dao.FactureDAO;
import hibernateEntity.dao.LigneDAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Servlet implementation class GestionFacture
 */
@WebServlet("/GestionFacture")
public class GestionFacture extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionFacture() {
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
		//Import de facture /mois/année
		List<Facture> listeFactureImport = new ArrayList<Facture>();
		Facture factureActuelle = new Facture();
		Ligne ligneActuelle = new Ligne();
		String moisFacture = request.getParameter("mois");
		String anneeFacture = request.getParameter("annee");
		
		LigneDAO ligneDAO = new LigneDAO();
		
		int column=0;
		int indexFacture = 0;
		try {
			String filename = request.getParameter("file");
			XSSFWorkbook wb = new XSSFWorkbook(new File("C:/Users/zsamouh/Desktop/Facture.xlsx"));
			XSSFSheet sheet = wb.getSheetAt(0);
			XSSFRow row = null;
			XSSFCell cell = null;
			int numLigne = 0;
			for (Iterator rowIt = sheet.rowIterator(); rowIt.hasNext();) {
				row = (XSSFRow) rowIt.next();
				factureActuelle = new Facture();
				ligneActuelle = new Ligne();
				factureActuelle.setMois(moisFacture);
				factureActuelle.setAnnee(anneeFacture);
				for (Iterator cellIt = row.cellIterator(); cellIt.hasNext();) {
					if(column>2){
						break;
					}else{
					if(numLigne>0){
					cell = (XSSFCell) cellIt.next();
					if(column==0){
						
						ligneActuelle = ligneDAO.findByNumero(cell.getStringCellValue());
//						ligneActuelle.setId(null);
						factureActuelle.setLigne(ligneActuelle);
						
					}else if (column==1){
						factureActuelle.setFrais((float) cell.getNumericCellValue());
					}else if (column==2){
						factureActuelle.setIdFacture(cell.getStringCellValue());
					}
					}
					}
					column++;
				}
				System.out.println(factureActuelle);
				if(numLigne>0){
				listeFactureImport.add(factureActuelle);
				}
				numLigne++;
				column=0;
				indexFacture++;
				}
			System.out.println(listeFactureImport);
			
			
			
			FactureDAO factureDAO = new FactureDAO();
			try {
				factureDAO.insertListFacture(listeFactureImport);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				try {
					throw e;
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			} catch (FileNotFoundException e) {
			e.printStackTrace();
			} catch (IOException e) {
			e.printStackTrace();
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/facture.html") ;
		requestDispatcher.forward(request, response);
	}
}
