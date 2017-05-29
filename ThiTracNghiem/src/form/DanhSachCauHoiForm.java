package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.StringProcess;

import model.bean.CauHoi;
import model.bean.MonThi;

public class DanhSachCauHoiForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maMon;
	private ArrayList<MonThi> listMonThi;
	private ArrayList<CauHoi> listCauHoi;
	public String getMaMon() {
		return maMon;
	}
	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}
	public ArrayList<MonThi> getListMonThi() {
		return listMonThi;
	}
	public void setListMonThi(ArrayList<MonThi> listMonThi) {
		this.listMonThi = listMonThi;
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
