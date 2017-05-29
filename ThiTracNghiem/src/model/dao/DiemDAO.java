package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Diem;


public class DiemDAO {
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
	public ArrayList<Diem> getListDiem() {
		connect();
		String sql=	 "SELECT d.MaNguoiDung,m.MaMon, m.TenMon, d.DiemSo"+
					" FROM  CHITIETNGUOIDUNG d INNER JOIN Mon AS m ON d.MaMon = m.MaMon";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<Diem> list = new ArrayList<Diem>();
		Diem diem;
		try {
			while(rs.next()){
				diem = new Diem();
				diem.setMaNguoiDung(rs.getString("MaNguoiDung"));
				diem.setMaMon(rs.getString("MaMon"));
				diem.setTenMon(rs.getString("TenMon"));
				diem.setDiemSo(rs.getFloat("DiemSo"));
				list.add(diem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<Diem> getListDiem(String maMon) {
		connect();
		String sql=	String.format(" SELECT d.MaNguoiDung,m.MaMon, m.TenMon, d.DiemSo "+
				" FROM   CHITIETNGUOIDUNG d INNER JOIN Mon AS m ON d.MaMon = m.MaMon WHERE d.MaMon = '%s' ORDER BY d.DiemSo desc ", maMon);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		ArrayList<Diem> list = new ArrayList<Diem>();
		Diem diem;
		try {
			while(rs.next()){
				diem = new Diem();
				diem.setMaNguoiDung(rs.getString("MaNguoiDung"));
				diem.setMaMon(rs.getString("MaMon"));
				diem.setTenMon(rs.getString("TenMon"));
				diem.setDiemSo(rs.getFloat("DiemSo"));
				list.add(diem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
