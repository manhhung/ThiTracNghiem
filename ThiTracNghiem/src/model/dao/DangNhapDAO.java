package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.NguoiDung;
import form.DangNhapForm;


public class DangNhapDAO {
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
	public String checkLogin(String maNguoiDung, String matKhau) {
		// TODO Auto-generated method stub
		connect();
		String sql=	String.format("SELECT MaNguoiDung, Id, MatKhau FROM NguoiDung WHERE MaNguoiDung = '%s' AND MatKhau = '%s'", maNguoiDung, matKhau);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String IDQuyen = null;
		try {
			if(rs.next()){
			IDQuyen = rs.getString("Id");
			//return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//return false;
		return IDQuyen;
	}
	public DangNhapForm getDangNhap(String maNguoiDung,String matKhau){
		connect();
		String sql=	String.format("SELECT MaNguoiDung,MatKhau,Id FROM NguoiDung WHERE MaNguoiDung = '%s' AND MatKhau = '%s'", maNguoiDung, matKhau);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DangNhapForm dangNhapForm = new DangNhapForm(); 
		try {
			while (rs.next()) {
				dangNhapForm.setMaNguoiDung(rs.getString("MaNguoiDung"));
				dangNhapForm.setMatKhau(rs.getString("MatKhau"));
				dangNhapForm.setId(rs.getString("Id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dangNhapForm;
	}
	public ArrayList<NguoiDung> setListNguoiDung(String maNguoiDung) {
		// TODO Auto-generated method stub
		connect();
		String sql=	String.format("SELECT MaNguoiDung,MatKhau,Id FROM NguoiDung WHERE MaNguoiDung = '%s'", maNguoiDung);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		NguoiDung nguoiDung ;
		ArrayList<NguoiDung> list=new ArrayList<NguoiDung>();
		try {
			while (rs.next()) {
				nguoiDung=new NguoiDung();
				nguoiDung.setMaNguoiDung(rs.getString("MaNguoiDung"));
				nguoiDung.setMatKhau(rs.getString("MatKhau"));
				nguoiDung.setId(rs.getString("Id"));
				list.add(nguoiDung);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public Object checkLamBai(String maNguoiDung) {
		// TODO Auto-generated method stub
		connect();
		String sql=	String.format("SELECT MaNguoiDung FROM KETQUATHI WHERE MaNguoiDung='%s'", maNguoiDung);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String MaNguoiDung = null;
		try {
			if(rs.next()){
				MaNguoiDung = rs.getString("MaNguoiDung");
			//return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//return false;
		return MaNguoiDung;
	}
	
	
}
