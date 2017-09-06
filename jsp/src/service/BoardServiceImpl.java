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
			String sql = "select b.*, a.name from user a, board b" +
					 " where a.user_no = b.writer order by b.b_num desc";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
					Map<String, String> rhm = new HashMap<String, String>();
					rhm.put("b_num", rs.getString("b_num"));
					rhm.put("title", rs.getString("title"));
					rhm.put("content", rs.getString("content"));
					rhm.put("reg_date", rs.getString("reg_date"));
					rhm.put("writer", rs.getString("writer"));
					rhm.put("name", rs.getString("name"));
					boardList.add(rhm);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return boardList;
	}

	@Override
	public int insertBoard(Map<String, String> hm) {
		String sql = "insert into board(title,content,reg_date,writer)";
		sql += " values(?,?,now(),?)";
		Connection con = null;
		DBcon db = null;
		try {
			db = new DBcon();
			con = db.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, hm.get("title"));
			ps.setString(2, hm.get("content"));
			ps.setString(3, hm.get("writer"));
			int rCnt = ps.executeUpdate();
			if(rCnt==1) {
				con.commit();
			} else {
				con.rollback();
			}
			return rCnt;
	} catch(Exception e) {
		try {
			con.rollback();
		} catch(Exception e1) {
		e.printStackTrace();
		}
		e.printStackTrace();
	} finally {
		if(db!=null) {
			db.closeCon();
		}	
	}
		return 0;
	}

	@Override
	public int deleteBoard(Map<String, String> hm) {
		String sql = "delete from board where b_num=?";
		Connection con = null;
		DBcon db = null;
		try {
			db = new DBcon();
			con = db.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, hm.get("b_num"));
			int rCnt = ps.executeUpdate();
			if(rCnt==1) {
				con.commit();
			} else {
				con.rollback();
			}
			return rCnt;
	} catch(Exception e) {
		try {
			con.rollback();
		} catch(Exception e1) {
		e.printStackTrace();
		}
		e.printStackTrace();
	} finally {
		if(db!=null) {
			db.closeCon();
		}	
	}
		return 0;
	}

	@Override
	public int modifyBoard(Map<String, String> hm) {
		String sql = "update board SET title=?, content=?, writer=? where b_num=?";
		Connection con = null;
		DBcon db = null;
		try {
			db = new DBcon();
			con = db.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, hm.get("title"));
			ps.setString(2, hm.get("content"));
			ps.setString(3, hm.get("writer"));
			ps.setString(4, hm.get("b_num"));
			int rCnt = ps.executeUpdate();
			if(rCnt==1) {
				con.commit();
			} else {
				con.rollback();
			}
			return rCnt;
	} catch(Exception e) {
		try {
			con.rollback();
		} catch(Exception e1) {
		e.printStackTrace();
		}
		e.printStackTrace();
	} finally {
		if(db!=null) {
			db.closeCon();
		}	
	}
		return 0;
	}

	@Override
	public Map<String, String> selectBoard(Map<String, String> hm) {
		Connection con;
		Map<String, String> rHm = new HashMap<String, String>();
		try {
			DBcon db = new DBcon();
			con = db.getCon();
			String sql = "select b.*, a.name from user a, board b" +
					 " where a.user_no = b.writer and b.b_num=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, hm.get("b_num"));
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {	
					rHm.put("b_num", rs.getString("b_num"));
					rHm.put("title", rs.getString("title"));
					rHm.put("content", rs.getString("content"));
					rHm.put("reg_date", rs.getString("reg_date"));
					rHm.put("writer", rs.getString("writer"));
					rHm.put("name", rs.getString("name"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return rHm;
	}

}
