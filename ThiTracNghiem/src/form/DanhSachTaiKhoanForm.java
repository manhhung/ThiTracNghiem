package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.Gender;
import model.bean.NguoiDung;
import model.bean.Quyen;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class DanhSachTaiKhoanForm extends ActionForm{
	
	private String thongBao;
	
	private ArrayList<NguoiDung> listNguoiDung;
	private ArrayList<Quyen> listQuyen;

	public ArrayList<Quyen> getListQuyen() {
		return listQuyen;
	}




	public void setListQuyen(ArrayList<Quyen> listQuyen) {
		this.listQuyen = listQuyen;
	}




	public ArrayList<NguoiDung> getListNguoiDung() {
		return listNguoiDung;
	}

	
	

	public void setListNguoiDung(ArrayList<NguoiDung> listNguoiDung) {
		this.listNguoiDung = listNguoiDung;
	}

	public String getThongBao() {
		return thongBao;
	}

	public void setThongBao(String thongBao) {
		this.thongBao = thongBao;
	}
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	
}
