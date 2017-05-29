package form;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import model.bean.MonThi;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class MonThiForm extends ActionForm{
	private String maMon;
	private String tenMon;
	private String submit;

	private MonThi monThi;
	private String thongBaoMa;
	private String thongBaoTen;
	
	
	public String getThongBaoTen() {
		return thongBaoTen;
	}
	public void setThongBaoTen(String thongBaoTen) {
		this.thongBaoTen = thongBaoTen;
	}
	public String getThongBaoMa() {
		return thongBaoMa;
	}
	public void setThongBaoMa(String thongBaoMa) {
		this.thongBaoMa = thongBaoMa;
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
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	
	
	public MonThi getMonThi() {
		return monThi;
	}
	public void setMonThi(MonThi monThi) {
		this.monThi = monThi;
	}
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
}
