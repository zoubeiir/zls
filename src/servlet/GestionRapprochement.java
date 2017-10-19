package servlet;

import hibernateEntity.Facture;
import hibernateEntity.dao.FactureDAO;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.PatternDocument.Pattern;

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
		
		String listTypeRapprochement[] = request.getParameterValues("typeRapprochement");
		String listMois[] = request.getParameterValues("mois");
		String listAnnee[] = request.getParameterValues("annee");
		String fileName = request.getParameter("fileName");
		
		Facture factureActuelle = new Facture();
		
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet(fileName);
		XSSFRow row ;
		
		row = sheet.createRow(0);
		
		row.createCell((short)0).setCellValue("ID facture");
		row.createCell((short)1).setCellValue("Numéro ligne");
		row.createCell((short)2).setCellValue("Mois");
		row.createCell((short)3).setCellValue("Année");
		row.createCell((short)4).setCellValue("Frais factué");
		row.createCell((short)5).setCellValue("Frais ligne");
		
		FactureDAO factureDAO = new FactureDAO();
		List<Facture> listeFacture = new ArrayList<Facture>();
		
		for(int typeRapprochement = 0 ; typeRapprochement<listTypeRapprochement.length ;typeRapprochement++ ){
			
			for(int annee = 0 ; annee < listAnnee.length ; annee++ ){
				
				for(int mois = 0 ; mois < listMois.length ; mois++ ){
					listeFacture = factureDAO.findByMoisAnnee(listMois[mois],listAnnee[annee]);
					if(listeFacture!=null){
						for(int f = 0 ; f < listeFacture.size() ; f++ ){
							
							factureActuelle = listeFacture.get(f);
							
							
							row = sheet.createRow(f+1);
							
							row.createCell((short)0).setCellValue(factureActuelle.getIdFacture());
							row.createCell((short)1).setCellValue(factureActuelle.getLigne().getNumeroLigne());
							row.createCell((short)2).setCellValue(factureActuelle.getMois());
							row.createCell((short)3).setCellValue(factureActuelle.getAnnee());
							row.createCell((short)4).setCellValue(factureActuelle.getFrais());
							row.createCell((short)5).setCellValue(factureActuelle.getLigne().getFrais());
							
							
							//TODO
							//Rapprochement
							//frais
							//etat
							
							if(listeFacture.get(f).getLigne().getEtat().equals("0         ")){
								
								
								/*changer la couleur de l'arrière plan*/
								XSSFCellStyle csCouleur = wb.createCellStyle();
//								csCouleur.setFillForegroundColor(new XSSFColor(new Color(194, 154, 250)));
								csCouleur.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
//								csCouleur.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
								
								csCouleur.setFillPattern(FillPatternType.SOLID_FOREGROUND);
								//appliquer le style à la cellule 3
								row.getCell(4).setCellStyle(csCouleur);
								
//								XSSFCellStyle csCouleur = wb.createCellStyle();
//								XSSFColor myColor = new XSSFColor(Color.RED);
//								csCouleur.setFillForegroundColor(myColor);
//								row.getCell(4).setCellStyle(csCouleur);
								
								
//								XSSFColor grey =new XSSFColor(new java.awt.Color(192,192,192));
//								csCouleur.setFillForegroundColor(grey);
//								row.getCell(4).setCellStyle(csCouleur);
								
								
								System.out.println(listeFacture.get(f).getLigne().getNumeroLigne()+"jaune");
							}else{
							
							int compareFrais = listeFacture.get(f).getLigne().getFrais().compareTo(listeFacture.get(f).getFrais());
							
							if(compareFrais<0){
								
								/*changer la couleur de l'arrière plan*/
								XSSFCellStyle csCouleur = wb.createCellStyle();
//								csCouleur.setFillForegroundColor(new XSSFColor(new Color(194, 154, 250)));
								csCouleur.setFillForegroundColor(IndexedColors.RED.getIndex());
//								csCouleur.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
								
								csCouleur.setFillPattern(FillPatternType.SOLID_FOREGROUND);
								//appliquer le style à la cellule 3
								row.getCell(4).setCellStyle(csCouleur);
								
								System.out.println(listeFacture.get(f).getLigne().getNumeroLigne()+"rouge");
								
							}else if(compareFrais>0) {
								
								/*changer la couleur de l'arrière plan*/
								XSSFCellStyle csCouleur = wb.createCellStyle();
//								csCouleur.setFillForegroundColor(new XSSFColor(new Color(194, 154, 250)));
								csCouleur.setFillForegroundColor(IndexedColors.GREEN.getIndex());
//								csCouleur.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
								
								csCouleur.setFillPattern(FillPatternType.SOLID_FOREGROUND);
								//appliquer le style à la cellule 3
								row.getCell(4).setCellStyle(csCouleur);
								
								System.out.println(listeFacture.get(f).getLigne().getNumeroLigne()+"vert");
								
							}else{
								
								System.out.println(listeFacture.get(f).getLigne().getNumeroLigne()+"nada");
								
							}
							
						}
					}
						
					}
				}
			}
		}
		
		
		
		
		
		
		
		FileOutputStream fileOut;
		try {
		fileOut = new FileOutputStream("C:/Users/zsamouh/Desktop/rapprochement.xlsx");
		wb.write(fileOut);
		fileOut.close(); 
		} catch (FileNotFoundException e) {
		e.printStackTrace();
		} catch (IOException e) {
		e.printStackTrace();
		}
		
		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/rapprochement.html") ;
		requestDispatcher.forward(request, response);
		
	}

}
