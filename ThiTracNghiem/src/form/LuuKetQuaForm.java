package form;

import org.apache.struts.action.ActionForm;

public class LuuKetQuaForm extends ActionForm{
	private String maNguoiDung;
	private float soLuong;
	private float soCauTraLoiDung;
	private double diem;
	private String maDeThi;
	private String tenMon;
	public String getTenMon() {
		return tenMon;
	}
	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}
	public void setSoCauTraLoiDung(float soCauTraLoiDung) {
		this.soCauTraLoiDung = soCauTraLoiDung;
	}
	public String getMaDeThi() {
		return maDeThi;
	}
	public void setMaDeThi(String maDeThi) {
		this.maDeThi = maDeThi;
	}
	public String getMaNguoiDung() {
		return maNguoiDung;
	}
	public void setMaNguoiDung(String maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}
	public float getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(float soLuong) {
		this.soLuong = soLuong;
	}
	public float getSoCauTraLoiDung() {
		return soCauTraLoiDung;
	}
	public void setSoCauTraLoiDung(int soCauTraLoiDung) {
		this.soCauTraLoiDung = soCauTraLoiDung;
	}
	public double getDiem() {
		return diem;
	}
	public void setDiem(double diem) {
		this.diem = diem;
	}
	
	
}
