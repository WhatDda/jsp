package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import service.BoardService;
import service.BoardServiceImpl;
import service.UserService;
import service.UserServiceImpl;

public class BoardServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private BoardService bs = new BoardServiceImpl();
	private Gson g = new Gson();
	
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
	
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");
		if(command.equals("list")) {
			List<Map<String, String>> boardList = bs.selectBoardList();
			Map<String, Object> rHm = new HashMap<String, Object>();
			rHm.put("list", boardList);
			String result = g.toJson(rHm);
			doProcess(response, result);
		}
	}
	
	
	public void doProcess(HttpServletResponse response, String result)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.println(result);
		
	}
	
}
