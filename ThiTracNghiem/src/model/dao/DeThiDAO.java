package model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.DeThi;



public class DeThiDAO {
	String url = "jdbc:sqlserver://localhost:1433;databaseName=Moc;integratedSecurity=true;";

	Connection connection;
	
	void connect(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url);
			System.out.println("Ket noi thanh cong");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Ket noi loi");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Ket noi loi");
		}
	}

	public ArrayList<DeThi> getListDeThi() {
		connect();
		String sql = "SELECT dt.MaDeThi, m.TenMon, dt.ThoiGianThi, dt.SoLuongCauHoi"+
					" FROM  DETHI dt INNER JOIN MON as m ON dt.MaMon = m.MaMon";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		ArrayList<DeThi> list = new ArrayList<DeThi>();
		DeThi deThi;
		try{
			while(rs.next()){
				deThi = new DeThi();
				deThi.setMaDeThi(rs.getInt("MaDeThi"));
				deThi.setTenMon(rs.getString("TenMon"));
				deThi.setSoLuongCauHoi(rs.getInt("SoLuongCauHoi"));
				deThi.setThoiGianThi(rs.getInt("ThoiGianThi"));
				list.add(deThi);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<DeThi> getListDeThi(String maMon) {
		connect();
		String sql = String.format("SELECT dt.MaDeThi, m.TenMon, dt.ThoiGianThi, dt.SoLuongCauHoi"+
				" FROM  DETHI dt INNER JOIN MON as m ON dt.MaMon = m.MaMon"+
				" WHERE dt.MaMon = '%s'", maMon);
		
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		ArrayList<DeThi> list = new ArrayList<DeThi>();
		DeThi deThi;
		try{
			while(rs.next()){
				deThi = new DeThi();
				deThi.setMaDeThi(rs.getInt("MaDeThi"));
				deThi.setTenMon(rs.getString("TenMon"));
				deThi.setSoLuongCauHoi(rs.getInt("SoLuongCauHoi"));
				deThi.setThoiGianThi(rs.getInt("ThoiGianThi"));
				list.add(deThi);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return list;
	}

	public void themDeThi(int maMon, int maDeThi, int thoiGianThi, int soLuongCauHoi) {
		connect();
		String sql = String.format(" Insert into DETHI(MaDeThi, ThoiGianThi, SoLuongCauHoi, MaMon) "+
				" VALUES ( '%s','%s','%s','%s' )", maDeThi, thoiGianThi, soLuongCauHoi, maMon);
		System.out.println("sql:"+ sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);		
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		CallableStatement cs;
		try {
			cs = this.connection.prepareCall("{call SP_ThemChiTietDeThi("+maDeThi+","+soLuongCauHoi+","+maMon+")}");
			
			ResultSet rs = cs.executeQuery();
			
			System.out.println("sql:"+ cs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

	}
	
	

	public DeThi getThongTinDeThi(int maDeThi) {
		connect();
		String sql = String.format("SELECT MaMon, ThoiGianThi, SoLuongCauHoi "+
				" FROM DETHI WHERE MaDeThi = '%s'", maDeThi);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DeThi deThi = new DeThi();
		try{
			while(rs.next()){
				deThi.setMaDeThi(maDeThi);
				deThi.setMaMon(rs.getInt("MaMon"));
				deThi.setThoiGianThi(rs.getInt("ThoiGianThi"));
				deThi.setSoLuongCauHoi(rs.getInt("SoLuongCauHoi"));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return deThi;
		
	}

	public void capNhatDeThi(int maDeThi, int maMon, int thoiGianThi, int soLuongCauHoi) {
		connect();
		String sql = String.format("UPDATE DETHI "+
				" SET ThoiGianThi = '%s', SoLuongCauHoi = '%s', MaMon = '%s' "+
				" WHERE MaDeThi = '%s'", thoiGianThi, soLuongCauHoi, maMon, maDeThi);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void xoaDeThi(int maDeThi) {
		connect();
		String sql = String.format("DELETE FROM DETHI where MaDeThi = '%s'", maDeThi);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sql2 = String.format("DELETE FROM CHITIETDETHI where MaDeThi = '%s'", maDeThi);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	}
	
