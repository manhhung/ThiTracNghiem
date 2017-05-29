package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.Diem;
import model.bean.MonThi;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class DiemForm extends ActionForm {
	private String maNguoiDung;
	private String tenMon;
	private int diemSo;
	private String maMon;
	private ArrayList<MonThi> listMon;
	private Diem diem;
	public String getMaNguoiDung() {
		return maNguoiDung;
	}
	public void setMaNguoiDung(String maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}
	public String getTenMon() {
		return tenMon;
	}
	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}

	public String getMaMon() {
		return maMon;
	}
	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}
	public int getDiemSo() {
		return diemSo;
	}
	public void setDiemSo(int diemSo) {
		this.diemSo = diemSo;
	}
	public ArrayList<MonThi> getListMon() {
		return listMon;
	}
	public void setListMon(ArrayList<MonThi> listMon) {
		this.listMon = listMon;
	}
	public Diem getDiem() {
		return diem;
	}
	public void setDiem(Diem diem) {
		this.diem = diem;
	}
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
