package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DanhSachDeThiForm;
import model.bean.DeThi;
import model.bean.MonThi;
import model.bo.DeThiBO;
import model.bo.MonThiBO;

public class DanhSachDeThiAction extends Action{
	
		public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DanhSachDeThiForm deThiForm = (DanhSachDeThiForm) form;
		HttpSession session=request.getSession();
		String maNguoiDung=	(String) session.getAttribute("maNguoiDung");
		//lấy danh sách môn thi
		MonThiBO monThiBO = new MonThiBO();
		ArrayList<MonThi> listMonThi = monThiBO.getListMonThi(maNguoiDung);
		deThiForm.setListMonThi(listMonThi);
		
		//lấy danh sách đề thi
		ArrayList<DeThi> listDeThi;
		DeThiBO deThiBO = new DeThiBO();
		String maMon = deThiForm.getMaMon();
	//	if(maMon == null || maMon.length() == 0){
	//		listDeThi = deThiBO.getListDeThi();
	//	} else {
			listDeThi = deThiBO.getListDeThi(maMon);
	//	}
		deThiForm.setListDeThi(listDeThi);
		return mapping.findForward("dsDeThi");
			
		
	}
}

