package model.bo;

import java.util.ArrayList;

import model.bean.CauHoi;
import model.bean.DeThi;
import model.dao.DeThiDAO;

public class DeThiBO {
	
	DeThiDAO deThiDAO = new DeThiDAO();

	public ArrayList<DeThi> getListDeThi() {
		return deThiDAO.getListDeThi();
	}

	public ArrayList<DeThi> getListDeThi(String maMon) {
		return deThiDAO.getListDeThi(maMon);
	}

	public void themDeThi(int maMon, int maDeThi, int thoiGianThi, int soLuongCauHoi) {
		deThiDAO.themDeThi(maMon, maDeThi, thoiGianThi, soLuongCauHoi);
		
	}

	public DeThi getThongTinDeThi(int maDeThi) {
		return deThiDAO.getThongTinDeThi(maDeThi);
	}

	public void capNhatDeThi(int maDeThi, int maMon, int thoiGianThi, int soLuongCauHoi) {
		deThiDAO.capNhatDeThi(maDeThi, maMon, thoiGianThi, soLuongCauHoi);
		
	}

	public void xoaCauHoi(int maDeThi) {
		deThiDAO.xoaDeThi(maDeThi);
		
	}
	

}
