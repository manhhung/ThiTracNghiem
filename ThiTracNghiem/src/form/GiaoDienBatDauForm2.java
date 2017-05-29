package form;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.CauHoi;
import model.bean.LayNguoiDung;
import model.bean.LayTenMon;
import model.bean.NguoiDung;


import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
import common.StringProcess;

public class GiaoDienBatDauForm2 extends ActionForm{
	private String maDeThi;
	private String maNguoiDung;
	private ArrayList<LayNguoiDung> listNguoiDung;
	private int noOfPages;
	private int currentPage;
	private String thongBao;
	private int thoiGian;
	public int getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(int thoiGian) {
		this.thoiGian = thoiGian;
	}

	public String getThongBao() {
		return thongBao;
	}

	public void setThongBao(String thongBao) {
		this.thongBao = thongBao;
	}

	public int getNoOfPages() {
		return noOfPages;
	}

	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public ArrayList<Integer> getListPage() {
		return listPage;
	}

	public void setListPage(ArrayList<Integer> listPage) {
		this.listPage = listPage;
	}

	private ArrayList<Integer> listPage;

	public ArrayList<LayNguoiDung> getListNguoiDung() {
		return listNguoiDung;
	}

	public void setListNguoiDung(ArrayList<LayNguoiDung> listNguoiDung) {
		this.listNguoiDung = listNguoiDung;
	}

	private ArrayList<CauHoi> listCauHoi;
	private ArrayList<LayTenMon> listLayTenMon;
	private String maCauHoi;
	private String noiDung;
	private String pA1;
	private String pA2;
	private String pA3;
	public String getMaCauHoi() {
		return maCauHoi;
	}

	public void setMaCauHoi(String maCauHoi) {
		this.maCauHoi = maCauHoi;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public String getpA1() {
		return pA1;
	}

	public void setpA1(String pA1) {
		this.pA1 = pA1;
	}

	public String getpA2() {
		return pA2;
	}

	public void setpA2(String pA2) {
		this.pA2 = pA2;
	}

	public String getpA3() {
		return pA3;
	}

	public void setpA3(String pA3) {
		this.pA3 = pA3;
	}

	public String getpA4() {
		return pA4;
	}

	public void setpA4(String pA4) {
		this.pA4 = pA4;
	}

	public String getMaMon() {
		return maMon;
	}

	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}

	public String getTenMon() {
		return tenMon;
	}

	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}

	private String pA4;
	private String maMon;
	private String tenMon;
	public ArrayList<CauHoi> getListCauHoi() {
		return listCauHoi;
	}

	public void setListCauHoi(ArrayList<CauHoi> listCauHoi) {
		this.listCauHoi = listCauHoi;
	}

	public ArrayList<LayTenMon> getListLayTenMon() {
		return listLayTenMon;
	}

	public void setListLayTenMon(ArrayList<LayTenMon> listLayTenMon) {
		this.listLayTenMon = listLayTenMon;
	}

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
	

}
