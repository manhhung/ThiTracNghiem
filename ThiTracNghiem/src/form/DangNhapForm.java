package form;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.NguoiDung;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.StringProcess;

public class DangNhapForm extends ActionForm{
	private String id;
	private String maNguoiDung;
	private String matKhau;
	private String thongBao;

	
	

	public String getThongBao() {
		return thongBao;
	}
	public void setThongBao(String thongBao) {
		this.thongBao = thongBao;
	}
	private ArrayList<NguoiDung> listNguoiDung;
	
	public ArrayList<NguoiDung> getListNguoiDung() {
		return listNguoiDung;
	}
	public void setListNguoiDung(ArrayList<NguoiDung> listNguoiDung) {
		this.listNguoiDung = listNguoiDung;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors actionErrors=new ActionErrors();
		if(StringProcess.notVaild(maNguoiDung)){
			actionErrors.add("tenDangNhapError",new ActionMessage("error.tenDangNhap"));
		}
		if(StringProcess.notVaild(matKhau)){
			actionErrors.add("matKhauError",new ActionMessage("error.matKhau"));
		}
	
		return actionErrors;
	}
}
