package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.DBcon;
import dto.GoodsInfo;
import dto.VendorInfo;

public class GoodsServiceImpl implements GoodsService {

	@Override
	public List<GoodsInfo> selectGoodsList(GoodsInfo gi) {
		Connection con;
		List<GoodsInfo> boardList = new ArrayList<GoodsInfo>();
		try {
			DBcon db = new DBcon();
			con = db.getCon();
			String sql = "SELECT gi.ginum, gi.giname, gi.gidesc, gi.vinum, gi.gicredat,"
					+ " gi.gimofdat, gi.gicreusr, u.name, gi.gimofusr, c.name as name2"
					+ " FROM goods_info gi, user u, user c"
					+ " where gi.gicreusr = u.user_no and gi.gimofusr = c.user_no";
			if(gi!=null) {
				if(gi.getViNum()!=0) {
					sql += " and gi.vinum=?";
				}
				if(gi.getGiName()!=null) {
					sql += " and gi.giname like concat('%',?,'%')";
				}
			}
			PreparedStatement ps = con.prepareStatement(sql);
			if(gi!=null) {
				if(gi.getViNum()!=0) {
					ps.setInt(1, gi.getViNum());
				}
				if(gi.getGiName()!=null) {
					ps.setString(2, gi.getGiName());
				}
			}
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				GoodsInfo rGi = new GoodsInfo();
				rGi.setGiNum(rs.getInt("ginum"));
				rGi.setGiName(rs.getString("giname"));
				rGi.setGiDesc(rs.getString("gidesc"));
				rGi.setViNum(rs.getInt("vinum"));
				rGi.setGiCreDat(rs.getString("gicredat"));
				rGi.setGiMofDat(rs.getString("gimofdat"));
				rGi.setGiCreusr(rs.getInt("gicreusr"));
				rGi.setGiMofusr(rs.getInt("gimofusr"));
				rGi.setName(rs.getString("name"));
				rGi.setName2(rs.getString("name2"));
				boardList.add(rGi);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boardList;
	}

	@Override
	public GoodsInfo selectGoods(GoodsInfo gi) {
		Connection con;
		DBcon db = null;
		List<GoodsInfo> boardList = new ArrayList<GoodsInfo>();
		try {
			db = new DBcon();
			con = db.getCon();
			String sql = "SELECT gi.ginum, gi.giname, gi.gidesc, gi.vinum, gi.gicredat,"
					+ " gi.gimofdat, gi.gicreusr, u.name, gi.gimofusr, c.name as name2"
					+ " FROM goods_info gi, user u, user c"
					+ " where gi.gicreusr = u.user_no and gi.gimofusr = c.user_no"
					+ " and gi.ginum=?";
		
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, gi.getGiNum());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				GoodsInfo rGi = new GoodsInfo();
				rGi.setGiNum(rs.getInt("ginum"));
				rGi.setGiName(rs.getString("giname"));
				rGi.setGiDesc(rs.getString("gidesc"));
				rGi.setViNum(rs.getInt("vinum"));
				rGi.setGiCreDat(rs.getString("gicredat"));
				rGi.setGiMofDat(rs.getString("gimofdat"));
				rGi.setGiCreusr(rs.getInt("gicreusr"));
				rGi.setGiMofusr(rs.getInt("gimofusr"));
				rGi.setName(rs.getString("name"));
				rGi.setName2(rs.getString("name2"));
				return rGi;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(db!=null) {
				db.closeCon();
			}	
		}
		return null;
	}

	@Override
	public int deleteGoods(GoodsInfo gi) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertGoods(Map<String, String> map) {
		Connection con = null;
		DBcon db = null;
		try {
			db = new DBcon();
			con = db.getCon();
			String sql = "insert into goods_info(giname, gidesc, vinum,";
			sql += " gicredat, gimofdat, gicreusr, gimofusr)";
			sql += " values(?,?,?,now(),now(),?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, map.get("giName"));
			ps.setString(2, map.get("giDesc"));
			ps.setString(3, map.get("viNum"));
			ps.setString(4, map.get("userNo"));
			ps.setString(5, map.get("userNo"));
			int rCnt = ps.executeUpdate();
			con.commit();
			return rCnt;
		} catch (Exception e) {
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
	public int updateGoods(GoodsInfo gi) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<VendorInfo> selectVendorList(VendorInfo vi) {
		Connection con;
		List<VendorInfo> boardList = new ArrayList<VendorInfo>();
		try {
			DBcon db = new DBcon();
			con = db.getCon();
			String sql = "select * from vendor_info;";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				VendorInfo rVi = new VendorInfo();

				rVi.setViNum(rs.getInt("vinum"));
				rVi.setViName(rs.getString("viname"));
				rVi.setViDesc(rs.getString("videsc"));

				boardList.add(rVi);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boardList;
	}



}
