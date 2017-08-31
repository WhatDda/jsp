package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.DBcon;

public class BoardServiceImpl implements BoardService{

	@Override
	public List<Map<String, String>> selectBoardList() {
		Connection con;
		List<Map<String, String>> boardList = new ArrayList<Map<String, String>>();
		try {
			DBcon db = new DBcon();
			con = db.getCon();
			String sql = "select * from board where 1=1";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
					Map<String, String> rhm = new HashMap<String, String>();
					rhm.put("b_num", rs.getString("b_num"));
					rhm.put("title", rs.getString("title"));
					rhm.put("content", rs.getString("content"));
					rhm.put("reg_date", rs.getString("reg_date"));
					rhm.put("writer", rs.getString("writer"));
					boardList.add(rhm);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return boardList;
	}

	@Override
	public int inserBoard() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBoard() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public HashMap selectBoard() {
		// TODO Auto-generated method stub
		return null;
	}

}
