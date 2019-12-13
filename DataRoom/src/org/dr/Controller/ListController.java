package org.dr.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dr.dao.BoardDAO;
import org.dr.dao.BoardDAOImpl;
import org.dr.dto.PageMaker;
import org.dr.dto.PagingDTO;

/**
 * Servlet implementation class ListController
 */
@WebServlet("/board/list")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BoardDAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListController() {
		super();
		dao = new BoardDAOImpl();
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("List..............");

		// 1. 파라미터 수집 (page, amount)
		PagingDTO dto = new PagingDTO(request.getParameter("page"), request.getParameter("amount"));

		// 2. dao에서 결과 데이터 가져옴
		// 게시물 목록 데이터
		request.setAttribute("list", dao.getList(dto));
		// 하단 페이징 처리 데이터
		request.setAttribute("pm", new PageMaker(dao.getCount(), dto));
		System.out.println(new PageMaker(dao.getCount(), dto));

		// 3. 화면 이동 (foward 방식)
		request.getRequestDispatcher("../WEB-INF/views/board/list.jsp").forward(request, response);

		System.out.println("list GET...................");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
