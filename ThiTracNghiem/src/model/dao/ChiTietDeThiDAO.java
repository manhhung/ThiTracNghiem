package model.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import model.bean.*;

public class ChiTietDeThiDAO {
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

	public ArrayList<ChiTietDeThi> getListChiTietDeThi(String maDeThi) {
		connect();
		String sql = String.format("select ct.MaDeThi, m.TenMon, ct.MaCauHoi, ch.NoiDung, ch.DapAn1, ch.DapAn2, ch.DapAn3, ch.DapAn4, ch.DapAnDung"+
									" from CHITIETDETHI ct, CAUHOI ch, DETHI dt, MON m "+
									" where (ct.MaCauHoi = ch.MaCauHoi) and (ct.MaDeThi = dt.MaDeThi) and (ch.MaMon = m.MaMon) and ct.MaDeThi = '%s'", maDeThi);

		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		}catch (SQLException e){
			e.printStackTrace();
		}
	
	ArrayList<ChiTietDeThi> list = new ArrayList<ChiTietDeThi>();
	ChiTietDeThi chiTietDeThi;
	try{
		while(rs.next()){
			chiTietDeThi = new ChiTietDeThi();
			chiTietDeThi.setMaDeThi(rs.getInt("MaDeThi"));
			chiTietDeThi.setTenMon(rs.getString("TenMon"));
			chiTietDeThi.setMaCauHoi(rs.getInt("MaCauHoi"));
			chiTietDeThi.setNoiDung(rs.getString("NoiDung"));
			chiTietDeThi.setDapAn1(rs.getString("DapAn1"));
			chiTietDeThi.setDapAn2(rs.getString("DapAn2"));
			chiTietDeThi.setDapAn3(rs.getString("DapAn3"));
			chiTietDeThi.setDapAn4(rs.getString("DapAn4"));
			chiTietDeThi.setDapAnDung(rs.getInt("DapAnDung"));
			list.add(chiTietDeThi);
			
		}
	}catch (SQLException e){
		e.printStackTrace();
	}
	return list;
	
}
}
