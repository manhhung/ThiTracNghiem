package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.MonThi;
import model.bean.Pair;
import model.bean.CauHoi;
import model.bean.DeThi;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.StringProcess;

public class DeThiForm extends ActionForm{
	
	private int maDeThi;
	private int maMon;
	private String tenMon;
	private int thoiGianThi;
	private int soLuongCauHoi;
	private String action;
	private ArrayList<MonThi> listMonThi;
	private String submit;
	private DeThi deThi;
	
	private String thongBao;
	

	public String getThongBao() {
		return thongBao;
	}
	public void setThongBao(String thongBao) {
		this.thongBao = thongBao;
	}
	public int getMaDeThi() {
		return maDeThi;
	}
	public void setMaDeThi(int maDeThi) {
		this.maDeThi = maDeThi;
	}
	public int getMaMon() {
		return maMon;
	}
	public void setMaMon(int maMon) {
		this.maMon = maMon;
	}
	public String getTenMon() {
		return tenMon;
	}
	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}
	public int getThoiGianThi() {
		return thoiGianThi;
	}
	public void setThoiGianThi(int thoiGianThi) {
		this.thoiGianThi = thoiGianThi;
	}
	public int getSoLuongCauHoi() {
		return soLuongCauHoi;
	}
	public void setSoLuongCauHoi(int soLuongCauHoi) {
		this.soLuongCauHoi = soLuongCauHoi;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public ArrayList<MonThi> getListMonThi() {
		return listMonThi;
	}
	public void setListMonThi(ArrayList<MonThi> listMonThi) {
		this.listMonThi = listMonThi;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public DeThi getDeThi() {
		return deThi;
	}
	public void setDeThi(DeThi deThi) {
		this.deThi = deThi;
	}
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}


}
