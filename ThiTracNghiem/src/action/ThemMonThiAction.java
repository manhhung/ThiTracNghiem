package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.MonThiBO;


import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


import common.StringProcess;


import form.MonThiForm;

public class ThemMonThiAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		MonThiForm monThiForm = (MonThiForm) form;
	
		
		if("Thêm mới".equals(monThiForm.getSubmit())){		
			String maMon = monThiForm.getMaMon();
			MonThiBO monThiBO = new MonThiBO();
			String maMonSoSanh = monThiBO.getMaMonSoSanh(maMon);
			if(StringProcess.notVaild(maMon)){
				monThiForm.setThongBaoMa("Mã môn thi không được trống");
			} else if(StringProcess.notVaildNumber(maMon)){
				monThiForm.setThongBaoMa(" Mã môn thi chỉ chứa số");
			}
			
			String tenMon= monThiForm.getTenMon();
			if(!StringProcess.notVaildNumber(tenMon)){
				monThiForm.setThongBaoTen("Tên môn không chứa số hoàn toàn");
			} else if(StringProcess.notVaild(tenMon)){
				monThiForm.setThongBaoTen("Tên môn không được trống");
			}
			if(StringProcess.notVaild(maMon) || StringProcess.notVaildNumber(maMon) || !StringProcess.notVaildNumber(tenMon) || StringProcess.notVaild(tenMon))
			{
				return mapping.findForward("themMonThi");
			}
			
			if(maMon.equals(maMonSoSanh)){
				monThiForm.setThongBaoMa("Mã môn này đã tồn tại");
				return mapping.findForward("themMonThi");
			}else{	
				monThiBO.themMonThi(maMon, tenMon);
			return mapping.findForward("themMonThixong");
			}
		} else {	
			
			return mapping.findForward("themMonThi");
		}
	}
	
}
