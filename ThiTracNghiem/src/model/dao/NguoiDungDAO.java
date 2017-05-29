package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.CauHoi;
import model.bean.NguoiDung;
import model.bean.Quyen;
import form.NguoiDungForm;

public class NguoiDungDAO {
	String url = "jdbc:sqlserver://localhost:1433;databaseName=Moc;integratedSecurity=true;";

	Connection connection;
	Statement stmt;
//	private static int noOfRecords;
	
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

	public ArrayList<NguoiDung> getListNguoiDung() {
		connect();
		String sql = "SELECT MaNguoiDung,'•••••••' as MatKhau,TenQuyen,Mon.TenMon FROM  NGUOIDUNG inner join Quyen on NGUOIDUNG.Id=QUYEN.Id left join MON on MON.MaMon=NGUOIDUNG.MaMon";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<NguoiDung> list = new ArrayList<NguoiDung>();
		NguoiDung nguoiDung;
		try {
			while (rs.next()) {
				nguoiDung = new NguoiDung();
				nguoiDung.setMaNguoiDung(rs.getString("maNguoiDung"));
				nguoiDung.setMatKhau(rs.getString("matKhau"));
				nguoiDung.setTenQuyen(rs.getString("TenQuyen"));
				nguoiDung.setTenMon(rs.getString("tenMon"));
				list.add(nguoiDung);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public void themTaiKhoan(String maNguoiDung, String matKhau, String id, String maMon) {
		connect();
		String sql = String.format(
				"INSERT INTO NGUOIDUNG(MaNguoiDung,MatKhau,Id,maMon) "
						+ " VALUES ( '%s','%s','%s','%s')", maNguoiDung, matKhau,
						id,maMon);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public NguoiDung getThongTinNguoiDung(String maNguoiDung) {
		connect();
		String sql = String.format("SELECT MaNguoiDung,MatKhau,Quyen.ID,Mon.MaMon FROM  NGUOIDUNG inner join Quyen on NGUOIDUNG.Id=QUYEN.Id left join MON on MON.MaMon=NGUOIDUNG.MaMon WHERE MaNguoiDung = '%s'", maNguoiDung);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		NguoiDung nguoiDung = new NguoiDung();
		try{
			while(rs.next()){
				nguoiDung.setMaNguoiDung(maNguoiDung);
				nguoiDung.setMatKhau(rs.getString("matKhau"));
			
				nguoiDung.setId(rs.getString("ID"));
				//nguoiDung.setTenQuyen(rs.getString("TenQuyen"));
				nguoiDung.setTenMon(rs.getString("MaMon"));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return nguoiDung;
	}

	public void suaTaiKhoan(String maNguoiDung, String matKhau, String id, String maMon) {
		connect();
		String sql = String
				.format(" UPDATE NGUOIDUNG "
						+ " SET matKhau = '%s', Id = '%s', MaMon='%s'"
						+ " WHERE maNguoiDung = '%s'", matKhau, id,maMon, maNguoiDung);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void xoaNguoiDung(String maNguoiDung) {

		connect();
		String sql = String.format("DELETE FROM NGUOIDUNG Where maNguoiDung = '%s'", maNguoiDung);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void themThongTinTaiKhoan(String maNguoiDung) {
		connect();
		String sql = String.format( "INSERT INTO THONGTIN_NGUOIDUNG(MaNguoiDung) VALUES (N'%s')", maNguoiDung);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getMaTaiKhoanCSDL(String maTaiKhoan) {
		connect();
		String sql = String.format("SELECT MaNguoiDung FROM NGUOIDUNG WHERE MaNguoiDung = '%s'", maTaiKhoan);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String nguoiDung = null;
		try{
			while(rs.next()){
				nguoiDung = rs.getString("MaNguoiDung");
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return nguoiDung;
	}

	public ArrayList<NguoiDung> getListQuyen() {
		connect();
		String sql = "SELECT * FROM QUYEN";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<NguoiDung> list = new ArrayList<NguoiDung>();
		NguoiDung nguoiDung;
		try {
			while (rs.next()) {
				nguoiDung = new NguoiDung();
				nguoiDung.setId(rs.getString("Id"));
				nguoiDung.setTenQuyen(rs.getString("TenQuyen"));
				list.add(nguoiDung);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void xoaChiTietNguoiDung(String maNguoiDung) {
		// TODO Auto-generated method stub
		connect();
		String sql = String.format("DELETE FROM ThongTin_NguoiDung Where MaNguoiDung = '%s'", maNguoiDung);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Quyen> getListQuyen1() {
		// TODO Auto-generated method stub
		connect();
		String sql = "SELECT * FROM QUYEN";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<Quyen> list = new ArrayList<Quyen>();
		Quyen quyen;
		try {
			while (rs.next()) {
				quyen = new Quyen();
				quyen.setMaQuyen(rs.getString("Id"));
				quyen.setTenQuyen(rs.getString("TenQuyen"));
				list.add(quyen);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	
	
	}
