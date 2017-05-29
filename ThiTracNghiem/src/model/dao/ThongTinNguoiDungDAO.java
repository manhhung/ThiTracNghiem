package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import form.ThongTinNguoiDungForm;
import model.bean.NguoiDung;
import model.bean.ThongTinNguoiDung;

public class ThongTinNguoiDungDAO {
	String url = "jdbc:sqlserver://localhost:1433;databaseName=Moc;integratedSecurity=true;";

	Connection connection;
	Statement stmt;
	
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
	
	public ArrayList<ThongTinNguoiDung> getListThongTinNguoiDung() {
		connect();
		String sql = "SELECT nd.MaNguoiDung,tt.TenNguoiDung,tt.GioiTinh,tt.NgaySinh,tt.DiaChi,tt.SoDienThoai"+
		"FROM NGUOIDUNG nd INNER JOIN THONGTIN_NGUOIDUNG AS tt ON nd.MaNguoiDung = tt.MaNguoiDung";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<ThongTinNguoiDung> list = new ArrayList<ThongTinNguoiDung>();
		ThongTinNguoiDung thongTinNguoiDung;
		try {
			while (rs.next()) {
				thongTinNguoiDung = new ThongTinNguoiDung();
				thongTinNguoiDung.setMaNguoiDung(rs.getString("maNguoiDung"));
				thongTinNguoiDung.setTenNguoiDung(rs.getString("tenNguoiDung"));
				thongTinNguoiDung.setGioiTinh(rs.getInt("gioiTinh"));
				thongTinNguoiDung.setNgaySinh(rs.getString("ngaySinh"));
				thongTinNguoiDung.setDiaChi(rs.getString("diaChi"));
				thongTinNguoiDung.setSoDienThoai(rs.getString("SDT"));
				list.add(thongTinNguoiDung);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void suaThongTinTaiKhoan(String maNguoiDung, String tenNguoiDung, int gioiTinh,String ngaySinh,
			String diaChi, String soDienThoai) {
		connect();
		String sql = String.format( "UPDATE THONGTIN_NGUOIDUNG SET TenNguoiDung = N'%s',GioiTinh='%d',NgaySinh='%s',DiaChi=N'%s',SDT='%s' "
						+ "WHERE MaNguoiDung ='%s'", tenNguoiDung,gioiTinh,ngaySinh,diaChi,soDienThoai,maNguoiDung);
		try {
			Statement stmt = connection.createStatement();
			System.out.println("s1=" + sql);
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ThongTinNguoiDung getThongTinChiTietNguoiDung(String maNguoiDung) {
		connect();
		String sql = String.format("SELECT NGUOIDUNG.MaNguoiDung, THONGTIN_NGUOIDUNG.TenNguoiDung, GioiTinh, NgaySinh, DiaChi, SDT"
				+" FROM NGUOIDUNG inner join THONGTIN_NGUOIDUNG on NGUOIDUNG.MaNguoiDung = THONGTIN_NGUOIDUNG.MaNguoiDung where THONGTIN_NGUOIDUNG.MaNguoiDung='%s'",maNguoiDung);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ThongTinNguoiDung thongTinNguoiDung = new ThongTinNguoiDung();
		
		try{
			while(rs.next()){
				thongTinNguoiDung.setMaNguoiDung(maNguoiDung);
				thongTinNguoiDung.setTenNguoiDung(rs.getString("TenNguoiDung"));
				thongTinNguoiDung.setGioiTinh(rs.getInt("GioiTinh"));
				thongTinNguoiDung.setNgaySinh(rs.getString("NgaySinh"));
				thongTinNguoiDung.setDiaChi(rs.getString("DiaChi"));
				thongTinNguoiDung.setSoDienThoai(rs.getString("SDT"));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return thongTinNguoiDung;
	}
	
}
