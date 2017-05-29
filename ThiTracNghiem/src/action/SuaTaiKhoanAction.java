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





import form.NguoiDungForm;

public class SuaTaiKhoanAction extends Action{

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
		String maNguoiDung= nguoiDungForm.getMaNguoiDung();
		String matKhau = nguoiDungForm.getMatKhau();
		String id = nguoiDungForm.getId();
		String maMon=nguoiDungForm.getMaMon();
		
		if("Lưu lại".equals(nguoiDungForm.getSubmit()))
		{
			nguoiDungBO.suaTaiKhoan(maNguoiDung, matKhau, id,maMon);
			return mapping.findForward("suaTaiKhoanxong");
		}
		else {														
			
			NguoiDung nguoiDung = nguoiDungBO.getThongTinNguoiDung(maNguoiDung);
			
			nguoiDungForm.setMatKhau(nguoiDung.getMatKhau());
			nguoiDungForm.setId(nguoiDung.getId());
			nguoiDungForm.setMaMon(nguoiDung.getMaMon());
			return mapping.findForward("suaTaiKhoan");
		}
	}
	}
	 
