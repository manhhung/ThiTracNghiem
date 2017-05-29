package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.bean.MonThi;
import model.bo.MonThiBO;


import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.StringProcess;


import form.MonThiForm;



public class SuaMonThiAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		MonThiForm monThiForm = (MonThiForm) form;
		MonThiBO monThiBO = new MonThiBO();
		String maMon=monThiForm.getMaMon();
		
		if("Lưu lại".equals(monThiForm.getSubmit())){					
			String tenMon = monThiForm.getTenMon();
			if(!StringProcess.notVaildNumber(tenMon)){
				monThiForm.setThongBaoTen("Tên môn không chứa số hoàn toàn");
			} else if(StringProcess.notVaild(tenMon)){
				monThiForm.setThongBaoTen("Tên môn không được trống");
			}
			if(!StringProcess.notVaildNumber(tenMon) || StringProcess.notVaild(tenMon)){
				return mapping.findForward("suaMonThi");
			}
			monThiBO.suaMonThi(maMon, tenMon);
			return mapping.findForward("suaMonThixong");
		} else {														
			MonThi monThi = monThiBO.getThongTinMonThi(maMon);
			monThiForm.setTenMon(monThi.getTenMon());
			return mapping.findForward("suaMonThi");
		}
	}
	
}
