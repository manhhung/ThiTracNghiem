package model.bo;

import java.util.ArrayList;

import form.ThongTinNguoiDungForm;


import model.bean.ThongTinNguoiDung;
import model.dao.ThongTinNguoiDungDAO;

public class ThongTinNguoiDungBO {
	ThongTinNguoiDungDAO thongTinNguoiDungDAO = new ThongTinNguoiDungDAO();
	
	public ArrayList<ThongTinNguoiDung> getListThongTinNguoiDung() {
		return thongTinNguoiDungDAO.getListThongTinNguoiDung();
	}
	public void suaThongTinTaiKhoan(String maNguoiDung, String tenNguoiDung, int gioiTinh,String ngaySinh,
			String diaChi, String soDienThoai) {
		thongTinNguoiDungDAO.suaThongTinTaiKhoan(maNguoiDung, tenNguoiDung, gioiTinh,
				ngaySinh,diaChi,soDienThoai);
	}
	public ThongTinNguoiDung getThongTinChiTietNguoiDung(String maNguoiDung)
	{
		return thongTinNguoiDungDAO.getThongTinChiTietNguoiDung(maNguoiDung);
	}
	
}
