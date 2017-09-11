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
					+ " where gi.gicreusr = u.user_no and gi.gimofusr = c.user_no;";
			PreparedStatement ps = con.prepareStatement(sql);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteGoods(GoodsInfo gi) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertGoods(GoodsInfo gi) {
		// TODO Auto-generated method stub
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
