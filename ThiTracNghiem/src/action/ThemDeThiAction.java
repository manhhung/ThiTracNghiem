package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.MonThi;
import model.bo.MonThiBO;
import model.bo.DeThiBO;
import model.bo.ThiBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.StringProcess;
import form.DeThiForm;

public class ThemDeThiAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		request.setCharacterEncoding("UTF-8");
		DeThiForm deThiForm = (DeThiForm) form;
		HttpSession session=request.getSession();
		String maNguoiDung=	(String) session.getAttribute("maNguoiDung");
		//lấy danh sách môn thi
		MonThiBO monThiBO = new MonThiBO();
		ArrayList<MonThi> listMonThi = monThiBO.getListMonThi(maNguoiDung);
		deThiForm.setListMonThi(listMonThi);
		//xác thực dữ liệu
		// đẩy PM (Khánh)
		DeThiBO deThiBO=new DeThiBO();
		// đang bị bỏ trống
		String s ="Thêm mới";
		s = deThiForm.getSubmit();
		if(s!=null){		//nhan nut Xac nhan
			int maMon = deThiForm.getMaMon();
			int maDeThi = deThiForm.getMaDeThi();
			int thoiGianThi = deThiForm.getThoiGianThi();
			int soLuongCauHoi = deThiForm.getSoLuongCauHoi();
			System.out.println(soLuongCauHoi);
			ActionErrors actionErrors=new ActionErrors();
			if(StringProcess.notVaildThoiGian(thoiGianThi)){

				actionErrors.add("tgThi",new ActionMessage("error.tg.Thi"));
			}
			if(StringProcess.notVaildThi(soLuongCauHoi)){
				actionErrors.add("slThi",new ActionMessage("error.sl.Thi"));

			}
			saveErrors(request, actionErrors);
			if(actionErrors.size()>0){
				return mapping.findForward("themDeThiSai");
			}

			deThiBO.themDeThi(maMon, maDeThi, thoiGianThi, soLuongCauHoi);
			return mapping.findForward("themDeThixong");

		} else {											//chuyen sang trang Them de thi
			return mapping.findForward("themDeThi");
		}
	}
}
