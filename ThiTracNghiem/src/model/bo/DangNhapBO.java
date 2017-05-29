package model.bo;

import java.util.ArrayList;

import form.DangNhapForm;
import model.bean.NguoiDung;
import model.dao.DangNhapDAO;

public class DangNhapBO {
	DangNhapDAO dangNhapDAO =new DangNhapDAO();
	public String checkLogin(String maNguoiDung, String matKhau) {
		// TODO Auto-generated method stub
		return dangNhapDAO.checkLogin(maNguoiDung,matKhau);
	}
	public DangNhapForm getDangNhap(String maNguoiDung,String matKhau) {
		return dangNhapDAO.getDangNhap(maNguoiDung, matKhau);
	}
	public ArrayList<NguoiDung> setListNguoiDung(String maNguoiDung) {
		// TODO Auto-generated method stub
		return dangNhapDAO.setListNguoiDung(maNguoiDung);
	}
	public Object checkLamBai(String maNguoiDung) {
		// TODO Auto-generated method stub
		return dangNhapDAO.checkLamBai(maNguoiDung);
	}
	

}
