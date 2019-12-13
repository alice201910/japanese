package org.dr.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dr.dao.BoardDAO;
import org.dr.dao.BoardDAOImpl;

/**
 * Servlet implementation class DeleteController
 */
@WebServlet("/board/delete")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private BoardDAO dao;
    
	
	public DeleteController() {
		dao = new BoardDAOImpl();
		
		System.out.println("영잘알 김승원~");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long bno = Long.parseLong(request.getParameter("bno"));
		long page = Long.parseLong(request.getParameter("page"));
		long amount = Long.parseLong(request.getParameter("amount"));
		request.setAttribute("delete", dao.delete(bno));
//		request.getRequestDispatcher("/WEB-INF/views/board/delete.jsp").forward(request, response);
		
		response.sendRedirect("/board/list?page="+page+"&amount="+amount);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
