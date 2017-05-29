package form;

import java.io.UnsupportedEncodingException;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import model.bean.Gender;
import model.bean.NguoiDung;
import model.bean.ThongTinNguoiDung;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.StringProcess;

public class ThongTinNguoiDungForm extends ActionForm{
	private String maNguoiDung;
	private String tenNguoiDung;
	private int gioiTinh;
	private String ngaySinh;
	private String diaChi;
	private String soDienThoai;
	private String submit;

	private NguoiDung nguoiDung;
	private ThongTinNguoiDung thongTinNguoiDung;
	private Gender[] gender = {new Gender("1","Nam"),new Gender("0","Nữ")};
	public Gender[] getGender() {
		return gender;
	}
	
	
	public ThongTinNguoiDung getThongTinNguoiDung() {
		return thongTinNguoiDung;
	}


	public void setThongTinNguoiDung(ThongTinNguoiDung thongTinNguoiDung) {
		this.thongTinNguoiDung = thongTinNguoiDung;
	}

	public void setGender(Gender[] gender) {
		this.gender = gender;
	}
	public String getMaNguoiDung() {
		return maNguoiDung;
	}
	public void setMaNguoiDung(String maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}
	public String getTenNguoiDung() {
		return tenNguoiDung;
	}
	public void setTenNguoiDung(String tenNguoiDung) {
		this.tenNguoiDung = tenNguoiDung;
	}
	public int getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	
	public NguoiDung getNguoiDung() {
		return nguoiDung;
	}
	public void setNguoiDung(NguoiDung nguoiDung) {
		this.nguoiDung = nguoiDung;
	}
	

	


	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
