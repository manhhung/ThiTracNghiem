package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.NguoiDung;
import model.bean.ThongTinNguoiDung;
import model.bo.NguoiDungBO;
import model.bo.ThongTinNguoiDungBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.StringProcess;

import form.DanhSachTaiKhoanForm;
import form.NguoiDungForm;
import form.ThongTinNguoiDungForm;

public class ThemChiTietTaiKhoanAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		ThongTinNguoiDungForm thongTinNguoiDungForm = (ThongTinNguoiDungForm) form;
		ThongTinNguoiDungBO thongTinnguoiDungBO = new ThongTinNguoiDungBO();

		
		String maNguoiDung = thongTinNguoiDungForm.getMaNguoiDung();
		
		//xác thực dữ liệu
		
		if("Xác nhận".equals(thongTinNguoiDungForm.getSubmit())){
			ActionErrors actionErrors = new ActionErrors();
			if(StringProcess.vaildPhone(thongTinNguoiDungForm.getSoDienThoai())){
				actionErrors.add("soDienThoaiError", new ActionMessage("error.soDienThoai"));
			}
			if(!StringProcess.notVaildNumber(thongTinNguoiDungForm.getDiaChi())){
				actionErrors.add("diaChiError", new ActionMessage("error.diaChi"));
			}
			saveErrors(request, actionErrors);
			if(actionErrors.size()>0){
				return mapping.findForward("suaThongTinTaiKhoanerror");
			}
		}
	
		
		if("Xác nhận".equals(thongTinNguoiDungForm.getSubmit()))
		{
			String tenNguoiDung = thongTinNguoiDungForm.getTenNguoiDung();
			
			int gioiTinh = thongTinNguoiDungForm.getGioiTinh();
			String ngaySinh = thongTinNguoiDungForm.getNgaySinh();
			String diaChi = thongTinNguoiDungForm.getDiaChi();
			String soDienThoai = thongTinNguoiDungForm.getSoDienThoai();
			thongTinnguoiDungBO.suaThongTinTaiKhoan(maNguoiDung, tenNguoiDung, gioiTinh,
					ngaySinh,diaChi,soDienThoai);
			return mapping.findForward("suaThongTinTaiKhoanxong");
		}
		else {		
			ThongTinNguoiDung thongTinNguoiDung = thongTinnguoiDungBO.getThongTinChiTietNguoiDung(maNguoiDung);
			thongTinNguoiDungForm.setTenNguoiDung(thongTinNguoiDung.getTenNguoiDung());
			thongTinNguoiDungForm.setGioiTinh(thongTinNguoiDung.getGioiTinh());
			thongTinNguoiDungForm.setNgaySinh(thongTinNguoiDung.getNgaySinh());
			thongTinNguoiDungForm.setDiaChi(thongTinNguoiDung.getDiaChi());
			thongTinNguoiDungForm.setSoDienThoai(thongTinNguoiDung.getSoDienThoai());
			return mapping.findForward("suaThongTinTaiKhoan");
		}
	}
	
}
