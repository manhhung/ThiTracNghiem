package model.bean;

import java.sql.Date;

public class KetQuaThi {
	private String maNguoiDung;
	private String maDeThi;
	private int maCauhoi;
	private int dapAnNguoiDung;
	private Date gioBatDau;
	public String getMaNguoiDung() {
		return maNguoiDung;
	}
	public void setMaNguoiDung(String maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}
	public String getMaDeThi() {
		return maDeThi;
	}
	public void setMaDeThi(String maDeThi) {
		this.maDeThi = maDeThi;
	}
	public int getMaCauhoi() {
		return maCauhoi;
	}
	public void setMaCauhoi(int maCauhoi) {
		this.maCauhoi = maCauhoi;
	}
	public int getDapAnNguoiDung() {
		return dapAnNguoiDung;
	}
	public void setDapAnNguoiDung(int dapAnNguoiDung) {
		this.dapAnNguoiDung = dapAnNguoiDung;
	}
	public Date getGioBatDau() {
		return gioBatDau;
	}
	public void setGioBatDau(Date gioBatDau) {
		this.gioBatDau = gioBatDau;
	}
	
}
