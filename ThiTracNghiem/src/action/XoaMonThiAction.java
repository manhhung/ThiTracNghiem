package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import model.bo.MonThiBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.MonThiForm;

public class XoaMonThiAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		MonThiForm monThiForm = (MonThiForm) form;
		MonThiBO monThiBO = new MonThiBO();
		String maMon = monThiForm.getMaMon();
		monThiBO.xoaMonThi(maMon);	
		monThiBO.xoaDeThi(maMon);
		return mapping.findForward("xoaMonThi");
		
	}
	
}
