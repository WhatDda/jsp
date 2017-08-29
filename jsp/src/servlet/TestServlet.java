package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TestServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String result="";
		if(id.equals("redfila")) {
			if(pwd.equals("red")) {
				HttpSession session = request.getSession();
				session.setAttribute("id", id);
			result = "정상적으로 로그인 되었습니다.";
		} else {
			result = "비밀번호가 틀렸습니다.";
		}
		}else {
			result="없는 아이디 입니다.";
		}
		
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.println(result);

/*	test.html 관련소스		
  
  		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		System.out.println(name);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.println("입력하신 이름 : " + name);
		
		request.setCharacterEncoding("utf-8");
		String age = request.getParameter("age");
		System.out.println(age);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw2 = response.getWriter();
		pw2.println("입력하신 나이 : " + age);
		
		request.setCharacterEncoding("utf-8");
		String address = request.getParameter("address");
		System.out.println(address);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw3 = response.getWriter();
		pw3.println("입력하신 주소 : " + address);
*/		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String result="";
		if(id.equals("redfila")) {
			if(pwd.equals("red")) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			result = "정상적으로 로그인 되었습니다.";
		} else {
			result = "비밀번호가 틀렸습니다.";
		}
		}else {
			result="없는 아이디 입니다.";
		}
		
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.println(result);
		
/*		test.html 관련소스
  
 	 	request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		System.out.println(name);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.println("입력하신 이름 : " + name);
		
		request.setCharacterEncoding("utf-8");
		String age = request.getParameter("age");
		System.out.println(age);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw2 = response.getWriter();
		pw2.println("입력하신 나이 : " + age);
		
		request.setCharacterEncoding("utf-8");
		String address = request.getParameter("address");
		System.out.println(address);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw3 = response.getWriter();
		pw3.println("입력하신 주소 : " + address);
*/
	}
}
