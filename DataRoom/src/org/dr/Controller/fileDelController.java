package org.dr.Controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dr.dao.BoardDAO;
import org.dr.dao.BoardDAOImpl;
import org.dr.domain.BoardVO;
import org.dr.util.StringToLong;

/**
 * Servlet implementation class fileDelController
 */
@WebServlet("/board/fileDel")
@MultipartConfig(maxFileSize = 1024*1024*10, maxRequestSize = 1024*1024*50,fileSizeThreshold = 1024*1024, location = "c:\\zzz")
public class fileDelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	BoardDAO dao;
	
    public fileDelController() {
       dao = new BoardDAOImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post..로 보냈..");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("welcome to ....");
		
		
		String[] fileNames = request.getParameterValues("file_fn");
		
		System.out.println(Arrays.deepToString(fileNames));
		
		
		
	}

}
