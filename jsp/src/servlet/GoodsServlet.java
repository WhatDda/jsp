package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dto.GoodsInfo;
import dto.VendorInfo;
import service.GoodsService;
import service.GoodsServiceImpl;

public class GoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GoodsService gs = new GoodsServiceImpl();
	private Gson g = new Gson();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");
		if(command==null) {
			String param = request.getParameter("param");
			Map<String, String> hm = g.fromJson(param, HashMap.class);
			command = hm.get("command");
		}
		if (command.equals("list")) {
			String viNum = request.getParameter("vendor");
			String giName = request.getParameter("giName");
			GoodsInfo gi = new GoodsInfo();
			if(viNum!=null) {
				gi.setViNum(Integer.parseInt(viNum));
			}
			if(giName!=null) {
				gi.setGiName(giName);
			}
			List<GoodsInfo> list = gs.selectGoodsList(gi);
			List<VendorInfo> vlist = gs.selectVendorList(null);
			/*String result = "<table border='1'>"; 
			for(GoodsInfo gi : list) {
				result += "<tr>";
				result += "<td>" + gi.getGiNum() + "</td>";
				result += "<td>" + gi.getGiName() + "</td>";
				result += "<td>" + gi.getGiDesc() + "</td>";
				result += "<td>" + gi.getViNum() + "</td>";
				result += "<td><select>";
				for(VendorInfo vi : vlist) {
					String sel = "";
					if(vi.getViNum()==gi.getViNum()) {
						sel = "selected";
					}
					result += "<option " + sel + ">" + vi.getViName() + "</option>";
				}
				result += "</select></td>";
				result += "<td>" + gi.getViNum() + "</td>";
				result += "</td>";
			}
			result += "</table>";
			doProcess(response,result);*/
			 
			request.setAttribute("goodslist", list);
			request.setAttribute("vendorlist", vlist);
			String url = "/goods/goods_list.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		} else if(command.equals("vendorcombo")) {
			List<VendorInfo> vlist = gs.selectVendorList(null);
			String result = g.toJson(vlist);
			doProcess(response,result);
		} else if("insert".equals(command)) {
			String param = request.getParameter("param");
			Map<String, String> hm = g.fromJson(param, HashMap.class);
			System.out.println(hm);
			HttpSession hs = request.getSession();
			Map<String, String> user = (Map<String, String>)hs.getAttribute("user");
			hm.put("userNo", user.get("user_no"));
			int rCnt = gs.insertGoods(hm);
			Map<String, String> rHm = new HashMap<String, String>();
			rHm.put("msg", "상품입력에 실패하셨습니다.");
			if(rCnt==1) {
				rHm.put("insert", "ok");
				rHm.put("msg", "상품입력에 성공하셨습니다.");
			}
			String result = g.toJson(rHm);
			doProcess(response, result);
					
		} else if("view".equals(command)) {
			String param = request.getParameter("param");
			GoodsInfo gi = g.fromJson(param,  GoodsInfo.class);
			gi = gs.selectGoods(gi);
			String result = g.toJson(gi);
			doProcess(response, result);
		} else if("update".equals(command)) {
			String param = request.getParameter("param");
			GoodsInfo gi = g.fromJson(param,  GoodsInfo.class);
			int rCnt = gs.updateGoods(gi);
			Map<String, String> rHm = new HashMap<String, String>();
			rHm.put("msg", "상품수정에 실패하셨습니다.");
			if(rCnt==1) {
				rHm.put("insert", "ok");
				rHm.put("msg", "상품수정에 성공하셨습니다.");
			}
			String result = g.toJson(rHm);
			doProcess(response, result);
		} else if ("delete".equals(command)) {
			String param = request.getParameter("param");
			GoodsInfo gi = g.fromJson(param,  GoodsInfo.class);
			int rCnt = gs.deleteGoods(gi);
			Map<String, String> rHm = new HashMap<String, String>();
			rHm.put("msg", "상품삭제에 실패하셨습니다.");
			if(rCnt==1) {
				rHm.put("insert", "ok");
				rHm.put("msg", "상품삭제에 성공하셨습니다.");
			}
			String result = g.toJson(rHm);
			doProcess(response, result);
		}
	}

	public void doProcess(HttpServletResponse response, String result) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.println(result);

	}

}
