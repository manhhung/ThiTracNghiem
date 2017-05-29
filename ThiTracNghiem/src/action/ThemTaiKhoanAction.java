package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.MonThi;
import model.bean.NguoiDung;
import model.bo.MonThiBO;
import model.bo.NguoiDungBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.StringProcess;


import form.NguoiDungForm;

public class ThemTaiKhoanAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		NguoiDungForm nguoiDungForm = (NguoiDungForm) form;
		NguoiDungBO nguoiDungBO = new NguoiDungBO();
		MonThiBO monThiBO=new MonThiBO();
		// lay thong tin quyen
		ArrayList<NguoiDung> listQuyen;
		listQuyen = nguoiDungBO.getListQuyen();
		nguoiDungForm.setListQuyen(listQuyen);
		
		
		ArrayList<MonThi> listMonThi;
		listMonThi=monThiBO.getListMonThi1();
		nguoiDungForm.setListMonThi(listMonThi);
	
		
		

		//Validate dữ liệu
		if("Thêm mới".equals(nguoiDungForm.getSubmit())){
            ActionErrors actionErrors = new ActionErrors();
            if(StringProcess.notVaild(nguoiDungForm.getMaNguoiDung())){
                            actionErrors.add("maTaiKhoanError", new ActionMessage("error.mtk.trong"));
            }
            if(StringProcess.notVaild(nguoiDungForm.getMatKhau())){
                actionErrors.add("matKhauError", new ActionMessage("error.mk.trong"));
            }
           
            saveErrors(request, actionErrors);
            if(actionErrors.size()>0){
            	return mapping.findForward("themTaiKhoanerror");
            }
		}
		//lay ma tai khoan de so sanh
		
		if("Thêm mới".equals(nguoiDungForm.getSubmit())){		
			String maTaiKhoan = nguoiDungForm.getMaNguoiDung();
			String maTaiKhoanSoSanh = nguoiDungBO.getMaTaiKhoanCSDL(maTaiKhoan);
			if(maTaiKhoan.equals(maTaiKhoanSoSanh)){
				nguoiDungForm.setThongBao("Mã này đã có người sử dụng");
				return mapping.findForward("themTaiKhoanerror");
			}else{	
				String matKhau= nguoiDungForm.getMatKhau();
				String id = nguoiDungForm.getId();
				String maMon=nguoiDungForm.getMaMon();
				nguoiDungBO.themTaiKhoan(maTaiKhoan, matKhau,id,maMon);
				nguoiDungBO.themThongTinTaiKhoan(maTaiKhoan);
				return mapping.findForward("themTaiKhoanxong");
			}
		} else {		
			return mapping.findForward("themTaiKhoan");
		}
		
	}

}
