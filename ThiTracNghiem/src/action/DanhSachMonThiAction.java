package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.MonThi;


import model.bo.MonThiBO;



import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DanhSachMonThiForm;



public class DanhSachMonThiAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DanhSachMonThiForm monThiForm = (DanhSachMonThiForm) form;
		HttpSession session=request.getSession();
		String maNguoiDung=	(String) session.getAttribute("maNguoiDung");
		//nhấn nút back
		if("Back".equals(monThiForm.getBack())){
			return mapping.findForward("dgMon");
		}
		
		//lay danh sach 
		ArrayList<MonThi> listMonThi;
		MonThiBO monThiBO = new MonThiBO();
			listMonThi = monThiBO.getListMonThi1();
		monThiForm.setListMonThi(listMonThi);

		return mapping.findForward("dsMonThi");
	}
}
