package form;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.Gender;
import model.bean.MonThi;
import model.bean.NguoiDung;

public class NguoiDungForm extends ActionForm{
	private String maNguoiDung;
	private String matKhau;
	private String id;
	private String submit;
	private NguoiDung nguoiDung;
	private String thongBao;
	private ArrayList<NguoiDung> listQuyen;
	private ArrayList<MonThi> listMonThi;
	
	private String maMon;
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
	public ArrayList<NguoiDung> getListQuyen() {
		return listQuyen;
	}
	public void setListQuyen(ArrayList<NguoiDung> listQuyen) {
		this.listQuyen = listQuyen;
	}
	public String getThongBao() {
		return thongBao;
	}
	public void setThongBao(String thongBao) {
		this.thongBao = thongBao;
	}
	public String getMaNguoiDung() {
		return maNguoiDung;
	}
	public void setMaNguoiDung(String maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}
	
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	
	public NguoiDung getNguoiDung() {
		return nguoiDung;
	}
	public void setNguoiDung(NguoiDung nguoiDung) {
		this.nguoiDung = nguoiDung;
	}
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
