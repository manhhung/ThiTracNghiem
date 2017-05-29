package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.Diem;
import model.bean.MonThi;



public class ThongKeDiemCaoForm extends ActionForm {
	private String maMon;
	private String tenMon;
	public String getTenMon() {
		return tenMon;
	}
	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}
	private ArrayList<MonThi> listMon;
	private ArrayList<Diem> listDiem;
	private String maNguoiDung;
	
	
	public String getMaNguoiDung() {
		return maNguoiDung;
	}
	public void setMaNguoiDung(String maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}
	public String getMaMon() {
		return maMon;
	}
	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}
	public ArrayList<MonThi> getListMon() {
		return listMon;
	}
	public void setListMon(ArrayList<MonThi> listMon) {
		this.listMon = listMon;
	}
	public ArrayList<Diem> getListDiem() {
		return listDiem;
	}
	public void setListDiem(ArrayList<Diem> listDiem) {
		this.listDiem = listDiem;
	}
	
	
}
