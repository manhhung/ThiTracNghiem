package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.MonThi;
import model.bo.MonThiBO;
import model.bo.CauHoiBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.StringProcess;
import form.CauHoiForm;

public class ThemCauHoiAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		CauHoiForm cauHoiForm = (CauHoiForm) form;
		HttpSession session=request.getSession();
		String maNguoiDung=	(String) session.getAttribute("maNguoiDung");
		//lấy danh sách môn thi
		MonThiBO monThiBO = new MonThiBO();
		ArrayList<MonThi> listMonThi = monThiBO.getListMonThi(maNguoiDung);
		cauHoiForm.setListMonThi(listMonThi);
		
		//xác thực dữ liệu
		if("Thêm mới".equals(cauHoiForm.getSubmit())){
			ActionErrors actionErrors = new ActionErrors();
			if(StringProcess.notVaild(cauHoiForm.getNoiDung())){
				actionErrors.add("noiDungError", new ActionMessage("error.noiDung"));
			}
			saveErrors(request, actionErrors);
			if(actionErrors.size()>0){
				return mapping.findForward("themCauHoierror");
			}
		}
		
		
		// đang bị bỏ trống do mã câu hỏi hiện tại đã được tự động xác định
		if("Thêm mới".equals(cauHoiForm.getSubmit())){		//nhan nut Xac nhan
			String maMon = cauHoiForm.getMaMon();
			String noiDung = cauHoiForm.getNoiDung();
			String dapAn1 = cauHoiForm.getDapAn1();
			String dapAn2 = cauHoiForm.getDapAn2();
			String dapAn3 = cauHoiForm.getDapAn3();
			String dapAn4 = cauHoiForm.getDapAn4();
			int dapAnDung = cauHoiForm.getDapAnDung();
			CauHoiBO cauHoiBO = new CauHoiBO();
			cauHoiBO.themCauHoi(maMon, noiDung, dapAn1, dapAn2, dapAn3, dapAn4, dapAnDung);
			return mapping.findForward("themCauHoixong");
		} else {											//chuyen sang trang Them cau hoi
			return mapping.findForward("themCauHoi");
}
	}
}
