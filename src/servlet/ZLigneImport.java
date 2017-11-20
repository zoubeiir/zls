package servlet;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
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

import entity.Forfait;
import entity.Ligne;
import entity.Localite;
import entity.dao.ForfaitDAO;
import entity.dao.LigneDAO;
import entity.dao.LocaliteDAO;


/**
 * Servlet implementation class LigneImport
 */
@WebServlet("/LigneImport")
public class ZLigneImport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZLigneImport() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Ligne> listeLigneImport = new ArrayList<Ligne>();
//		Ligne ligneActuelle = new Ligne();
//		List<Ligne> listeLigneImport = new ArrayList<Ligne>();
//		Porteur porteurActuel = new Porteur();
		
		Ligne ligneActuelle = new Ligne();
		
		Localite localiteActuelle = new Localite();
		LocaliteDAO localiteDAO = new LocaliteDAO();
		
		int column=0;
		int indexLigne = 0;
		
		boolean exists = false;
		
		Forfait forfaitFix = new Forfait();
		Forfait forfaitFax = new Forfait();
		Forfait forfaitGSMPro = new Forfait();
		
		ForfaitDAO forfaitDAO = new ForfaitDAO();
		
		forfaitFix = forfaitDAO.findByID(1);
		forfaitFax = forfaitDAO.findByID(2);
		forfaitGSMPro = forfaitDAO.findByID(3);
		
		String numeroActuel="";
		List<String> listeNumero = new ArrayList<String>();
		boolean existNumero = false;
		
		try {
			
//			String filename = request.getParameter("file");
			
			
//			FileInputStream file = new FileInputStream(filename);
			
			
//			XSSFWorkbook wb = new XSSFWorkbook(new File(filename));
			
			XSSFWorkbook wb = new XSSFWorkbook(new File("C:/Users/zsamouh/Desktop/Parc.xlsx"));
			
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
//				ligneActuelle = new Ligne();
				localiteActuelle = new Localite();
//				porteurActuel = new Porteur();
				
				for (Iterator cellIt = row.cellIterator(); cellIt.hasNext();) {
					numeroActuel="";
					ligneActuelle = new Ligne();
					if(column>10){
						break;
					}
					if(numLigne>0){
					cell = (XSSFCell) cellIt.next();
					if(column==0){
//						porteurActuel.setLigne(cell.getStringCellValue());
//						ligneActuelle.setNumeroLigne(cell.getStringCellValue());
//						ligneActuelle.setCode(cell.getStringCellValue());
//						ligneActuelle.setAdresseIP("IP"+cell.getNumericCellValue());
//						ligneActuelle.setAdressePostale("AP"+cell.getNumericCellValue());
//						ligneActuelle.setResponsable("Rsp"+cell.getNumericCellValue());
						
						
						
						
						
					}else if (column==1){
//						ligneActuelle.setEtat(cell.getStringCellValue());
						localiteActuelle = localiteDAO.findByCode(cell.getStringCellValue());
						
//						ligneActuelle.setCode(cell.getStringCellValue());
						
//						for(int j = 0 ; j<listeLigneImport.size(); j++){
//							if(cell.getStringCellValue().equals(listeLigneImport.get(j).getCode())){
//								exists=true;
//								System.out.println("index : "+numLigne + " cellule :"+ cell.getStringCellValue()+ " code :" + listeLigneImport.get(j).getCode() + " existant :"+j);
//							}
//						}
						
						
					}else if (column==2){
//						ligneActuelle.setFrais((float) cell.getNumericCellValue());
						try{
							numeroActuel = String.valueOf(cell.getRawValue());
							}catch (Exception e) {
								System.out.println("e");
							}
						numeroActuel.replace(" ","");
						if(numeroActuel.startsWith("5")){
							
							existNumero = false;
							for (int i = 0 ; i< listeNumero.size() ; i++ ){
								if(numeroActuel.equals(listeNumero.get(i))){
									existNumero = true;
									System.out.println("numéro dupliqué : " + numeroActuel + "index :" + rowIt);
								}
								
								
							}
							if(!existNumero){
								
								listeNumero.add(numeroActuel);
								
							ligneActuelle = new Ligne();
							ligneActuelle.setDateCreation(new Date(01-01-2001));
							ligneActuelle.setEtat(0);
//							ligneActuelle.setForfait(forfaitFix);
							ligneActuelle.setLocalite(localiteActuelle);
							ligneActuelle.setNumero(numeroActuel);
							listeLigneImport.add(ligneActuelle);
							}
						}
					}else if (column==6){
//						ligneActuelle.setFrais((float) cell.getNumericCellValue());
						try{
						numeroActuel = String.valueOf(cell.getRawValue());
						}catch (Exception e) {
							System.out.println("e");
						}
						numeroActuel.replace(" ","");
						
						
						existNumero = false;
						for (int i = 0 ; i< listeNumero.size() ; i++ ){
							if(numeroActuel.equals(listeNumero.get(i))){
								existNumero = true;
								System.out.println("numéro dupliqué : " + numeroActuel);
							}
							
							
						}
						if(!existNumero){
							
							listeNumero.add(numeroActuel);
							
						if(numeroActuel.startsWith("5")){
							ligneActuelle = new Ligne();
							ligneActuelle.setDateCreation(new Date(01-01-2001));
							ligneActuelle.setEtat(0);
//							ligneActuelle.setForfait(forfaitFax);
							ligneActuelle.setLocalite(localiteActuelle);
							ligneActuelle.setNumero(numeroActuel);
							listeLigneImport.add(ligneActuelle);}
						}
					}else if (column==7){
//						ligneActuelle.setFrais((float) cell.getNumericCellValue());
						
						try{
							numeroActuel = String.valueOf(cell.getRawValue());
							}catch (Exception e) {
								System.out.println("e");
							}
						numeroActuel.replace(" ","");
						
						
						
						existNumero = false;
						for (int i = 0 ; i< listeNumero.size() ; i++ ){
							if(numeroActuel.equals(listeNumero.get(i))){
								existNumero = true;
								System.out.println("numéro dupliqué : " + numeroActuel);
							}
							
							
						}
						if(!existNumero){
							
							listeNumero.add(numeroActuel);
							
						if(numeroActuel.startsWith("6")){
							ligneActuelle = new Ligne();
							ligneActuelle.setDateCreation(new Date(01-01-2001));
							ligneActuelle.setEtat(0);
//							ligneActuelle.setForfait(forfaitGSMPro);
							ligneActuelle.setLocalite(localiteActuelle);
							ligneActuelle.setNumero(numeroActuel);
							
							//duplicate ...
							
							
							
							listeLigneImport.add(ligneActuelle);
						}}
					}
						
					}
					column++;
				}
				
//				System.out.println(ligneActuelle);
//				if(numLigne>0 && !exists){
//				listeLigneImport.add(ligneActuelle);
//				}
				numLigne++;
				column=0;
				indexLigne++;
				}
			
			System.out.println(listeLigneImport);
			
			LigneDAO ligneDAO = new LigneDAO();
			ligneDAO.insertListLigne(listeLigneImport);
			
			} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("e");
			} catch (IOException e) {
			e.printStackTrace();
			System.out.println("e");
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("e");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("e");
			}
		 
		
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/accueil.jsp") ;
//		requestDispatcher.forward(request, response);
		
	}

}
