package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.ThiBO;
import model.dao.ThiDAO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.LuuKetQuaForm;
import form.ThiForm;

public class XemKetQuaAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		LuuKetQuaForm luuKetQuaForm=(LuuKetQuaForm) form;
		ThiBO thiBO=new ThiBO();
			//xem ket qua thi
			HttpSession session=request.getSession();
			String maNguoiDung=(String) session.getAttribute("maNguoiDung");
			luuKetQuaForm.setMaNguoiDung(maNguoiDung);
			
			//String maDeThi=(String) session.getAttribute("maDeThi");
			String maDeThi=thiBO.getMaDeThi(maNguoiDung);
			luuKetQuaForm.setMaDeThi(maDeThi);
			
			float soLuong=thiBO.getSoLuong(maDeThi);
			
			luuKetQuaForm.setSoLuong(soLuong);
			
			int soCauTraLoiDung=thiBO.getSoCauTraLoiDung(maDeThi,maNguoiDung);
			
			luuKetQuaForm.setSoCauTraLoiDung(soCauTraLoiDung);
			
			double diem =(soCauTraLoiDung / (1.0*soLuong))*10 ;
			
		
			
			
			String maMon1=thiBO.getMaMon(maDeThi);
		//	System.out.println(maMon1);
			Integer maMon=Integer.valueOf(maMon1);
			
			String tenMon=(String) session.getAttribute("tenMon");
			
			luuKetQuaForm.setTenMon(tenMon);
			
			luuKetQuaForm.setDiem(diem);
			thiBO.xoaKetQuaThi(maDeThi,maNguoiDung);
			thiBO.luuDiem(maNguoiDung,maMon,diem);
			return mapping.findForward("xemKetQua");
	}


public static double roundToHalf(double d) {
    return Math.round(d * 2) / 2.0;
	}
}
