package org.dr.Controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

/**
 * Servlet implementation class DownloadController
 */
@WebServlet("/board/download")
public class DownloadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("go 컨트롤러 수정");
		System.out.println("go 컨트롤러 수정");
		System.out.println("go 컨트롤러 수정");
		System.out.println("go 컨트롤러 수정");
		System.out.println("go 컨트롤러 수정");
		System.out.println("go 컨트롤러 수정");
		System.out.println("go 컨트롤러 수정");
		System.out.println("go 컨트롤러 수정");
		System.out.println("go 컨트롤러 수정");
		System.out.println("go 컨트롤러 수정");
		System.out.println("go 컨트롤러 수정");
		System.out.println("go 컨트롤러 수정");

		String fname = request.getParameter("fname");
		System.out.println("fname: " + fname);
		
		OutputStream os = response.getOutputStream();
		
		File file = new File("C:\\zzz\\upload\\" + fname);
		
		System.out.println("path: " + path);

		String mineType = Files.probeContentType(path);
		
		fname = new String(fname.getBytes("UTF-8"), "8859_1");

		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=" + fname + ";");

		System.out.println(mineType);

		FileUtils.copyFile(file, os);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
