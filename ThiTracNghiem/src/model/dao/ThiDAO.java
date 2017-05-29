package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import form.CauHoiForm;
import form.DangNhapForm;
import form.ThiForm;
import model.bean.CauHoi;
import model.bean.KetQuaThi;
import model.bean.LayNguoiDung;
import model.bean.LayTenMon;
import model.bean.NguoiDung;




public class ThiDAO {
	
	String url = "jdbc:sqlserver://localhost:1433;databaseName=Moc;integratedSecurity=true;";

	Connection connection;
	Statement stmt;
	private static int noOfRecords;
	private static int getMaDeThi;
	private static String getMaNguoiDung;
	public static String getGetMaNguoiDung() {
		return getMaNguoiDung;
	}
	public static void setGetMaNguoiDung(String getMaNguoiDung) {
		ThiDAO.getMaNguoiDung = getMaNguoiDung;
	}
	public static int getGetMaDeThi() {
		return getMaDeThi;
	}
	public static void setGetMaDeThi(int getMaDeThi) {
		ThiDAO.getMaDeThi = getMaDeThi;
	}
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
	public ArrayList<CauHoi> getListCauHoi(String maDeThi) {
		// TODO Auto-generated method stub
		connect();
		String sql=	String.format("SELECT DeThi.MaDeThi,CauHoi.MaCauHoi,CauHoi.NoiDung,CauHoi.DapAn1,CauHoi.DapAn2,CauHoi.DapAn3,CauHoi.DapAn4"+
				" FROM CauHoi,DeThi,ChiTietDeThi"+
				" WHERE  CauHoi.MaCauHoi =ChiTietDeThi.MaCauHoi and ChiTietDeThi.MaDeThi=DeThi.MaDeThi and DeThi.MaDeThi='%s'", maDeThi);
	ResultSet rs = null;
	try {
		Statement stmt = connection.createStatement();
		rs = stmt.executeQuery(sql);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	ArrayList<CauHoi> list=new ArrayList<CauHoi>();
	CauHoi cauHoi ;
	try {
		while(rs.next()){
			cauHoi = new CauHoi();
			cauHoi.setMaDeThi(rs.getString("MaDeThi"));
			cauHoi.setMaCauHoi(rs.getInt("MaCauHoi"));
			cauHoi.setNoiDung(rs.getString("NoiDung"));
			cauHoi.setDapAn1(rs.getString("DapAn1"));
			cauHoi.setDapAn2(rs.getString("DapAn2"));
			cauHoi.setDapAn3(rs.getString("DapAn3"));
			cauHoi.setDapAn4(rs.getString("DapAn4"));
			list.add(cauHoi);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
	}
	public boolean CheckDeThi(String maDeThi) {
		// TODO Auto-generated method stub
		connect();
		String sql=String.format("SELECT MaDeThi FROM DeThi WHERE MaDeThi='%s'", maDeThi);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(rs.next()){
				return true;
			}
		}catch (SQLException e) {
		e.printStackTrace();
		}
		return false;
		
	}
	
	public ArrayList<LayTenMon> getMon(int maDeThi) {
		connect();
		String sql=String.format("SELECT Mon.MaMon,Mon.TenMon,DeThi.SoLuongCauHoi FROM Mon,DeThi WHERE Mon.MaMon=DeThi.MaMon and DeThi.MaDeThi='%s'", maDeThi);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
			LayTenMon layTenMon;
			ArrayList<LayTenMon> list=new ArrayList<LayTenMon>();
			try {
				while (rs.next()) {
					layTenMon=new LayTenMon();
					layTenMon.setMaMon(rs.getString("MaMon"));
					layTenMon.setTenMon(rs.getString("TenMon"));
					layTenMon.setSoLuong(rs.getInt("SoLuongCauHoi"));
					list.add(layTenMon);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return list;
	}
	//ghi dap an 
	public void setDapAn(String maDeThi, String maNguoiDung, int dapAnNguoiDung, int maCauHoi, Date test) {
		// TODO Auto-generated method stub
		connect();
		String sql=	String.format("Update KetQuaThi Set DapAnNguoiDung ='%s' , GioBatDau='%s' where MaNguoiDung=N'%s' and  maDeThi = '%s' and MaCauHoi='%s'",dapAnNguoiDung ,test, maNguoiDung , maDeThi , maCauHoi); 
					
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<LayNguoiDung> getNguoiDung(String maNguoiDung) {
		// TODO Auto-generated method stub
		connect();
		String sql=String.format("SELECT NguoiDung.MaNguoiDung FROM NguoiDung WHERE NguoiDung.maNguoiDung='%s'", maNguoiDung);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
			LayNguoiDung layNguoiDung;
			ArrayList<LayNguoiDung> list=new ArrayList<LayNguoiDung>();
			try {
				while (rs.next()) {
					layNguoiDung=new LayNguoiDung();
					layNguoiDung.setMaNguoiDung(rs.getString("MaNguoiDung"));
					list.add(layNguoiDung);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return list;
	}
	public ArrayList<CauHoi> getListCauHoi(int offset, int noOfRecords,String maDeThi,String maNguoiDung) {
		connect();
		String sql =String.format( "SELECT *"
			+ " FROM (  SELECT DeThi.MaDeThi,CauHoi.MaCauHoi,CauHoi.NoiDung,CauHoi.DapAn1,CauHoi.DapAn2,CauHoi.DapAn3,CauHoi.DapAn4,KetQuaThi.DapAnNguoiDung, ROW_NUMBER() over (ORDER BY CauHoi.MaCauHoi ) as ct from  ChiTietDeThi INNER JOIN CauHoi on CauHoi.MaCauHoi=ChiTietDeThi.MaCauHoi inner join DeThi on DeThi.MaDeThi=ChiTietDeThi.MaDeThi inner join KetQuaThi on KetQuaThi.MaDeThi=DeThi.MaDeThi Where KetQuaThi.MaCauHoi=ChiTietDeThi.MaCauHoi and DeThi.MaDeThi='%s' and KetQuaThi.MaNguoiDung='%s') " +
				"sub WHERE ( ct > "
			+ offset + " AND ct <= " + noOfRecords + " )",maDeThi,maNguoiDung);
	ArrayList<CauHoi> list = new ArrayList<CauHoi>();
	CauHoi cauHoi;
	ResultSet rs = null;
	try {
		connect();
		stmt = connection.createStatement();
		rs = stmt.executeQuery(sql);

		while (rs.next()) {
			cauHoi = new CauHoi();
			cauHoi.setMaDeThi(rs.getString("MaDeThi"));
			cauHoi.setMaCauHoi(rs.getInt("MaCauHoi"));
			cauHoi.setNoiDung(rs.getString("NoiDung"));
			cauHoi.setDapAn1(rs.getString("DapAn1"));
			cauHoi.setDapAn2(rs.getString("DapAn2"));
			cauHoi.setDapAn3(rs.getString("DapAn3"));
			cauHoi.setDapAn4(rs.getString("DapAn4"));
			cauHoi.setDapAn(rs.getString("DapAnNguoiDung"));
			list.add(cauHoi);
		}
		rs.close();
		rs = stmt.executeQuery("select count(*) as num from CauHoi");
		if (rs.next())
			this.noOfRecords = rs.getInt("num");
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			if (stmt != null)
				stmt.close();
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	return list;
	}
	public static int getNoOfRecords() {
		return noOfRecords;
	}

	/**
	 * @param noOfRecords
	 *            the noOfRecords to set
	 */
	public void setNoOfRecords(int noOfRecords) {
		this.noOfRecords = noOfRecords;
	}
	public int getSoLuong(String maDeThi) {
		connect();
		// TODO Auto-generated method stub
		String sql=String.format("SELECT SoLuongCauHoi FROM DeThi WHERE DeThi.MaDeThi='%s'", maDeThi);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int soLuong=0;
		try {
			if(rs.next()){
				return soLuong=rs.getInt("SoLuongCauHoi");
			}
		}catch (SQLException e) {
		e.printStackTrace();
		}
		return soLuong;
	}
	public int getSoCauTraLoiDung(String maDeThi, String maNguoiDung) {
		// TODO Auto-generated method stub
		connect();
		// TODO Auto-generated method stub
		String sql=String.format("select KETQUATHI.MaDeThi, COUNT(KETQUATHI.MaNguoiDung) as SoCauTraLoiDung From KETQUATHI,CAUHOI where CAUHOI.MaCauHoi=KETQUATHI.MaCauHoi and CAUHOI.DapAnDung=KETQUATHI.DapAnNguoiDung and KETQUATHI.MaDeThi='%s' and KETQUATHI.MaNguoiDung=N'%s' Group by KETQUATHI.MaDeThi ", maDeThi,maNguoiDung);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int soLuong=0;
		try {
			if(rs.next()){
				return soLuong=rs.getInt("SoCauTraLoiDung");
			}
		}catch (SQLException e) {
		e.printStackTrace();
		}
		return soLuong;
	}
	public String getTenMon(String maDeThi) {
		// TODO Auto-generated method stub
		connect();
		// TODO Auto-generated method stub
		String sql=String.format("select Mon.TenMon From Mon,DeThi where Mon.MaMon=DeThi.MaMon and DeThi.MaDeThi='%s'  ", maDeThi);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String tenMon=null;
		try {
			if(rs.next()){
				return tenMon=rs.getString("TenMon");
			}
		}catch (SQLException e) {
		e.printStackTrace();
		}
		return tenMon;
	}
	public void ghiDapAn(String maDeThi, String maNguoiDung, int maCauHoi, Date date) {
		// TODO Auto-generated method stub
		connect();
		String sql=	String.format("INSERT INTO KETQUATHI(MaDeThi,MaNguoiDung,MaCauHoi,GioBatDau) "+
					" VALUES ( '%s',N'%s','%s','%s' )", maDeThi,maNguoiDung,maCauHoi,date);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<CauHoi> getCauHoi(String maDeThi) {
		// TODO Auto-generated method stub
		connect();
		String sql=	String.format("SELECT ChiTietDeThi.MaCauHoi"+
				" FROM ChiTietDeThi"+
				" WHERE  ChiTietDeThi.MaDeThi='%s'", maDeThi);
	ResultSet rs = null;
	try {
		Statement stmt = connection.createStatement();
		rs = stmt.executeQuery(sql);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	ArrayList<CauHoi> list=new ArrayList<CauHoi>();
	CauHoi cauHoi ;
	try {
		while(rs.next()){
			cauHoi = new CauHoi();
			cauHoi.setMaDeThi(rs.getString("ChiTietDeThi.MaCauHoi"));
			list.add(cauHoi);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;

	}
	public ArrayList<KetQuaThi> getDapAn(String maDeThi, String maNguoiDung, int maCauHoi) {
		// TODO Auto-generated method stub
		connect();
		// TODO Auto-generated method stub
		String sql=String.format("select KETQUATHI.DapAnNguoiDung from KETQUATHI where KETQUATHI.MaNguoiDung=N'%s' and KETQUATHI.MaDeThi='%s' and KETQUATHI.MaCauHoi='%s'  ",maNguoiDung, maDeThi,maCauHoi);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<KetQuaThi> list=new ArrayList<KetQuaThi>();
		KetQuaThi ketQuaThi ;
		try {
			while(rs.next()){
				ketQuaThi=new KetQuaThi();
				ketQuaThi.setMaDeThi(maDeThi);
				ketQuaThi.setMaNguoiDung(maNguoiDung);
				ketQuaThi.setMaCauhoi(maCauHoi);
				ketQuaThi.setDapAnNguoiDung(rs.getInt("ChiTietDeThi.MaCauHoi"));
			
				list.add(ketQuaThi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public String getMaMon(String maDeThi) {
		// TODO Auto-generated method stub
		connect();
		// TODO Auto-generated method stub
		String sql=String.format("select Mon.MaMon From Mon,DeThi where Mon.MaMon=DeThi.MaMon and DeThi.MaDeThi='%s'  ", maDeThi);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String maMon=null;
		try {
			if(rs.next()){
				return maMon=rs.getString("MaMon");
			}
		}catch (SQLException e) {
		e.printStackTrace();
		}
		return maMon;
	}
	public void xoaKetQuaThi(String maDeThi, String maNguoiDung) {
		// TODO Auto-generated method stub
		connect();
		String sql=	String.format("Delete from KetQuaThi "+
					" Where KetQuaThi.MaDeThi='%s' and KetQuaThi.MaNguoiDung='%s'", maDeThi,maNguoiDung);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void luuDiem(String maNguoiDung, int maMon, double diem) {
		// TODO Auto-generated method stub
		connect();
		String sql=	String.format("INSERT INTO CHITIETNGUOIDUNG(MaNguoiDung,MaMon,DiemSo) "+
					" VALUES ( N'%s','%s','%s' )", maNguoiDung,maMon,diem);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int getThoiGian(String maDeThi) {
		// TODO Auto-generated method stub
		connect();
		// TODO Auto-generated method stub
		String sql=String.format("select DETHI.ThoiGianThi from DETHI where DETHI.MaDeThi='%s'  ", maDeThi);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int thoiGian=0;
		try {
			if(rs.next()){
				return thoiGian=rs.getInt("ThoiGianThi");
			}
		}catch (SQLException e) {
		e.printStackTrace();
		}
		return thoiGian;
	}
	public int getGiayChay(String maDeThi, String maNguoiDung) {
		connect();
		String sql=String.format("select MIN(GioBatDau) as thoiGian from KETQUATHI  where KetQuaThi.MaDeThi='%s' and KetQuaThi.MaNguoiDung='%s'  ", maDeThi,maNguoiDung);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int thoiGian=0;
		try {
			if(rs.next()){
				return thoiGian=rs.getInt("thoiGian");
			}
		}catch (SQLException e) {
		e.printStackTrace();
		}
		return thoiGian;
	}
	public void setGiay(String maDeThi, String maNguoiDung, int giay) {
		// TODO Auto-generated method stub
		connect();
		String sql=	String.format("Update KetQuaThi Set  GioBatDau='%s' where MaNguoiDung=N'%s' and  maDeThi = '%s'",giay , maNguoiDung , maDeThi); 
					
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public String getGioBatDau(String maNguoiDung) {
		// TODO Auto-generated method stub
		connect();
		String sql=String.format("select GioBatDau from KETQUATHI  where KetQuaThi.MaNguoiDung='%s'  ", maNguoiDung);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String thoiGian=null;
		try {
			if(rs.next()){
				return thoiGian=rs.getString("GioBatDau");
			}
		}catch (SQLException e) {
		e.printStackTrace();
		}
		return thoiGian;
	}
	public String getMaDeThi(String maNguoiDung) {
		// TODO Auto-generated method stub
		connect();
		String sql=String.format("select MaDeThi from KETQUATHI  where KetQuaThi.MaNguoiDung='%s'  ", maNguoiDung);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String maDeThi=null;
		try {
			if(rs.next()){
				return maDeThi=rs.getString("MaDeThi");
			}
		}catch (SQLException e) {
		e.printStackTrace();
		}
		return maDeThi;
	}

	
	
}

