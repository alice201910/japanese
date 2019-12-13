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
		log.info("get탔음.........................");

		String type = request.getParameter("type");
		String keyword = request.getParameter("keyword");

		PagingDTO dto = new PagingDTO(request.getParameter("page"), request.getParameter("amount"));

		SearchVO vo = new SearchVO();

		vo.setType(type);
		vo.setKeyword(keyword);
		vo.setPaging(dto);

		log.info(vo);

		// --------------------------- 변경된 부분-----------------------------
		int searchCnt = dao.getSearchCount(vo);
		log.info("[Search Count] "+ dao.getSearchCount(vo));
		request.setAttribute("pm", new PageMaker(searchCnt, dto));
		request.setAttribute("list", dao.search(vo));
		request.setAttribute("keyword", keyword);
		request.setAttribute("type", type);
		request.setAttribute("searchCnt", searchCnt);
		// ---------------------------------------------------------------------

		request.getRequestDispatcher("../WEB-INF/views/board/search.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
