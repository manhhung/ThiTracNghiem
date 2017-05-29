package model.bo;

import java.util.ArrayList;
import java.util.Date;

import form.CauHoiForm;
import form.ThiForm;
import model.bean.CauHoi;
import model.bean.KetQuaThi;
import model.bean.LayNguoiDung;
import model.bean.LayTenMon;
import model.bean.NguoiDung;
import model.dao.ThiDAO;

public class ThiBO {
	ThiDAO thiDAO=new ThiDAO();

	public ArrayList<CauHoi> getListCauHoi(String maDeThi) {
		// TODO Auto-generated method stub
		return thiDAO.getListCauHoi(maDeThi);
	}
	public boolean CheckDeThi(String maDeThi) {
		// TODO Auto-generated method stub
		return thiDAO.CheckDeThi(maDeThi);
	}

	public ArrayList<LayTenMon> getMon(int maDeThi) {
		return thiDAO.getMon(maDeThi);
	}
	public ArrayList<CauHoi> getListCauHoi(int offset, int noOfRecords,String maDeThi,String maNguoiDung) {
		return thiDAO.getListCauHoi(offset, noOfRecords,maDeThi,maNguoiDung);
	}
	public ArrayList<LayNguoiDung> getNguoiDung(String maNguoiDung) {
		// TODO Auto-generated method stub
		return thiDAO.getNguoiDung(maNguoiDung);
	}
	public int getSoLuong(String maDeThi) {
		// TODO Auto-generated method stub
		return thiDAO.getSoLuong(maDeThi);
	}
	public void setDapAn(String maDeThi, String maNguoiDung, int dapAnNguoiDung,
			int maCauHoi, Date test) {
		// TODO Auto-generated method stub
		thiDAO.setDapAn(maDeThi, maNguoiDung, dapAnNguoiDung, maCauHoi,test);
	}
	public int getSoCauTraLoiDung(String maDeThi, String maNguoiDung) {
		// TODO Auto-generated method stub
		return thiDAO.getSoCauTraLoiDung(maDeThi,maNguoiDung);
	}
	public String getTenMon(String maDeThi) {
		// TODO Auto-generated method stub
		return thiDAO.getTenMon(maDeThi);
	}
	public void ghiDapAn(String maDeThi, String maNguoiDung, int maCauHoi, Date date) {
		// TODO Auto-generated method stub
		thiDAO.ghiDapAn(maDeThi,maNguoiDung,maCauHoi,date);
	}
	public ArrayList<CauHoi> getCauHoi(String maDeThi) {
		// TODO Auto-generated method stub
		return thiDAO.getCauHoi(maDeThi);
	}
	public ArrayList<KetQuaThi> getDapAn(String maDeThi, String maNguoiDung, int maCauHoi) {
		// TODO Auto-generated method stub
		return thiDAO.getDapAn(maDeThi,maNguoiDung,maCauHoi);
	}
	public String getMaMon(String maDeThi) {
		// TODO Auto-generated method stub
		return thiDAO.getMaMon(maDeThi);
	}
	public void xoaKetQuaThi(String maDeThi, String maNguoiDung) {
		// TODO Auto-generated method stub
		thiDAO.xoaKetQuaThi(maDeThi,maNguoiDung);
	}
	public void luuDiem(String maNguoiDung, int maMon, double diem) {
		// TODO Auto-generated method stub
		thiDAO.luuDiem(maNguoiDung,maMon,diem);
	}
	public int getThoiGian(String maDeThi) {
		// TODO Auto-generated method stub
		return thiDAO.getThoiGian(maDeThi);
	}
	public int getGiayChay(String maDeThi, String maNguoiDung) {
		// TODO Auto-generated method stub
		return thiDAO.getGiayChay(maDeThi,maNguoiDung);
	}
	public void setGiay(String maDeThi, String maNguoiDung, int giay) {
		// TODO Auto-generated method stub
		thiDAO.setGiay(maDeThi,maNguoiDung,giay);
	}
	public String getGioBatDau(String maNguoiDung) {
		// TODO Auto-generated method stub
		return thiDAO.getGioBatDau(maNguoiDung);
	}
	public String getMaDeThi(String maNguoiDung) {
		// TODO Auto-generated method stub
		return thiDAO.getMaDeThi(maNguoiDung);
	}

	
	
}
