package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.CauHoi;
import model.bean.MonThi;
import model.bean.ChiTietDeThi;
import model.bean.DeThi;

public class DanhSachChiTietDeThiForm extends ActionForm {

	private String maCauHoi;
	private String maDeThi;
	private ArrayList<ChiTietDeThi> listChiTietDeThi;
	public String getMaCauHoi() {
		return maCauHoi;
	}
	public void setMaCauHoi(String maCauHoi) {
		this.maCauHoi = maCauHoi;
	}
	public String getMaDeThi() {
		return maDeThi;
	}
	public void setMaDeThi(String maDeThi) {
		this.maDeThi = maDeThi;
	}
	public ArrayList<ChiTietDeThi> getListChiTietDeThi() {
		return listChiTietDeThi;
	}
	public void setListChiTietDeThi(ArrayList<ChiTietDeThi> listChiTietDeThi) {
		this.listChiTietDeThi = listChiTietDeThi;
	}
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
}
