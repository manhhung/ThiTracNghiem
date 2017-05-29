package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.MonThi;
import model.bean.CauHoi;
import model.bo.MonThiBO;
import model.bo.CauHoiBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.CauHoiForm;

public class CapNhatCauHoiAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		CauHoiForm cauHoiForm = (CauHoiForm) form;
		HttpSession session=request.getSession();
		String maNguoiDung=	(String) session.getAttribute("maNguoiDung");
		CauHoiBO cauHoiBO = new CauHoiBO();	
		//lấy danh sách môn thi
			MonThiBO monThiBO = new MonThiBO();
			ArrayList<MonThi> listMonThi = monThiBO.getListMonThi(maNguoiDung);
			cauHoiForm.setListMonThi(listMonThi);
			
		//sua câu hỏi
		int maCauHoi = cauHoiForm.getMaCauHoi();
		if("Lưu lại".equals(cauHoiForm.getSubmit())){		//nhan nut Xac nhan
					String maMon = cauHoiForm.getMaMon();
					String noiDung = cauHoiForm.getNoiDung();
					String dapAn1 = cauHoiForm.getDapAn1();
					String dapAn2 = cauHoiForm.getDapAn2();
					String dapAn3 = cauHoiForm.getDapAn3();
					String dapAn4 = cauHoiForm.getDapAn4();
					int dapAnDung = cauHoiForm.getDapAnDung();
					cauHoiBO.capNhatCauHoi(maCauHoi, maMon, noiDung, dapAn1, dapAn2, dapAn3, dapAn4, dapAnDung);
					return mapping.findForward("capNhatCauHoixong");
				} else {														//chuyen sang trang Sua cau hoi02
					CauHoi cauHoi = cauHoiBO.getThongTinCauHoi(maCauHoi);
					cauHoiForm.setMaMon(cauHoi.getMaMon());
					cauHoiForm.setNoiDung(cauHoi.getNoiDung());
					cauHoiForm.setDapAn1(cauHoi.getDapAn1());
					cauHoiForm.setDapAn2(cauHoi.getDapAn2());
					cauHoiForm.setDapAn3(cauHoi.getDapAn3());
					cauHoiForm.setDapAn4(cauHoi.getDapAn4());
					cauHoiForm.setDapAnDung(cauHoi.getDapAnDung());
					return mapping.findForward("capNhatCauHoi");
				}		
		
}
}
