package org.dr.Controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Enumeration;

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

import lombok.extern.log4j.Log4j;

/**
 * Servlet implementation class CreatController
 */
//삽입
@Log4j
@WebServlet("/board/create")
@MultipartConfig(maxFileSize = 1024*1024*10, maxRequestSize = 1024*1024*50,fileSizeThreshold = 1024*1024, location = "c:\\zzz")
public class CreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BoardDAO dao;
	public CreateController() {
		dao = new BoardDAOImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/board/insert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. view에서 전해준 파라미터를 받는다.
		Enumeration<String> params = request.getParameterNames();
    	String[] values = new String[10];
    	BoardVO vo = new BoardVO();
    	int i =0;
		while (params.hasMoreElements()) {
			String name = (String) params.nextElement();
			values[i] = request.getParameter(name);
			System.out.println(values[i]);
			i++;
		}
		log.info(request.getParameter("hashtag"));
		String hashtag = request.getParameter("hashtag");
		vo.setTitle(values[0]);
		vo.setContent(values[1]);
		vo.setWriter(values[2]);
		vo.setHashtag(hashtag);
		//2. 파일 업로드
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
		
		//3. vo에 넣는다.
		vo.setTitle(values[0]);
		vo.setContent(values[1]);
		vo.setWriter(values[2]);
		dao.insert(vo);
		System.out.println("!--------------------------------");
		System.out.println(vo);
		System.out.println("!--------------------------------");
		//데이터를 보낸다
		request.setAttribute("board", vo);
		response.sendRedirect("/board/list");
		
	}

}
