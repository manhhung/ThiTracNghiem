package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;



import model.bean.MonThi;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class DanhSachMonThiForm extends ActionForm{
	private ArrayList<MonThi> listMonThi;
	private String Back;
	

	

	public String getBack() {
		return Back;
	}

	public void setBack(String back) {
		Back = back;
	}

	public ArrayList<MonThi> getListMonThi() {
		return listMonThi;
	}

	public void setListMonThi(ArrayList<MonThi> listMonThi) {
		this.listMonThi = listMonThi;
	}
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
