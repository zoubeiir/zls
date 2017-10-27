package servlet;

import hibernateEntity.Ligne;

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

import entity.Localite;
import entity.dao.LocaliteDAO;

/**
 * Servlet implementation class LocaliteImport
 */
@WebServlet("/LocaliteImport")
public class LocaliteImport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocaliteImport() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Ligne> listeLigneImport = new ArrayList<Ligne>();
//		Ligne ligneActuelle = new Ligne();
		List<Localite> listeLocaliteImport = new ArrayList<Localite>();
//		Porteur porteurActuel = new Porteur();
		
		Localite localiteActuelle = new Localite();
		int column=0;
		int indexLigne = 0;
		
		boolean exists = false;
		
		try {
			
//			String filename = request.getParameter("file");
			
			
//			FileInputStream file = new FileInputStream(filename);
			
			
//			XSSFWorkbook wb = new XSSFWorkbook(new File(filename));
			
			XSSFWorkbook wb = new XSSFWorkbook(new File("C:/Users/zsamouh/Desktop/localitee.xlsx"));
			
//			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("C:/Users/zsamouh/Desktop/Classeur1.xlsx"));
//			HSSFWorkbook wb = new HSSFWorkbook(fs);
			XSSFSheet sheet = wb.getSheetAt(0);
			XSSFRow row = null;
			XSSFCell cell = null;
			int numLigne = 0;
			for (Iterator rowIt = sheet.rowIterator(); rowIt.hasNext();) {
				row = (XSSFRow) rowIt.next();
				exists=false;
				//vider les objets
//				ligneActuelle = new Ligne();
				localiteActuelle = new Localite();
//				porteurActuel = new Porteur();
				
				for (Iterator cellIt = row.cellIterator(); cellIt.hasNext();) {
					
					if(column>5){
						break;
					}
					if(numLigne>0){
					cell = (XSSFCell) cellIt.next();
					if(column==0){
//						porteurActuel.setLigne(cell.getStringCellValue());
//						ligneActuelle.setNumeroLigne(cell.getStringCellValue());
//						localiteActuelle.setCode(cell.getStringCellValue());
						localiteActuelle.setAdresseIP("IP"+cell.getNumericCellValue());
						localiteActuelle.setAdressePostale("AP"+cell.getNumericCellValue());
						localiteActuelle.setResponsable("Rsp"+cell.getNumericCellValue());
					}else if (column==1){
//						ligneActuelle.setEtat(cell.getStringCellValue());
						localiteActuelle.setCode(cell.getStringCellValue());
						
						for(int j = 0 ; j<listeLocaliteImport.size(); j++){
							if(cell.getStringCellValue().equals(listeLocaliteImport.get(j).getCode())){
								exists=true;
								System.out.println("index : "+numLigne + " cellule :"+ cell.getStringCellValue()+ " code :" + listeLocaliteImport.get(j).getCode() + " existant :"+j);
							}
						}
						
						
					}else{
//						ligneActuelle.setFrais((float) cell.getNumericCellValue());
					}
						
					}
					column++;
				}
				
//				System.out.println(localiteActuelle);
				if(numLigne>0 && !exists){
				listeLocaliteImport.add(localiteActuelle);
				}
				numLigne++;
				column=0;
				indexLigne++;
				}
			
			System.out.println(listeLigneImport);
			
			LocaliteDAO localiteDAO = new LocaliteDAO();
			localiteDAO.insertListLocalite(listeLocaliteImport);
			
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
