package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

/**
 * Servlet implementation class TestUploadFile
 */
@WebServlet("/TestUploadFile")
public class ZTestUploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private final String UPLOAD_DIRECTORY = "C:/Users/zsamouh/Desktop/testUploadFile";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZTestUploadFile() {
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
						item.write(new File(UPLOAD_DIRECTORY + File.separator
								+ fname));
					}
				}
				// File uploaded successfully
				request.setAttribute("message", "File Uploaded Successfully");
				request.setAttribute("name", fname);
				request.setAttribute("size", fsize);
				request.setAttribute("type", ftype);
				
				String filename = "Facture.xlsx";   
				  String filepath = UPLOAD_DIRECTORY;   
				  response.setContentType("APPLICATION/OCTET-STREAM");   
				  response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");   
				  
				  FileInputStream fileInputStream = new FileInputStream(filepath + filename);  
//				  int i;   
//				  while ((i=fileInputStream.read()) != -1) {  
//				    out.write(i);   
//				  }   
				  fileInputStream.close();   
				
				
				
				OutputStream out = response.getOutputStream();
				FileInputStream in = new FileInputStream(UPLOAD_DIRECTORY + "/Facture.xlsx");
				byte[] buffer = new byte[4096];
				int length;
				while ((length = in.read(buffer)) > 0){
				    out.write(buffer, 0, length);
				}
				in.close();
				out.flush();
				
			} catch (Exception ex) {
				request.setAttribute("message", "File Upload Failed due to "
						+ ex);
			}
 
		} else {
			request.setAttribute("message",
					"Sorry this Servlet only handles file upload request");
		}
 
		
		
		
		
		
		
		
		
		
		
//		request.getRequestDispatcher("/TestResultUploadFile.jsp").forward(request, response);
		
		
		
	}

}
