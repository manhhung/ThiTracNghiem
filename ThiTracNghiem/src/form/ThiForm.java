package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.CauHoi;
import model.bean.LayNguoiDung;
import model.bean.LayTenMon;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class ThiForm extends ActionForm{
	private ArrayList<CauHoi> listCauHoi;
	private int maDeThi;
	private int dapAn;
	private ArrayList<Integer> listPage;
	private int maCauHoi;
	private String noiDung;
	private String pA1;
	private String pA2;
	private String pA3;
	private String pA4;
	private String maMon;
	private String tenMon;
	private ArrayList<LayTenMon> listLayTenMon;
	private ArrayList<LayNguoiDung> listNguoiDung;
	private int thoiGian;
	private int phut ;
	private int giay;
	private int phutChay;
	private int giayChay;
	private long remainTime;
	public long getRemainTime() {
		return remainTime;
	}

	public void setRemainTime(long remainTime) {
		this.remainTime = remainTime;
	}

	public int getPhutChay() {
		return phutChay;
	}

	public void setPhutChay(int phutChay) {
		this.phutChay = phutChay;
	}

	public int getGiayChay() {
		return giayChay;
	}

	public void setGiayChay(int giayChay) {
		this.giayChay = giayChay;
	}

	public int getPhut() {
		return phut;
	}

	public void setPhut(int phut) {
		this.phut = phut;
	}

	public int getGiay() {
		return giay;
	}

	public void setGiay(int test) {
		this.giay = test;
	}

	public int getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(int thoiGian) {
		this.thoiGian = thoiGian;
	}

	public ArrayList<LayNguoiDung> getListNguoiDung() {
		return listNguoiDung;
	}

	public void setListNguoiDung(ArrayList<LayNguoiDung> listNguoiDung) {
		this.listNguoiDung = listNguoiDung;
	}

	private String maNguoiDung;



	public String getMaNguoiDung() {
		return maNguoiDung;
	}

	public void setMaNguoiDung(String maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}

	private String submit;
	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public ArrayList<LayTenMon> getListLayTenMon() {
		return listLayTenMon;
	}

	public void setListLayTenMon(ArrayList<LayTenMon> listLayTenMon) {
		this.listLayTenMon = listLayTenMon;
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

	public int getMaCauHoi() {
		return maCauHoi;
	}

	public void setMaCauHoi(int maCauHoi) {
		this.maCauHoi = maCauHoi;
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

	private int noOfPages;
	private int currentPage;
	public ArrayList<Integer> getListPage() {
		return listPage;
	}

	public void setListPage(ArrayList<Integer> listPage) {
		this.listPage = listPage;
	}

	public int getDapAn() {
		return dapAn;
	}

	public void setDapAn(int dapAn) {
		this.dapAn = dapAn;
	}

	public int getMaDeThi() {
		return maDeThi;
	}

	public void setMaDeThi(int maDeThi) {
		this.maDeThi = maDeThi;
	}

	public ArrayList<CauHoi> getListCauHoi() {
		return listCauHoi;
	}

	public void setListCauHoi(ArrayList<CauHoi> listCauHoi) {
		this.listCauHoi = listCauHoi;
	}
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	
}
