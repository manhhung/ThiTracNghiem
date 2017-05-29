package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.NguoiDungBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.NguoiDungForm;

public class XoaTaiKhoanAction extends Action{
	
	      @Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		NguoiDungForm nguoiDungForm = (NguoiDungForm) form;
		NguoiDungBO nguoiDungBO = new NguoiDungBO();
		String maNguoiDung = nguoiDungForm.getMaNguoiDung();
		nguoiDungBO.xoaNguoiDung(maNguoiDung);
		nguoiDungBO.xoaChiTietNguoiDung(maNguoiDung);
		String thongBao = "Xóa thành công!!!";
		HttpSession session = request.getSession();
		session.setAttribute("thongBao", thongBao);
		
		return mapping.findForward("xoaTaiKhoan");
		
	}
}
	   