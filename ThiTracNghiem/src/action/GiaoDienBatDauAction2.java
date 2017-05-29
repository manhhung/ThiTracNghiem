package action;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.CauHoi;
import model.bean.DeThi;
import model.bean.LayNguoiDung;
import model.bean.LayTenMon;
import model.bean.NguoiDung;
import model.bo.ThiBO;
import model.dao.ThiDAO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;



import form.GiaoDienBatDauForm;
import form.GiaoDienBatDauForm2;
import form.ThiForm;

public class GiaoDienBatDauAction2 extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		GiaoDienBatDauForm2 giaoDienBatDauForm=(GiaoDienBatDauForm2) form;
		String maDeThi=giaoDienBatDauForm.getMaDeThi();
		ThiBO thiBO=new ThiBO();
		int noOfRecords=0;
		HttpSession session =request.getSession();
		session.setAttribute("maDeThi", maDeThi);
		String maNguoiDung=	(String) session.getAttribute("maNguoiDung");

		int thoiGian=thiBO.getThoiGian(maDeThi);
		int giay=thoiGian;
		ArrayList<CauHoi> listCauHoi=thiBO.getListCauHoi(maDeThi);
		noOfRecords = thiBO.getSoLuong(maDeThi);
		Date date = new Date();
		
		//HttpSession sStartTime =request.getSession();
		session.setAttribute("start", date);
		session.setAttribute("seconds", giay);
		if(thiBO.CheckDeThi(maDeThi)){
			thiBO.xoaKetQuaThi(maDeThi, maNguoiDung);
			for(int i=0;i<noOfRecords;i++){
				
			CauHoi cauHoi=listCauHoi.get(i);
			giaoDienBatDauForm.setMaNguoiDung(maNguoiDung);
			int maCauHoi= cauHoi.getMaCauHoi();
		
			System.out.println(giay);
			thiBO.ghiDapAn(maDeThi, maNguoiDung,maCauHoi,date );
			}
			
			return mapping.findForward("thanhCong");
		}else {
			giaoDienBatDauForm.setThongBao("Mã đề thi sai");
			return mapping.findForward("thatBai");
		}
			
		
	}
}