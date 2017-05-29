package common;

public class StringProcess {
	/**
	 * Ham tra ve gioi tinh: 1=Nam, 0=Nu
	 * @param val
	 * @return String
	 */
	public static String gioiTinh(String val) {
		if("0".equals(val)){
			return "Nữ";
		}
		return "Nam";
	}
	

	/**
	 * Ham in ra mot xau, null in ra xau rong
	 * @param s
	 * @return String
	 */
	public static String getVaildString(String s) {
		if(s==null) return "";
		return s;
	}
	
	/**
	 * Ham kiem tra xau rong hay khong
	 * @param s
	 * @return boolean
	 */
	public static boolean notVaild(String s){
		if(s==null || s.length()==0) return true;
		return false;
	}
	
	
	/**
	 * Ham kiem tra xem xau co bao gom  so hay khong
	 * @param s
	 * @return boolean
	 */
	public static boolean notVaildNumber(String s){
		if(notVaild(s)) return true;
		String regex = "[0-9]+"; 
		if(s.matches(regex)) return false;
		return true;
	}
	
	//hàm kiểm tra chỉ nhập được chữ số
	public boolean number(String str)
	{
		String sdtreg = "\\d*";
		return str.matches(sdtreg);
	}
	 
	//ham kiem tra sdt
	public static boolean vaildPhone(String s){
		if(notVaild(s)) return true;
		String regex = "(\\+84|0)\\d{9,10}"; 
		if(s.matches(regex)) return false;
		
		return true;
	}
	public static boolean notVaildThi(int soLuongCauHoi){
	
		if(soLuongCauHoi==0) return true;
		if(soLuongCauHoi > 0 && soLuongCauHoi<=40) return false;
		return true;
	}
	public static boolean notVaildThoiGian(int thoiGian){
	
		if(thoiGian==0) return true;
		if(thoiGian > 0 && thoiGian<=180) return false;
		return true;
	}

	
	
}
