package model.bo;

import java.util.ArrayList;

import model.bean.MonThi;
import model.dao.MonThiDAO;

public class MonThiBO {
	MonThiDAO monThiDAO = new MonThiDAO();
	public ArrayList<MonThi> getListMonThi(String maNguoiDung) {
		return monThiDAO.getListMonThi(maNguoiDung);
	}
	public void themMonThi(String maMon, String tenMon) {
		monThiDAO.themMonThi(maMon, tenMon);
	}
	public MonThi getThongTinMonThi(String maMon) {
		return monThiDAO.getThongTinMonThi(maMon);
	}
	public void suaMonThi(String maMon, String tenMon) {
		monThiDAO.suaMonThi(maMon, tenMon);	
	}
	public void xoaMonThi(String maMon) {
		monThiDAO.xoaMon(maMon);
	}
	public String getMaMonSoSanh(String maMon) {
		return monThiDAO.getMaMonSoSanh(maMon);
	}
	public void xoaDeThi(String maMon) {
		monThiDAO.xoaDeThi(maMon);
		
	}
	public void xoaDiem(String maNguoiDung, String maMon1) {
		// TODO Auto-generated method stub
		monThiDAO.xoaDiem(maNguoiDung,maMon1);
	}
	public ArrayList<MonThi> getListMonThi1() {
		// TODO Auto-generated method stub
		return monThiDAO.getListMonThi1();
	}
	
}
