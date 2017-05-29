package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import model.bean.NguoiDung;
import model.bo.DangNhapBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DangNhapForm;



public class DangNhapAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		DangNhapForm dangNhapForm = (DangNhapForm) form;
		DangNhapBO dangNhapBO=new DangNhapBO();
		
		String maNguoiDung = dangNhapForm.getMaNguoiDung();
		String matKhau = dangNhapForm.getMatKhau();
		ArrayList<NguoiDung> listNguoiDung = dangNhapBO.setListNguoiDung(maNguoiDung);
		dangNhapForm.setListNguoiDung(listNguoiDung);
		String ng = dangNhapBO.checkLogin(maNguoiDung, matKhau); 
		HttpSession session=request.getSession();
		session.setAttribute("maNguoiDung", maNguoiDung);
		if(dangNhapBO.checkLogin(maNguoiDung, matKhau)  != null){
		 if(dangNhapBO.checkLamBai(maNguoiDung)!=null){
				return mapping.findForward("thiTiep");
			}else if("1".equals(ng)){
				return mapping.findForward("admin");
			}else if("2".equals(ng)){
				return mapping.findForward("quanLy");
			}else {
				return mapping.findForward("nguoiThi");
			}
		}
			else {
			dangNhapForm.setThongBao("Tên đăng nhập và mật khâu không chính xác");
			return mapping.findForward("thatBai");
		}

	}
}
