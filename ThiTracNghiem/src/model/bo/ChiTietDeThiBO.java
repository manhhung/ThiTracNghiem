package model.bo;
import java.util.ArrayList;

import model.bean.*;
import model.dao.ChiTietDeThiDAO;

public class ChiTietDeThiBO {
	
	ChiTietDeThiDAO chiTietDeThiDAO = new ChiTietDeThiDAO();

	public ArrayList<ChiTietDeThi> getListChiTietDeThi(String maDeThi) {
		return chiTietDeThiDAO.getListChiTietDeThi(maDeThi);
	}
	
	

}
