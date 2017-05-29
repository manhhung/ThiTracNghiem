package model.bo;

import java.util.ArrayList;

import model.bean.Diem;

import model.dao.DiemDAO;


public class DiemBO {
	DiemDAO diemDAO = new DiemDAO();
	public ArrayList<Diem> getListDiem() {
		return diemDAO.getListDiem();	
	}
	public ArrayList<Diem> getListDiem(String maMon) {
		return diemDAO.getListDiem(maMon);
	}
}
