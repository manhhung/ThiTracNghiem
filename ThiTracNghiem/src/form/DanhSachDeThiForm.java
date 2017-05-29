package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.MonThi;
import model.bean.DeThi;

public class DanhSachDeThiForm extends ActionForm {

	private String maMon;
	private ArrayList<MonThi> listMonThi;
	private ArrayList<DeThi> listDeThi;
	
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
	public ArrayList<DeThi> getListDeThi() {
		return listDeThi;
	}
	public void setListDeThi(ArrayList<DeThi> listDeThi) {
		this.listDeThi = listDeThi;
	}
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	

}
