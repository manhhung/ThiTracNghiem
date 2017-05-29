package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.bean.Diem;
import model.bean.MonThi;


import model.bo.DiemBO;
import model.bo.MonThiBO;


import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import form.MonThiForm;
import form.ThongKeDiemCaoForm;

public class ThongKeDiemCaoAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ThongKeDiemCaoForm thongKeDiemForm = (ThongKeDiemCaoForm) form;
		
		//lay danh sach ten mon
		MonThiBO monBO = new MonThiBO();
		ArrayList<MonThi> listMon = monBO.getListMonThi1();
		thongKeDiemForm.setListMon(listMon);
		
		
		
		//lay danh sach Diem cao
		ArrayList<Diem> listDiem;
		DiemBO diemBO = new DiemBO();
		String maMon =thongKeDiemForm.getMaMon();
		if(maMon==null || maMon.length()==0){
			listDiem = diemBO.getListDiem();
			
		} else {
			listDiem = diemBO.getListDiem(maMon);
			
		}
		thongKeDiemForm.setListDiem(listDiem);
		
		String maNguoiDung= thongKeDiemForm.getMaNguoiDung();
		System.out.println(maNguoiDung);
		String maMon1 = thongKeDiemForm.getMaMon();
		System.out.println(maMon1);
		monBO.xoaDiem(maNguoiDung,maMon1);
		
		
		return mapping.findForward("tkDiem");
	}
	

}
