package org.dr.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dr.dao.BoardDAO;
import org.dr.dao.BoardDAOImpl;
import org.dr.domain.SearchVO;
import org.dr.dto.PageMaker;
import org.dr.dto.PagingDTO;
import org.dr.util.StringToLong;

import lombok.extern.log4j.Log4j;

/**
 * Servlet implementation class SearchController
 */
@Log4j
@WebServlet("/board/search")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BoardDAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchController() {
		dao = new BoardDAOImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("get����.........................");

		String type = request.getParameter("type");
		String keyword = request.getParameter("keyword");

		PagingDTO dto = new PagingDTO(request.getParameter("page"), request.getParameter("amount"));

		request.getRequestDispatcher("../WEB-INF/views/board/search.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void test() {
		System.out.println("기억이 나지 않습니다................................");
		System.out.println("기억이 나지 않습니다................................");
		System.out.println("기억이 나지 않습니다................................");
		System.out.println("기억이 나지 않습니다................................");
		System.out.println("기억이 나지 않습니다................................");
		System.out.println("기억이 나지 않습니다................................");
		System.out.println("기억이 나지 않습니다................................");
		

		// 헤헤
		for(int i=0; i<10; i++ ) {
			for(int j=0; j<10; j++) {
				
				System.out.println("~~~~~~~~~~~~~~~헤헤~~~~~~~~~~~~~~~");
				System.out.println("~~~~~~~~~~~~~~~헤헤~~~~~~~~~~~~~~~");
				System.out.println("~~~~~~~~~~~~~~~헤헤~~~~~~~~~~~~~~~");
				System.out.println("~~~~~~~~~~~~~~~헤헤~~~~~~~~~~~~~~~");
				
			}
			System.out.println();
		}
		
	}
	

}
