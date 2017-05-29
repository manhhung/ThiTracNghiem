package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DanhSachCauHoiForm;
import form.DanhSachChiTietDeThiForm;
import model.bean.CauHoi;
import model.bean.ChiTietDeThi;
import model.bean.MonThi;
import model.bean.DeThi;
import model.bo.CauHoiBO;
import model.bo.ChiTietDeThiBO;
import model.bo.MonThiBO;
import model.bo.DeThiBO;

public class DanhSachChiTietDeThiAction extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DanhSachChiTietDeThiForm chiTietDeThiForm = (DanhSachChiTietDeThiForm) form;
		
		// lấy danh sách chi tiết đề thi
		
		ArrayList<ChiTietDeThi> listChiTietDeThi;
		ChiTietDeThiBO chiTietDeThiBO = new ChiTietDeThiBO();
		String maDeThi = chiTietDeThiForm.getMaDeThi();
		if(maDeThi == null || maDeThi.length() == 0){
			listChiTietDeThi = chiTietDeThiBO.getListChiTietDeThi(maDeThi);
		} else {
			listChiTietDeThi = chiTietDeThiBO.getListChiTietDeThi(maDeThi);
		}
		chiTietDeThiForm.setListChiTietDeThi(listChiTietDeThi);
		return mapping.findForward("dsChiTietDeThi");
		
		
	}

}
