package model.bo;

import java.util.ArrayList;

import model.bean.CauHoi;
import model.dao.CauHoiDAO;

public class CauHoiBO {
	CauHoiDAO cauHoiDAO = new CauHoiDAO();
	
	public ArrayList<CauHoi> getListCauHoi(){
		return cauHoiDAO.getListCauHoi();
	}
	
	public ArrayList<CauHoi> getListCauHoi(String maMon){
		return cauHoiDAO.getListCauHoi(maMon);
	}
	
	public void themCauHoi(String maMon, String noiDung, String dapAn1, String dapAn2,	String dapAn3, String dapAn4, int dapAnDung){
		cauHoiDAO.themCauHoi(maMon, noiDung, dapAn1, dapAn2, dapAn3, dapAn4, dapAnDung);
	}

	public void capNhatCauHoi(int maCauHoi, String maMon, String noiDung, String dapAn1, String dapAn2, String dapAn3, String dapAn4, int dapAnDung){
		cauHoiDAO.capNhatCauHoi(maCauHoi, maMon, noiDung, dapAn1, dapAn2, dapAn3, dapAn4, dapAnDung);
	}

	public CauHoi getThongTinCauHoi(int maCauHoi) {
		return cauHoiDAO.getThongTinCauHoi(maCauHoi);
	}

	public void xoaCauHoi(int maCauHoi) {
		cauHoiDAO.xoaCauHoi(maCauHoi);
		
	}
	
	/*
	public CauHoi getThongTinCauHoi(String maCauHoi){
		return cauHoiDAO.getThongTinCauHoi(maCauHoi);
	}
	
	public void suaCauHoi(String maCauHoi, String maMon, String cauHoi, String dapAn1, String dapAn2,	String dapAn3, String dapAn4, String dapAnDung){
		cauHoiDAO.suaCauHoi(maCauHoi, maMon, cauHoi, dapAn1, dapAn2, dapAn3, dapAn4, dapAnDung);
	}
	
	public void xoaCauHoi(String maCauHoi){
		cauHoiDAO.xoaCauHoi(maCauHoi);
	}
	*/
}
