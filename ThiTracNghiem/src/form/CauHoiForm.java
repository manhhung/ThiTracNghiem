package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.MonThi;
import model.bean.Pair;
import model.bean.CauHoi;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.StringProcess;

public class CauHoiForm extends ActionForm {

	private int maCauHoi;
	private String maMon;
	private String noiDung;
	private String dapAn1;
	private String dapAn2;
	private String dapAn3;
	private String dapAn4;
	private int dapAnDung;
	private String tenMon;
	private String action;
	private ArrayList<MonThi> listMonThi;
	private String submit;
	private CauHoi cauHoi;
	private Pair[] pair= {new Pair("1","Phương án 1"), new Pair("2","Phương án 2"), new Pair("3","Phương án 3"), new Pair("4","Phương án 4")};
	private Pair pair2 = new Pair("4","Viet Nam");
	
	
	
	public Pair[] getPair() {
		return pair;
	}
	public void setPair(Pair[] pair) {
		this.pair = pair;
	}
	public Pair getPair2() {
		return pair2;
	}
	public void setPair2(Pair pair2) {
		this.pair2 = pair2;
	}
	public int getMaCauHoi() {
		return maCauHoi;
	}
	public void setMaCauHoi(int maCauHoi) {
		this.maCauHoi = maCauHoi;
	}

	public String getMaMon() {
		return maMon;
	}
	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public String getDapAn1() {
		return dapAn1;
	}
	public void setDapAn1(String dapAn1) {
		this.dapAn1 = dapAn1;
	}
	public String getDapAn2() {
		return dapAn2;
	}
	public void setDapAn2(String dapAn2) {
		this.dapAn2 = dapAn2;
	}
	public String getDapAn3() {
		return dapAn3;
	}
	public void setDapAn3(String dapAn3) {
		this.dapAn3 = dapAn3;
	}
	public String getDapAn4() {
		return dapAn4;
	}
	public void setDapAn4(String dapAn4) {
		this.dapAn4 = dapAn4;
	}
	public int getDapAnDung() {
		return dapAnDung;
	}
	public void setDapAnDung(int dapAnDung) {
		this.dapAnDung = dapAnDung;
	}
	public String getTenMon() {
		return tenMon;
	}
	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public ArrayList<MonThi> getListMonThi() {
		return listMonThi;
	}
	public void setListMonThi(ArrayList<MonThi> listMonThi) {
		this.listMonThi = listMonThi;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public CauHoi getCauHoi() {
		return cauHoi;
	}
	public void setCauHoi(CauHoi cauHoi) {
		this.cauHoi = cauHoi;
	}
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
}
