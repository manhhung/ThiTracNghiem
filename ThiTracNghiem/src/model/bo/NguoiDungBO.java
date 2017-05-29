package model.bo;

import java.util.ArrayList;

import model.bean.CauHoi;
import model.bean.NguoiDung;
import model.bean.Quyen;
import model.dao.NguoiDungDAO;

public class NguoiDungBO {
	NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
	
	public ArrayList<NguoiDung> getListNguoiDung() {
		return nguoiDungDAO.getListNguoiDung();
}
	public void themTaiKhoan(String maNguoiDung, String matKhau, String id, String maMon) {
		nguoiDungDAO.themTaiKhoan(maNguoiDung, matKhau, id,maMon);
	}
	public void suaTaiKhoan(String maNguoiDung, String matKhau, String id, String maMon) {
		nguoiDungDAO.suaTaiKhoan(maNguoiDung, matKhau, id,maMon);
	}
	public NguoiDung getThongTinNguoiDung(String maNguoiDung) {
		return nguoiDungDAO.getThongTinNguoiDung(maNguoiDung);
	}
	public void xoaNguoiDung(String maNguoiDung)
	{
		 nguoiDungDAO.xoaNguoiDung(maNguoiDung);
	}
	public void themThongTinTaiKhoan(String maNguoiDung) {
		nguoiDungDAO.themThongTinTaiKhoan(maNguoiDung);
	}
	public String getMaTaiKhoanCSDL(String maTaiKhoan) {
		return nguoiDungDAO.getMaTaiKhoanCSDL(maTaiKhoan);
	}
	public ArrayList<NguoiDung> getListQuyen() {
		return nguoiDungDAO.getListQuyen();
	}
	public void xoaChiTietNguoiDung(String maNguoiDung) {
		// TODO Auto-generated method stub
		nguoiDungDAO.xoaChiTietNguoiDung(maNguoiDung);
	}
	public ArrayList<Quyen> getListQuyen1() {
		// TODO Auto-generated method stub
		return nguoiDungDAO.getListQuyen1();
	}

	
}
