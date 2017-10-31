package servlet;

//import hibernateEntity.Facture;
//import hibernateEntity.dao.FactureDAO;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.File;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import org.apache.xmlbeans.impl.xb.xsdschema.PatternDocument.Pattern;

import staticReference.PathStatic;
import staticReference.TaxeStatic;
import entite.Forfait;
import entite.LiaisonTypeForfait;
import entite.Ligne;
import entite.Type;
import entite.dao.LiaisonTypeForfaitDAO;
import entite.dao.LigneDAO;

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

	private List<Ligne> getListeLigneFacture(HttpServletRequest request, int indexNumeroLigne, int indexTarif, String fileName, String fileUpload) throws FileUploadException {
		
		List<Ligne> listeLigneImport = new ArrayList<Ligne>();
		Ligne ligneActuelle = new Ligne();
		Type typeActuel = new Type();
		
		
		
		int column=0;
		int indexLigne = 0;
		String numeroLigne="";
		
		try {
			XSSFWorkbook wb = new XSSFWorkbook(new File(PathStatic.UploadPath+"/"+fileName));
			
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
				typeActuel = new Type();
				
				for (Iterator cellIt = row.cellIterator(); cellIt.hasNext();) {
					
					if(column>indexTarif && column>indexNumeroLigne){
						break;
					}
					if(numLigne>0){
					cell = (XSSFCell) cellIt.next();
					if(column==indexNumeroLigne){
						try{
						numeroLigne =cell.getStringCellValue().replace(" ", "");
						} catch (Exception ex){
//							numeroLigne =String.valueOf(cell.getNumericCellValue());
							numeroLigne =  new BigDecimal(cell.getNumericCellValue())+"";
							
						}
						if(numeroLigne.startsWith("212")){
//							numeroLigne = numeroLigne.replaceFirst("212", "");
						}
						if( numeroLigne.startsWith("05")){
							numeroLigne = numeroLigne.replaceFirst("05", "2125");
						}else if(numeroLigne.startsWith("06")){
							numeroLigne = numeroLigne.replaceFirst("06", "2126");
						}else if(numeroLigne.startsWith("5")){
							numeroLigne = numeroLigne.replaceFirst("5", "2125");
						}else if(numeroLigne.startsWith("6")){
							numeroLigne = numeroLigne.replaceFirst("6", "2126");
						}
						
						System.out.println("=");
						System.out.println(numeroLigne);
						ligneActuelle.setNumero(numeroLigne);
						ligneActuelle.setId(numLigne);
					}else if (column==indexTarif){
						typeActuel.setCout(new Float(cell.getNumericCellValue()));
						ligneActuelle.setType(typeActuel);
						
					}
						
					}
					column++;
				}
				
				System.out.println(ligneActuelle);
				if(numLigne>0){
				if(numeroLigne!=null)
				listeLigneImport.add(ligneActuelle);
				}
				numLigne++;
				column=0;
				indexLigne++;
}
		// TODO Auto-generated method stub
		return listeLigneImport;
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
	return null;	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String fileName="";
		int indexNumeroLigne=0;
		int indexTarif=0;
		String fileUpload="";
		
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				String fname = null;
				String fsize = null;
				String ftype = null;
				List<FileItem> multiparts = new ServletFileUpload(
						new DiskFileItemFactory()).parseRequest(new ServletRequestContext(request));
				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						fname = new File(item.getName()).getName();
						fsize = new Long(item.getSize()).toString();
						ftype = item.getContentType();
						item.write(new File("C:/Users/zsamouh/Desktop/testUploadFile" + File.separator
								+ fname));
						System.out.println(fname);
					}else {
						String fieldName = item.getFieldName();
					    String value = item.getString();
					    if(fieldName.equals("combo")){
					    	indexNumeroLigne=Integer.parseInt(value);
					    }else if(fieldName.equals("tarif")){
					    	indexTarif=Integer.parseInt(value);
					    }else if(fieldName.equals("fileName")){
					    	fileUpload=value;
					    } 
					}
				}
				
				System.out.println(indexNumeroLigne);//combo
				System.out.println(indexTarif);//tarif
				System.out.println(fileUpload);//excelfile
				// File uploaded successfully
				request.setAttribute("message", "File Uploaded Successfully");
				request.setAttribute("name", fname);
				request.setAttribute("size", fsize);
				request.setAttribute("type", ftype);
				
				fileName = fname;
				
			} catch (Exception ex) {
				request.setAttribute("message", "File Upload Failed due to "
						+ ex);
			}
 
		} else {
			request.setAttribute("message",
					"Sorry this Servlet only handles file upload request");
		}
		
		
		
		
		
		
		boolean existFacture = false;
		boolean existParc = false;
		
		List<Ligne> listeLigneParc = new ArrayList<Ligne>();
		List<Ligne> listeLigneFacture = new ArrayList<Ligne>();
		List<Ligne> listeLigneFactureInitial = new ArrayList<Ligne>();
		
		
		List<Ligne> listeLigneExistant = new ArrayList<Ligne>();
		List<Ligne> listeLigneNonExistant = new ArrayList<Ligne>();
		
		List<Ligne> listeLigneNonFacture = new ArrayList<Ligne>();
		List<Ligne> listeLigneNonTraite = new ArrayList<Ligne>();
		
		
		LigneDAO ligneDAO = new LigneDAO();
		listeLigneParc = ligneDAO.findAll();
		
