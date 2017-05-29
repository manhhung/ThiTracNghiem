package action;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;



import model.bean.NguoiDung;
import model.bean.Quyen;
import model.bo.NguoiDungBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DanhSachTaiKhoanForm;

public class DanhSachTaiKhoanAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DanhSachTaiKhoanForm taiKhoanForm = (DanhSachTaiKhoanForm) form;
		
		ArrayList<NguoiDung> listNguoiDung;
		ArrayList<Quyen> listQuyen;
		NguoiDungBO nguoiDungBO = new NguoiDungBO();
		
		listNguoiDung = nguoiDungBO.getListNguoiDung();
		listQuyen=nguoiDungBO.getListQuyen1();
		taiKhoanForm.setListNguoiDung(listNguoiDung);
		taiKhoanForm.setListQuyen(listQuyen);
		HttpSession session = request.getSession();
		
		String thongBao = (String) session.getAttribute("thongBao");
		
		taiKhoanForm.setThongBao(thongBao);
		
		session.invalidate();
		
		
		return mapping.findForward("dsNguoiDung");
		
	}

}
