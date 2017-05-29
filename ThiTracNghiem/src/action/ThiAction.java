package action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.CauHoi;
import model.bean.KetQuaThi;
import model.bean.LayNguoiDung;
import model.bo.ThiBO;
import model.dao.ThiDAO;
import model.bean.LayTenMon;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.taglibs.standard.lang.jpath.adapter.Convert;

import antlr.Parser;
import form.GiaoDienBatDauForm;
import form.ThiForm;

public class ThiAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		

		ThiForm thiForm=(ThiForm) form;
		ThiBO thiBO=new ThiBO();
		int page=1;
		int recordsPerPage = 1;
		int noOfRecords=0;
		int noOfPages=0;
		HttpSession session=request.getSession();
		//String maDeThi=  (String) session.getAttribute("maDeThi");
		String maNguoiDung=(String) session.getAttribute("maNguoiDung");
		Date start = (Date)session.getAttribute("start");
		String maDeThi=thiBO.getMaDeThi(maNguoiDung);
		String test=thiBO.getGioBatDau(maNguoiDung);
		
		
		
		int thoiGian=thiBO.getThoiGian(maDeThi);
		int giay=thoiGian;
		int totalSeconds=giay;
		System.out.println("thoi gian thi"+totalSeconds);
	//	int totalSeconds = Integer.parseInt(session.getAttribute("seconds").toString());
		
	//	long t = start.getTime();
		DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		
		Date startDate = formatter.parse(test);
		long t=startDate.getTime();
		
	//	int totalSeconds=giay;
		Date end = new Date(t + totalSeconds * 60000);
		Date current = new Date();
		
		long remainTime = (end.getTime() - current.getTime()) / 1000;
	
		if(remainTime <= 0){
			//ket thuc => chuyen trang
			thiBO.xoaKetQuaThi(maDeThi,maNguoiDung);
			return mapping.findForward("xemKetQua");
		}
		
		thiForm.setRemainTime(remainTime);
		
		
		//lay ma de thi va ma nguoi dung
	
	
		
		if(request.getParameter("page") != null){
		
			page = Integer.parseInt(request.getParameter("page"));
			System.out.println("page get = "+page);
			thiForm.setCurrentPage(page);
		
			
		}
			ArrayList<CauHoi> listCauHoi;
			ArrayList<Integer> listPage = new ArrayList<Integer>();
			
			thiForm.setMaNguoiDung(maNguoiDung);
			// lay ten mon thi
			String tenMon=thiBO.getTenMon(maDeThi);
			thiForm.setTenMon(tenMon);
			
			listCauHoi = thiBO.getListCauHoi((page-1)*recordsPerPage,recordsPerPage*page,maDeThi,maNguoiDung);
			
			
			
			noOfRecords = thiBO.getSoLuong(maDeThi);
			
			noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
			for(int i=1;i<=noOfPages;i++){
				listPage.add(i);
			}
			
			thiForm.setListCauHoi(listCauHoi);
			thiForm.setListPage(listPage);
			int dapAnNguoiDung=thiForm.getDapAn();
			int maCauHoi=thiForm.getMaCauHoi();
			//System.out.println(thiForm.getCurrentPage());
			System.out.println("CurrentPage = " + page);
			thiForm.setNoOfPages(noOfPages);
			System.out.println("noOfPages = " + noOfPages);
			
			String s = "Tiếp tục";
			s = thiForm.getSubmit();
			if(s != null){
				
				thiBO.setDapAn(maDeThi,maNguoiDung,dapAnNguoiDung,maCauHoi,startDate);
				
				
				
			}
			return mapping.findForward("dsCauHoi");
	}
}
