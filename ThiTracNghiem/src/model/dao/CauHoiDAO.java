package model.dao;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.CauHoi;

public class CauHoiDAO {
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
	public ArrayList<CauHoi> getListCauHoi() {
		connect();
		String sql = "SELECT ch.MaCauHoi, m.TenMon, ch.NoiDung, ch.DapAn1, ch.DapAn2, ch.DapAn3, ch.DapAn4, ch.DapAnDung "+
					"FROM  CAUHOI ch INNER JOIN MON AS m ON m.MaMon = ch.MaMon";
		ResultSet rs = null;
		try{
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		}catch (SQLException e){
			e.printStackTrace();			
		}
		
		ArrayList<CauHoi> list = new ArrayList<CauHoi>();
		CauHoi cauHoi;
		try{
			while(rs.next()){
				cauHoi = new CauHoi();
				cauHoi.setMaCauHoi(rs.getInt("MaCauHoi"));
				cauHoi.setTenMon(rs.getString("TenMon"));
				cauHoi.setNoiDung(rs.getString("NoiDung"));
				cauHoi.setDapAn1(rs.getString("DapAn1"));
				cauHoi.setDapAn2(rs.getString("DapAn2"));
				cauHoi.setDapAn3(rs.getString("DapAn3"));
				cauHoi.setDapAn4(rs.getString("DapAn4"));
				cauHoi.setDapAnDung(rs.getInt("DapAnDung"));
				list.add(cauHoi);
			}
		} catch (SQLException e){
			e.printStackTrace();			
		}
		return list;
	}
	public ArrayList<CauHoi> getListCauHoi(String maMon){
		connect();
		String sql=	String.format("SELECT ch.MaCauHoi, m.TenMon, ch.NoiDung, ch.DapAn1, ch.DapAn2, ch.DapAn3, ch.DapAn4, ch.DapAnDung"+
				" FROM   CAUHOI ch INNER JOIN MON AS m ON m.MaMon = ch.MaMon"+
				" WHERE ch.MaMon = '%s'", maMon);
		ResultSet rs = null;
		try{
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		}catch (SQLException e){
			e.printStackTrace();			
		}
		
		ArrayList<CauHoi> list = new ArrayList<CauHoi>();
		CauHoi cauHoi;
		try{
			while(rs.next()){
				cauHoi = new CauHoi();
				cauHoi.setMaCauHoi(rs.getInt("MaCauHoi"));
				cauHoi.setTenMon(rs.getString("TenMon"));
				cauHoi.setNoiDung(rs.getString("NoiDung"));
				cauHoi.setDapAn1(rs.getString("DapAn1"));
				cauHoi.setDapAn2(rs.getString("DapAn2"));
				cauHoi.setDapAn3(rs.getString("DapAn3"));
				cauHoi.setDapAn4(rs.getString("DapAn4"));
				cauHoi.setDapAnDung(rs.getInt("DapAnDung"));
				list.add(cauHoi);
			}
		} catch (SQLException e){
			e.printStackTrace();			
		}
		return list;
	}

	public void themCauHoi(String maMon, String noiDung, String dapAn1, String dapAn2,	String dapAn3, String dapAn4, int dapAnDung) {
		connect();
		String sql = String.format("INSERT INTO CAUHOI(MaMon,NoiDung,DapAn1,DapAn2,DapAn3,DapAn4,DapAnDung) "+
					" VALUES ( '%s',N'%s',N'%s',N'%s',N'%s',N'%s','%s' )", maMon, noiDung, dapAn1, dapAn2, dapAn3, dapAn4, dapAnDung);

		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);		
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	
	
	public CauHoi getThongTinCauHoi(int maCauHoi) {
		connect();
		String sql = String.format("SELECT MaMon, NoiDung, DapAn1, DapAn2, DapAn3, DapAn4, DapAnDung "+
								" FROM CAUHOI WHERE MaCauHoi = '%s'", maCauHoi);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		CauHoi cauHoi = new CauHoi();
		try{
			while(rs.next()){
				cauHoi.setMaCauHoi(maCauHoi);
				cauHoi.setMaMon(rs.getString("MaMon"));
				cauHoi.setNoiDung(rs.getString("NoiDung"));
				cauHoi.setDapAn1(rs.getString("DapAn1"));
				cauHoi.setDapAn2(rs.getString("DapAn2"));
				cauHoi.setDapAn3(rs.getString("DapAn3"));
				cauHoi.setDapAn4(rs.getString("DapAn4"));
				cauHoi.setDapAnDung(rs.getInt("DapAnDung"));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return cauHoi;
	}

	public void capNhatCauHoi(int maCauHoi, String maMon, String noiDung, String dapAn1, String dapAn2, String dapAn3, String dapAn4,
			int dapAnDung) {
		connect();
		String sql = String.format("UPDATE CAUHOI "+
								   " SET MaMon = '%s', NoiDung = N'%s', DapAn1 = N'%s', DapAn2 = N'%s', DapAn3 = N'%s', DapAn4 = N'%s', DapAnDung = '%s' " +
								   " WHERE  MaCauHoi = '%s'", maMon, noiDung, dapAn1, dapAn2, dapAn3, dapAn4, dapAnDung, maCauHoi);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void xoaCauHoi(int maCauHoi) {

		connect();
		String sql = String.format("DELETE FROM CAUHOI Where MaCauHoi = '%s'", maCauHoi);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
}

