package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DanhSachCauHoiForm;
import model.bean.CauHoi;
import model.bean.MonThi;
import model.bo.CauHoiBO;
import model.bo.MonThiBO;

public class DanhSachCauHoiAction extends Action{
	
		public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DanhSachCauHoiForm cauHoiForm = (DanhSachCauHoiForm) form;
		HttpSession session=request.getSession();
	String maNguoiDung=	(String) session.getAttribute("maNguoiDung");
		//lấy danh sách môn thi
		MonThiBO monThiBO = new MonThiBO();
		ArrayList<MonThi> listMonThi = monThiBO.getListMonThi(maNguoiDung);
		cauHoiForm.setListMonThi(listMonThi);
		System.out.println(cauHoiForm.getMaMon());
		//lấy danh sách câu hỏi
		ArrayList<CauHoi> listCauHoi;
		CauHoiBO cauHoiBO = new CauHoiBO();
		String maMon = cauHoiForm.getMaMon();
	//	if(maMon == null || maMon.length() == 0){
	//		listCauHoi = cauHoiBO.getListCauHoi();
	//	} else {
			listCauHoi = cauHoiBO.getListCauHoi(maMon);
	//	}
		cauHoiForm.setListCauHoi(listCauHoi);
		return mapping.findForward("dsCauHoi");
			
		
	}
}

