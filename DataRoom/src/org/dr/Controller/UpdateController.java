package org.dr.Controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;
import org.dr.dao.BoardDAO;
import org.dr.dao.BoardDAOImpl;
import org.dr.domain.BoardVO;
import org.dr.util.StringToLong;

import lombok.extern.log4j.Log4j;

/**
 * Servlet implementation class UpdateController
 */
//수정
@Log4j
@MultipartConfig(maxFileSize = 1024*1024*10, maxRequestSize = 1024*1024*50,fileSizeThreshold = 1024*1024, location = "c:\\zzz")
@WebServlet("/board/update")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    BoardDAO dao;   
    
    public UpdateController() {
    	dao = new BoardDAOImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pramBno = request.getParameter("bno");
		Long bno = StringToLong.getLong(pramBno);
		System.out.println("bno : "+bno);
		request.setAttribute("board", dao.selectOne(bno));
		request.setAttribute("bno", bno);
		request.getRequestDispatcher("../WEB-INF/views/board/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("-----------------------------------------------update");
		//1. 수정한 내용들 파라미터
		String mem_title = request.getParameter("mem_title");
		String mem_content = request.getParameter("mem_content");
		String bno1 = request.getParameter("bno");
		String page = request.getParameter("page");
		String amount = request.getParameter("amount");
		System.out.println(mem_title);
		String[] fileNames = request.getParameterValues("file_fn");
		System.out.println(Arrays.deepToString(fileNames));
		BoardVO vo = new BoardVO();
		if(fileNames!=null) 
		{
			for(int i = 0; i<fileNames.length;i++) {
				dao.deleteFile(fileNames[i]);
			}
		}
		
		//1. parts별로 나눠온 파일을 받는다.
		Collection<Part> parts = request.getParts();
		//2. 받아온 파일을 for문을 돌려서 inputStream으로 담고 출력하기
		for(Part part : parts) {
			System.out.println("fileName : "+part.getSubmittedFileName()+" size : "+part.getSize()+" conentType: "+part.getContentType());
			System.out.println(part.getSubmittedFileName()); //업로드 된 파일이름
			System.out.println(part.getSize()); //파일의 사이즈
			if(part.getName().equals("fs")==false) {
				continue;
			}
			try{
				InputStream in = part.getInputStream();
				//file 객체 생성
				String fname = part.getSubmittedFileName();
				
				if(fname.trim().length() == 0) {
					continue;
				}
				
				String saveName = System.currentTimeMillis() + "_" + fname;
				File file = new File("c:\\zzz\\upload",saveName);
				FileUtils.copyInputStreamToFile(in, file);
				vo.addFileName(saveName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		log.info("sssssssssssssssssssssssssssssssssss : "+request.getParameter("page"));
		
		Long bno = StringToLong.getLong(bno1);
		vo.setBno(bno);
		vo.setTitle(mem_title);
		vo.setContent(mem_content);
		dao.update(vo);
	
		response.sendRedirect("/board/read?bno="+bno+"&page="+page+"&amount="+amount);
	}
	

}
