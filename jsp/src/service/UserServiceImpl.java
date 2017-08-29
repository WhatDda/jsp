package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.DBcon;

public class UserServiceImpl implements UserService {

	@Override
	public Map<String, String> getUserLogin(String id, String pwd) {

		Connection con;
		try {
			DBcon db = new DBcon();
			con = db.getCon();
			String sql = "select * from user where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(pwd.equals(rs.getString("pwd"))) {
					Map<String, String> hm = new HashMap<String, String>();
					hm.put("id", id);
					hm.put("user_no", rs.getString("user_no"));
					hm.put("name", rs.getString("name"));
					hm.put("hobby", rs.getString("hobby"));
					hm.put("admin", rs.getString("admin"));
					return hm;
				} 
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertUser(Map<String, String> hm) {
		String sql = "insert into user(id,pwd,name,hobby,admin)";
		sql += "values(?,?,?,?,?)";
		Connection con;
		String result = "회원 가입 실패";
		try {
			DBcon db = new DBcon();
			con = db.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, hm.get("id"));
			ps.setString(2, hm.get("pwd"));
			ps.setString(3, hm.get("name"));
			ps.setString(4, hm.get("hobby"));
			ps.setString(5, hm.get("admin"));
			int rCnt = ps.executeUpdate();
			return rCnt;
	} catch(Exception e) {
		e.printStackTrace();
	}
		return 0;
	}

	@Override
	public int updatetUser(Map<String, String> hm) {
		String sql = "update user SET id=?,pwd=?,name=?,hobby=? where user_no=?";
		Connection con;
		try {
			DBcon db = new DBcon();
			con = db.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, hm.get("id"));
			ps.setString(2, hm.get("pwd"));
			ps.setString(3, hm.get("name"));
			ps.setString(4, hm.get("hobby"));
			ps.setString(5, hm.get("user_no"));
			int rCnt = ps.executeUpdate();
			return rCnt;
	} catch(Exception e) {
		e.printStackTrace();
	}
		return 0;
	}

	@Override
	public int deleteUser(Map<String, String> hm) {
		String sql = "delete from user where user_no=?";
		Connection con;
		try {
			DBcon db = new DBcon();
			con = db.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, hm.get("user_no"));
			int rCnt = ps.executeUpdate();
			return rCnt;
	} catch(Exception e) {
		e.printStackTrace();
	}
		return 0;
	}

	@Override
	public List<Map<String, String>> getUserList(Map<String, String> hm) {
		Connection con;
		List<Map<String, String>> userList = new ArrayList<Map<String, String>>();
		try {
			DBcon db = new DBcon();
			con = db.getCon();
			String sql = "select * from user where 1=1";
			if(hm.get("name")!=null) {
				sql += " and name like concat('%',?,'%')";
			}
			PreparedStatement ps = con.prepareStatement(sql);
			if(hm.get("name")!=null) {
				ps.setString(1, hm.get("name"));
			}
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
					Map<String, String> rhm = new HashMap<String, String>();
					rhm.put("id", rs.getString("id"));
					rhm.put("user_no", rs.getString("user_no"));
					rhm.put("name", rs.getString("name"));
					rhm.put("hobby", rs.getString("hobby"));
					rhm.put("admin", rs.getString("admin"));
					userList.add(rhm);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

}
