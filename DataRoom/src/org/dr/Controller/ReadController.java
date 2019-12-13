package org.dr.Controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dr.dao.BoardDAO;
import org.dr.dao.BoardDAOImpl;
import org.dr.util.StringToLong;

/**
 * Servlet implementation class ReadController
 */
@WebServlet("/board/read")
public class ReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//	BoardDAO dao = new BoardDAOImpl();
	private BoardDAO dao;
    
	
    public ReadController() {
    	dao = new BoardDAOImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bnos = request.getParameter("bno");
		Long bno = StringToLong.getLong(bnos);
		
		// 쿠키
		Cookie targetCookie = checkCookieExist(request, "RecentView");
		boolean existCookie = targetCookie != null;
		
		boolean already = checkCookieValue(targetCookie, request.getParameter("bno"), "%");

		System.out.println("targetCookie: " + targetCookie);
		System.out.println("already: " + already);

		if (already == false) {
			dao.updateViewCnt(bno);
		}
		
		request.setAttribute("read", dao.selectOne(bno));
		
		if (existCookie == false) {
			Cookie ck = new Cookie("RecentView", bno + "%");
			ck.setMaxAge(60 * 60 * 24); // a day
			ck.setPath("/board");
			response.addCookie(ck);
			System.out.println("신규쿠키발행");
		} else {// 있음
			String value = targetCookie.getValue();

			value += bno + "%";
			targetCookie.setValue(value);

			response.addCookie(targetCookie);
		}
		
		request.getRequestDispatcher("/WEB-INF/views/board/read.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected Cookie checkCookieExist(HttpServletRequest req, String cookieName) {
		//쿠키 생성
		Cookie[] cks = req.getCookies();
		//쿠키가 생성되지 않았으면 null
		if(cks == null || cks.length==0) {
			return null;
		}
		Optional<Cookie> result = Arrays.stream(cks)
				.filter(ck -> ck.getName().equals(cookieName)).findFirst();
		
		
		return result.isPresent()?result.get():null;
	}
	

	protected boolean checkCookieValue(Cookie targetCookie, String parameter, String token) {
		if(targetCookie==null || targetCookie.getValue().length() <= 1) {
			return false;
		}
		
		String[] arr = targetCookie.getValue().split(token);
		
		System.out.println(Arrays.toString(arr));
		
		Optional<String> result = Arrays.stream(arr).filter(str -> str.equals(parameter)).findFirst();
		
		return result.isPresent();
	}

	public void gotohome(){
		for(int i = 0; i<5;i++){
			System.out.println("What you gonna do?");
			System.out.println("What you gonna do?");
			System.out.println("What you gonna do?");
			System.out.println("What you gonna do?");
			System.out.println("What you gonna do?");
		}
	}