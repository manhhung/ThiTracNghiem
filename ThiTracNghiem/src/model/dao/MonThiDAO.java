package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.MonThi;



public class MonThiDAO {
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
	public ArrayList<MonThi> getListMonThi(String maNguoiDung) {
		connect();
		String sql=	String.format("select * from MON,NGUOIDUNG where MON.MaMon=NGUOIDUNG.MaMon and NguoiDung.MaNguoiDung=N'%s' ",maNguoiDung);			
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<MonThi> list = new ArrayList<MonThi>();
		MonThi monThi;
		try {
			while(rs.next()){
				monThi = new MonThi();
				monThi.setMaMon(rs.getString("MaMon"));
				monThi.setTenMon(rs.getString("TenMon"));
				
				list.add(monThi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void themMonThi(String maMon, String tenMon){
		connect();
		String sql = String.format("INSERT INTO MON(MaMon,TenMon) VALUES ('%s', N'%s')",maMon,tenMon);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//sửa môn thi
	public MonThi getThongTinMonThi(String maMon) {
		connect();
		String sql=	String.format("SELECT * FROM MON WHERE MaMon = '%s'", maMon);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		MonThi monThi = new MonThi();
		try {
			while(rs.next()){
				monThi.setMaMon(maMon);
				monThi.setTenMon(rs.getString("TenMon"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return monThi;
	}
	public void suaMonThi(String maMon, String tenMon) {
		connect();
		String sql=	String.format("UPDATE MON SET TenMon = N'%s' WHERE MaMon = '%s'", tenMon,maMon);
	
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void xoaMon(String maMon) {
		connect();
		String sql=	String.format("DELETE FROM MON WHERE MaMon = '%s'", maMon);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public String getMaMonSoSanh(String maMon) {
		connect();
		String sql = String.format("SELECT MaMon FROM MON WHERE MaMon = '%s'", maMon);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String mon = null;
		try{
			while(rs.next()){
				mon = rs.getString("MaMon");
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return mon;
	}
	public void xoaDeThi(String maMon) {
		// TODO Auto-generated method stub
		connect();
		String sql=	String.format("DELETE FROM DETHI WHERE MaMon = '%s'", maMon);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void xoaDiem(String maNguoiDung, String maMon1) {
		// TODO Auto-generated method stub
		connect();
		String sql=	String.format("DELETE d FROM CHITIETNGUOIDUNG d WHERE MaNguoiDung = '%s' AND MaMon = '%s' " , maNguoiDung, maMon1);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<MonThi> getListMonThi1() {
		// TODO Auto-generated method stub
		connect();
		String sql=	"select * from MON ";			
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<MonThi> list = new ArrayList<MonThi>();
		MonThi monThi;
		try {
			while(rs.next()){
				monThi = new MonThi();
				monThi.setMaMon(rs.getString("MaMon"));
				monThi.setTenMon(rs.getString("TenMon"));
				list.add(monThi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	}

