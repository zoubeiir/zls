package servlet;

import hibernateEntity.Ligne;
import hibernateEntity.Porteur;
import hibernateEntity.dao.LigneDAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 * Servlet implementation class LigneImport
 */
@WebServlet("/LigneImport")
public class LigneImport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LigneImport() {
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
		
		List<Ligne> listeLigneImport = new ArrayList<Ligne>();
		Ligne ligneActuelle = new Ligne();
//		Porteur porteurActuel = new Porteur();
		
		int column=0;
		int indexLigne = 0;
		
		
		
		try {
			
			String filename = request.getParameter("file");
			
			
//			FileInputStream file = new FileInputStream(filename);
			
			
//			XSSFWorkbook wb = new XSSFWorkbook(new File(filename));
			
			XSSFWorkbook wb = new XSSFWorkbook(new File("C:/Users/zsamouh/Desktop/Classeur1.xlsx"));
			
//			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("C:/Users/zsamouh/Desktop/Classeur1.xlsx"));
//			HSSFWorkbook wb = new HSSFWorkbook(fs);
			XSSFSheet sheet = wb.getSheetAt(0);
			XSSFRow row = null;
			XSSFCell cell = null;
			int numLigne = 0;
			for (Iterator rowIt = sheet.rowIterator(); rowIt.hasNext();) {
				row = (XSSFRow) rowIt.next();
				
				//vider les objets
				ligneActuelle = new Ligne();
//				porteurActuel = new Porteur();
				
				for (Iterator cellIt = row.cellIterator(); cellIt.hasNext();) {
					
					if(column>5){
						break;
					}
					if(numLigne>0){
					cell = (XSSFCell) cellIt.next();
					if(column==0){
//						porteurActuel.setLigne(cell.getStringCellValue());
						ligneActuelle.setNumeroLigne(cell.getStringCellValue());
					}else if (column==1){
						ligneActuelle.setEtat(cell.getStringCellValue());
					}else{
						ligneActuelle.setFrais((float) cell.getNumericCellValue());
					}
						
					}
					column++;
				}
				
				System.out.println(ligneActuelle);
				if(numLigne>0){
				listeLigneImport.add(ligneActuelle);
				}
				numLigne++;
				column=0;
				indexLigne++;
				}
			
			System.out.println(listeLigneImport);
			
			LigneDAO ligneDAO = new LigneDAO();
			ligneDAO.insertListLigne(listeLigneImport);
			
			} catch (FileNotFoundException e) {
			e.printStackTrace();
			} catch (IOException e) {
			e.printStackTrace();
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ligneImport.html") ;
		requestDispatcher.forward(request, response);
		
	}

}
