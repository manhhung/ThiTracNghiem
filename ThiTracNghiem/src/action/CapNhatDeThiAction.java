package action;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.MonThi;
import model.bean.DeThi;
import model.bo.MonThiBO;
import model.bo.DeThiBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DeThiForm;

public class CapNhatDeThiAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		DeThiForm deThiForm = (DeThiForm) form;
		HttpSession session=request.getSession();
		String maNguoiDung=	(String) session.getAttribute("maNguoiDung");
		DeThiBO deThiBO = new DeThiBO();	
		//lấy danh sách môn thi
			MonThiBO monThiBO = new MonThiBO();
			ArrayList<MonThi> listMonThi = monThiBO.getListMonThi(maNguoiDung);
			deThiForm.setListMonThi(listMonThi);
			
		//sua câu hỏi
		int maDeThi = deThiForm.getMaDeThi();
		String s = "Lưu lại";
		s = deThiForm.getSubmit();
		if(s != null){		//nhan nut Xac nhan
					int maMon = deThiForm.getMaMon();
					int thoiGianThi = deThiForm.getThoiGianThi();
					int soLuongCauHoi = deThiForm.getSoLuongCauHoi();
					deThiBO.capNhatDeThi(maDeThi, maMon, thoiGianThi, soLuongCauHoi);
					return mapping.findForward("capNhatDeThixong");
				} else {														//chuyen sang trang Sua cau hoi02
					DeThi deThi = deThiBO.getThongTinDeThi(maDeThi);
					deThiForm.setMaMon(deThi.getMaMon());
					deThiForm.setThoiGianThi(deThi.getThoiGianThi());
					deThiForm.setSoLuongCauHoi(deThi.getSoLuongCauHoi());
					return mapping.findForward("capNhatDeThi");
				}		
		
}
}
