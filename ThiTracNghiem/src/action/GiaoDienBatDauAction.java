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
import net.sourceforge.jtds.jdbc.DateTime;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import form.GiaoDienBatDauForm;
import form.ThiForm;

public class GiaoDienBatDauAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		GiaoDienBatDauForm giaoDienBatDauForm=(GiaoDienBatDauForm) form;
		String maDeThi=giaoDienBatDauForm.getMaDeThi();
		ThiBO thiBO=new ThiBO();
		int noOfRecords=0;
		HttpSession session =request.getSession();
		//session.setAttribute("maDeThi", maDeThi);
		String maNguoiDung=	(String) session.getAttribute("maNguoiDung");
		giaoDienBatDauForm.setMaNguoiDung(maNguoiDung);
		ArrayList<CauHoi> listCauHoi=thiBO.getListCauHoi(maDeThi);
		noOfRecords = thiBO.getSoLuong(maDeThi);
		
		if(thiBO.CheckDeThi(maDeThi)){
			thiBO.xoaKetQuaThi(maDeThi, maNguoiDung);
			
			int thoiGian=thiBO.getThoiGian(maDeThi);
			int giay=thoiGian;
			
			//Ghi lai thoi gian bat dau
			//tao 1 session thoi gian bat dau luu lai sesion thoi gian bat dau vơi lai thoi gian thi
			Date date = new Date();
			
			//HttpSession sStartTime =request.getSession();
			//session.setAttribute("start", date);
			//session.setAttribute("seconds", giay);
			for(int i=0;i<noOfRecords;i++)
			{
				
				CauHoi cauHoi=listCauHoi.get(i);
				giaoDienBatDauForm.setMaNguoiDung(maNguoiDung);
				int maCauHoi= cauHoi.getMaCauHoi();			
				
				thiBO.ghiDapAn(maDeThi, maNguoiDung,maCauHoi,date );			
			
			}
			
			
			
			return mapping.findForward("thanhCong");
		}else {
			
			giaoDienBatDauForm.setThongBao("Mã đề thi sai");
			return mapping.findForward("thatBai");
		}
			
		
	}
}