//		this.fileUpload(request);
		try {
			listeLigneFactureInitial = getListeLigneFacture(request, indexNumeroLigne, indexTarif, fileName, fileUpload);
		} catch (FileUploadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
//		String fileName = request.getParameter("fileName");
		Ligne ligneActuelle = new Ligne();
		
		//
		ligneActuelle.setId(0);
		listeLigneNonTraite.add(ligneActuelle);
		
		Ligne ligneSuivante = new Ligne();
		float coutParc=0;
		float coutFacture=0;
		float difference = 0 ;
		String numeroLigne = "";
		
		for(int i = 0 ; i <  listeLigneFactureInitial.size() ; i++){
			
			ligneActuelle = listeLigneFactureInitial.get(i);
			numeroLigne = ligneActuelle.getNumero();
			
			if(numeroLigne==null){
				listeLigneNonTraite.add(ligneActuelle);
			}else if(!numeroLigne.startsWith("05") && !numeroLigne.startsWith("06") && !numeroLigne.startsWith("5") && !numeroLigne.startsWith("6") && !numeroLigne.startsWith("212")){
				System.out.println("------------------------------------------------------");
				System.out.println("------------------------------------------------------");
				listeLigneNonTraite.add(ligneActuelle);
//				listeLigneFacture.remove(i);
			}else{
				listeLigneFacture.add(listeLigneFactureInitial.get(i));
				System.out.println("------------------------------------------------------");
				System.out.println(numeroLigne);
			}
			
			
		}
		
		for(int i = 0 ; i <  listeLigneFacture.size() ; i++){
			
			
			
			existFacture = false;
			for(int j = 0 ; j <  listeLigneParc.size() ; j++){
				
				
				
				if(listeLigneFacture.get(i).getNumero().replace(" ", "").compareTo(listeLigneParc.get(j).getNumero().replace(" ", ""))==0){
					existFacture=true;
					listeLigneExistant.add(listeLigneFacture.get(i));
					listeLigneExistant.add(listeLigneParc.get(j));
				}
			}
			if(!existFacture){
				listeLigneNonExistant.add(listeLigneFacture.get(i));
			}
		}
		
		for(int j = 0 ; j <  listeLigneParc.size() ; j++){
			existParc=false;
			for(int i = 0 ; i <  listeLigneExistant.size() ; i++){
				if(listeLigneExistant.get(i).getNumero().equals(listeLigneParc.get(j).getNumero())){
					existParc=true;
				}
			}
			if(!existParc){
				listeLigneNonFacture.add(listeLigneParc.get(j));
			}
		}
		
		
		
		
		
		
		
		// Ligne Existante
		
		
		
		
//		List<Ligne> listeLigneExistant = new ArrayList<Ligne>();
//		List<Ligne> listeLigneNonExistant = new ArrayList<Ligne>();
//		
//		List<Ligne> listeLigneNonFacture = new ArrayList<Ligne>();
		
		float coutGlobal = (float)0;
		LiaisonTypeForfaitDAO liaisonTypeForfaitDAO = new LiaisonTypeForfaitDAO();
		List<LiaisonTypeForfait> listeLiaisonTypeForfait = new ArrayList<LiaisonTypeForfait>();
		
		listeLiaisonTypeForfait = liaisonTypeForfaitDAO.findAll();
		
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("Ligne Existante");
		XSSFRow row ;
		
		
		
		row = sheet.createRow(0);
		
		row.createCell((short)0).setCellValue("Numéro ligne");
		row.createCell((short)1).setCellValue("Cout Parc");
		row.createCell((short)2).setCellValue("Cout Facture");
		row.createCell((short)3).setCellValue("Remarque");
		
		row.createCell((short)4).setCellValue("Type");
		
		
		for(int indexLigneExistant = 0 ; indexLigneExistant<listeLigneExistant.size() ;indexLigneExistant = indexLigneExistant+2 ){
			
			
					
							
			ligneActuelle = listeLigneExistant.get(indexLigneExistant);
			ligneSuivante = listeLigneExistant.get(indexLigneExistant+1);
							
							
							row = sheet.createRow((indexLigneExistant+2)/2);
							
							row.createCell((short)0).setCellValue(ligneActuelle.getNumero());
							
							// TODO get ligne from parc
							
							
							// TODO  get distinct list
							coutGlobal = (float) 0;
							for (int indexType = 0 ; indexType < listeLiaisonTypeForfait.size() ; indexType++){
								
								if(ligneSuivante.getType().getId().compareTo(listeLiaisonTypeForfait.get(indexType).getType().getId())==0){
									
									coutGlobal = coutGlobal + listeLiaisonTypeForfait.get(indexType).getForfait().getCout();
								}
								
							}
							coutParc = coutGlobal * TaxeStatic.TAXE;
							
//							coutParc = ligneSuivante.getForfait().getCout()+ligneSuivante.getForfait().getType().getCout();
							
							row.createCell((short)1).setCellValue(coutParc);
							
							coutFacture = ligneActuelle.getType().getCout();
							row.createCell((short)2).setCellValue(coutFacture);
							
							
							
							
							difference = coutFacture - coutParc;
							row.createCell((short)3).setCellValue(difference);
							
							if(difference>0){
								XSSFCellStyle csCouleur = wb.createCellStyle();
//							csCouleur.setFillForegroundColor(new XSSFColor(new Color(194, 154, 250)));
							csCouleur.setFillForegroundColor(IndexedColors.PINK.getIndex());
//							csCouleur.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
							
							csCouleur.setFillPattern(FillPatternType.SOLID_FOREGROUND);
							//appliquer le style à la cellule 3
							row.getCell(3).setCellStyle(csCouleur);
							
//							System.out.println(listeFacture.get(f).getLigne().getNumeroLigne()+"rouge");
							}
//							row.createCell((short)4).setCellValue(ligneActuelle.getType().getCode());
							row.createCell((short)4).setCellValue(ligneSuivante.getType().getCode());
		}
							
							
							
// Ligne Non Existante
							
							
							sheet = wb.createSheet("Ligne Non Existante");
							
							row = sheet.createRow(0);
							
							row.createCell((short)0).setCellValue("Numéro ligne");
//							row.createCell((short)1).setCellValue("Cout Parc");
							row.createCell((short)1).setCellValue("Cout Facture");
//							row.createCell((short)3).setCellValue("Remarque");
							
							
							for(int indexLigneNonExistant = 0 ; indexLigneNonExistant<listeLigneNonExistant.size() ;indexLigneNonExistant++){
								
								
										
												
								ligneActuelle = listeLigneNonExistant.get(indexLigneNonExistant);
//								ligneSuivante = listeLigneExistant.get(indexLigneExistant+1);
												
												
												row = sheet.createRow(indexLigneNonExistant+1);
												
												row.createCell((short)0).setCellValue(ligneActuelle.getNumero());
												
												// TODO get ligne from parc
//												coutParc = ligneSuivante.getForfait().getCout()+ligneSuivante.getForfait().getType().getCout();
//												row.createCell((short)1).setCellValue(coutParc);
												
												coutFacture = ligneActuelle.getType().getCout();
												row.createCell((short)1).setCellValue(coutFacture);
												
												
//												difference = coutFacture - coutParc;
//												row.createCell((short)3).setCellValue(difference);
												
//												if(difference>0){
													XSSFCellStyle csCouleur = wb.createCellStyle();
//												csCouleur.setFillForegroundColor(new XSSFColor(new Color(194, 154, 250)));
												csCouleur.setFillForegroundColor(IndexedColors.PINK.getIndex());
//												csCouleur.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
												
												csCouleur.setFillPattern(FillPatternType.SOLID_FOREGROUND);
												//appliquer le style à la cellule 3
												row.getCell(1).setCellStyle(csCouleur);
												
//												System.out.println(listeFacture.get(f).getLigne().getNumeroLigne()+"rouge");
//												}
							
//							}
							}
							
							
							
							
							
							
							
// Ligne Non Facturée
							
							
							sheet = wb.createSheet("Ligne Non Facturée");
							
							row = sheet.createRow(0);
							
							row.createCell((short)0).setCellValue("Numéro ligne");
//							row.createCell((short)1).setCellValue("Cout Parc");
							row.createCell((short)1).setCellValue("Cout Parc");
							row.createCell((short)2).setCellValue("Type");
							
							
							for(int indexLigneNonFacture = 0 ; indexLigneNonFacture<listeLigneNonFacture.size() ;indexLigneNonFacture++){
								
								
										
												
								ligneActuelle = listeLigneNonFacture.get(indexLigneNonFacture);
//								ligneSuivante = listeLigneExistant.get(indexLigneExistant+1);
												
												
												row = sheet.createRow(indexLigneNonFacture+1);
												
												row.createCell((short)0).setCellValue(ligneActuelle.getNumero());
												
												
												
												// TODO get ligne from parc
//												coutParc = ligneActuelle.getForfait().getCout()+ligneActuelle.getForfait().getType().getCout();
//												row.createCell((short)1).setCellValue(coutParc);
												
												
												coutGlobal = (float) 0;
												for (int indexType = 0 ; indexType < listeLiaisonTypeForfait.size() ; indexType++){
													
													if(ligneActuelle.getType().getId().compareTo(listeLiaisonTypeForfait.get(indexType).getType().getId())==0){
														
														coutGlobal = coutGlobal + listeLiaisonTypeForfait.get(indexType).getForfait().getCout();
													}
													
												}
												coutParc = coutGlobal * (float) TaxeStatic.TAXE;
												
												row.createCell((short)1).setCellValue(coutParc);
												
//												coutFacture = ligneActuelle.getForfait().getCout();
//												row.createCell((short)1).setCellValue(coutFacture);
												
												
//												difference = coutFacture - coutParc;
//												row.createCell((short)3).setCellValue(difference);
												
//												if(difference>0){
													XSSFCellStyle csCouleur = wb.createCellStyle();
//												csCouleur.setFillForegroundColor(new XSSFColor(new Color(194, 154, 250)));
												csCouleur.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
//												csCouleur.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
												
												csCouleur.setFillPattern(FillPatternType.SOLID_FOREGROUND);
												//appliquer le style à la cellule 3
												row.getCell(1).setCellStyle(csCouleur);
												
//												System.out.println(listeFacture.get(f).getLigne().getNumeroLigne()+"rouge");
//												}
							
//							}
												
												row.createCell((short)2).setCellValue(ligneActuelle.getType().getCode());
							}
							
						
							
							
// Liste ligne non traitée
							
							
							
//							sheet = wb.createSheet("Ligne Non Traitée");
//							
//							row = sheet.createRow(0);
//							
//							row.createCell((short)0).setCellValue("Numéro ligne");
////							row.createCell((short)1).setCellValue("Cout Parc");
//							row.createCell((short)1).setCellValue("Cout Facture");
////							row.createCell((short)3).setCellValue("Remarque");
//							
//							
//							for(int indexLigneNonTraite = 0 ; indexLigneNonTraite<listeLigneNonTraite.size() ;indexLigneNonTraite++){
//								
//								
//										
//												
//								ligneActuelle = listeLigneNonTraite.get(indexLigneNonTraite);
////								ligneSuivante = listeLigneExistant.get(indexLigneExistant+1);
//												
//												
//												row = sheet.createRow(indexLigneNonTraite+1);
//												
//												row.createCell((short)0).setCellValue(ligneActuelle.getNumero());
//												
////												// TODO get ligne from parc
////												coutParc = ligneActuelle.getForfait().getCout()+ligneActuelle.getForfait().getType().getCout();
////												row.createCell((short)1).setCellValue(coutParc);
//												
//												coutFacture = ligneActuelle.getType().getCout();
//												row.createCell((short)1).setCellValue(coutFacture);
//												
//												
////												difference = coutFacture - coutParc;
////												row.createCell((short)3).setCellValue(difference);
//												
////												if(difference>0){
//													XSSFCellStyle csCouleur = wb.createCellStyle();
////												csCouleur.setFillForegroundColor(new XSSFColor(new Color(194, 154, 250)));
//												csCouleur.setFillForegroundColor(IndexedColors.BLUE.getIndex());
////												csCouleur.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
//												
//												csCouleur.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//												//appliquer le style à la cellule 3
//												row.getCell(1).setCellStyle(csCouleur);
//												
////												System.out.println(listeFacture.get(f).getLigne().getNumeroLigne()+"rouge");
////												}
//							
////							}
//							}
//							
							
//							}
//							
//							//TODO
//							//Rapprochement
//							//frais
//							//etat
//							
//							if(listeFacture.get(f).getLigne().getEtat().equals("0         ")){
//								
//								
//								/*changer la couleur de l'arrière plan*/
//								XSSFCellStyle csCouleur = wb.createCellStyle();
////								csCouleur.setFillForegroundColor(new XSSFColor(new Color(194, 154, 250)));
//								csCouleur.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
////								csCouleur.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
//								
//								csCouleur.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//								//appliquer le style à la cellule 3
//								row.getCell(4).setCellStyle(csCouleur);
//								
////								XSSFCellStyle csCouleur = wb.createCellStyle();
////								XSSFColor myColor = new XSSFColor(Color.RED);
////								csCouleur.setFillForegroundColor(myColor);
////								row.getCell(4).setCellStyle(csCouleur);
//								
//								
////								XSSFColor grey =new XSSFColor(new java.awt.Color(192,192,192));
////								csCouleur.setFillForegroundColor(grey);
////								row.getCell(4).setCellStyle(csCouleur);
//								
//								
//								System.out.println(listeFacture.get(f).getLigne().getNumeroLigne()+"jaune");
//							}else{
//							
//							int compareFrais = listeFacture.get(f).getLigne().getFrais().compareTo(listeFacture.get(f).getFrais());
//							
//							if(compareFrais<0){
//								
//								/*changer la couleur de l'arrière plan*/
//								XSSFCellStyle csCouleur = wb.createCellStyle();
////								csCouleur.setFillForegroundColor(new XSSFColor(new Color(194, 154, 250)));
//								csCouleur.setFillForegroundColor(IndexedColors.RED.getIndex());
////								csCouleur.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
//								
//								csCouleur.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//								//appliquer le style à la cellule 3
//								row.getCell(4).setCellStyle(csCouleur);
//								
//								System.out.println(listeFacture.get(f).getLigne().getNumeroLigne()+"rouge");
//								
//							}else if(compareFrais>0) {
//								
//								/*changer la couleur de l'arrière plan*/
//								XSSFCellStyle csCouleur = wb.createCellStyle();
////								csCouleur.setFillForegroundColor(new XSSFColor(new Color(194, 154, 250)));
//								csCouleur.setFillForegroundColor(IndexedColors.GREEN.getIndex());
////								csCouleur.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
//								
//								csCouleur.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//								//appliquer le style à la cellule 3
//								row.getCell(4).setCellStyle(csCouleur);
//								
//								System.out.println(listeFacture.get(f).getLigne().getNumeroLigne()+"vert");
//								
//							}else{
//								
//								System.out.println(listeFacture.get(f).getLigne().getNumeroLigne()+"nada");
//								
//							}
							
//						}
//					}
						
//					}
//				}
//			}
							if(listeLigneNonTraite.get(listeLigneNonTraite.size()-1).getNumero()==null)
							listeLigneNonTraite.remove(listeLigneNonTraite.size()-1);
							try {
								XSSFWorkbook wbSource = new XSSFWorkbook(new File(PathStatic.UploadPath+"/"+fileName));
								sheet = wb.createSheet("Factures Non traitées");
								XSSFSheet sheetSource = wbSource.cloneSheet(0);
								XSSFRow rowSource = null;
								XSSFCell cellSource = null;
								int indexLignePointe = 0;
								int indexColonnePointe = 0;
								boolean copy = false;
								
								for (Iterator rowIt = sheetSource.rowIterator(); rowIt.hasNext();) {
									rowSource = (XSSFRow) rowIt.next();
									//vider les objets
									copy=false;
									row = sheet.createRow(indexLignePointe);
									indexColonnePointe = 0;
									for(int i = 0; i < listeLigneNonTraite.size() ;i++){
										
										
										if(rowSource.getRowNum()==listeLigneNonTraite.get(i).getId()){
											copy =true;
											
										}
										
									}
									if(!copy){
										
										continue;
									}
									for (Iterator cellIt = rowSource.cellIterator(); cellIt.hasNext();) {
										
										
										cellSource = (XSSFCell) cellIt.next();
										
										if(indexColonnePointe<20){
											
											try{
												cellSource.getStringCellValue();
												row.createCell((short)indexColonnePointe).setCellValue(cellSource.getStringCellValue());
//												row.getCell((short)indexColonnePointe).setCellStyle(cellSource.getCellStyle());
											}catch (Exception e){
//												System.out.println("11111111111111111111111111111111111111111");
												System.out.println(e);
												cellSource.getNumericCellValue();
												row.createCell((short)indexColonnePointe).setCellValue(cellSource.getNumericCellValue());
//												row.getCell(indexColonnePointe).setCellStyle(cellSource.getCellStyle());
											}
											
										}else{
											break;
										}
										indexColonnePointe++;
										
									}
									indexLignePointe++;
								}
								
								
								
							} catch (InvalidFormatException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							
		
		
		
		FileOutputStream fileOut;
		try {
		fileOut = new FileOutputStream("C:/Users/zsamouh/Desktop/testUploadFile/"+fileUpload+".xlsx");
		wb.write(fileOut);
		fileOut.close(); 
		} catch (FileNotFoundException e) {
		e.printStackTrace();
		} catch (IOException e) {
		e.printStackTrace();
		}
		
		

		String filePath = "C:/Users/zsamouh/Desktop/testUploadFile/"+fileUpload+".xlsx";
        File downloadFile = new File(filePath);
        FileInputStream inStream = new FileInputStream(downloadFile);
         
        // if you want to use a relative path to context root:
        String relativePath = getServletContext().getRealPath("");
        System.out.println("relativePath = " + relativePath);
         
        // obtains ServletContext
        ServletContext context = getServletContext();
         
        // gets MIME type of the file
        String mimeType = context.getMimeType(filePath);
        if (mimeType == null) {        
            // set to binary type if MIME mapping not found
            mimeType = "application/octet-stream";
        }
        System.out.println("MIME type: " + mimeType);
         
        // modifies response
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());
         
        // forces download
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
        response.setHeader(headerKey, headerValue);
         
        // obtains response's output stream
        OutputStream outStream = response.getOutputStream();
         
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
         
        while ((bytesRead = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
         
        inStream.close();
        outStream.close();
		
		
		// redirection non requis
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/rapprochement.html") ;
//		requestDispatcher.forward(request, response);
		
	}

//	private void fileUpload(HttpServletRequest request) {
//		// TODO Auto-generated method stub
//		if (ServletFileUpload.isMultipartContent(request)) {
//			try {
//				String fname = null;
//				String fsize = null;
//				String ftype = null;
//				List<FileItem> multiparts = new ServletFileUpload(
//						new DiskFileItemFactory()).parseRequest(new ServletRequestContext(request));
//				for (FileItem item : multiparts) {
//					if (!item.isFormField()) {
//						fname = new File(item.getName()).getName();
//						fsize = new Long(item.getSize()).toString();
//						ftype = item.getContentType();
//						item.write(new File(PathStatic.UploadPath + File.separator
//								+ fname));
//					}
//				}
//				// File uploaded successfully
//				request.setAttribute("message", "File Uploaded Successfully");
//				request.setAttribute("name", fname);
//				request.setAttribute("size", fsize);
//				request.setAttribute("type", ftype);
//			} catch (Exception ex) {
//				request.setAttribute("message", "File Upload Failed due to "
//						+ ex);
//			}
// 
//		} else {
//			request.setAttribute("message",
//					"Sorry this Servlet only handles file upload request");
//		}
//	}

}