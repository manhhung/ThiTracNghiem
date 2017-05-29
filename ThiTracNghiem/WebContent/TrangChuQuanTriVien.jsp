<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<script>
function startTime() {
    var today = new Date();
    var h = today.getHours();
    var m = today.getMinutes();
    var s = today.getSeconds();
    m = checkTime(m);
    s = checkTime(s);
    document.getElementById('txt').innerHTML =
    h + ":" + m + ":" + s;
    var t = setTimeout(startTime, 500);
}
function checkTime(i) {
    if (i < 10) {i = "0" + i};  // add zero in front of numbers < 10
    return i;
}
</script>
<meta charset="UTF-8">
<title>Tài khoản quản trị viên</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />

<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<style>
	.cantrai{
		text-align: right;
		margin-top:10px;
		
	}
</style>
</head>
<body onload="startTime()">

<div>
	<center><h1>HỆ THỐNG THI TRẮC NGHIỆM ONLINE</h1></center>
		
	</div>
	</br>
	</BR>
	</BR>
 			
    		 <html:link action="/danh-sach">
       		 <img src="anh/USER.jpg" alt="user" style="width:200px; height:200px; margin-left:500px" >
       			<label>Quản lý tài khoản</label>
		 </html:link>
		 	<html:link action="/thong-ke">
       		 <img src="anh/Chart.jpg" alt="user" style="width:200px; height:200px; margin-left:200px">
       		<label> Xem điểm </label>
       		 </html:link>
  		</br></br></br></br></br></br>     		 
       		 	<html:link action="/mon-thi">
       		 <img src="anh/char3.jpg" alt="user" style="width:200px; height:200px;margin-left:750px">
       		  <label> Quản lý môn thi </label>
       		   </html:link>
       		   </br>
       		   	   </br>
       		   	   	   </br>
       		   	   	   </br>
       		   	   </br>
       		   	   	   </br>
       		   	   	   </br>
       		   	   	   </br>
  		<div class="cantrai" >
  		<div id="txt"></div>
  		<img src="anh/3.jpg" alt="Mountain View" style="width:50px;height:50px; margin-left:1200px">
	
	<label >Quyền quản trị viên </label></br>
	
			<button class="btn btn-success" onclick="dx();"><span class="glyphicon glyphicon-off"></span> Đăng Xuất</button>
      <script type="text/javascript">
        function dx(){
            if(confirm("Bạn có muốn đăng xuất không ?") == true){
            	 window.location="dangNhap.jsp";
            }else{
                window.location="TrangChuQuanTriVien.jsp";
            }
        }
       
    </script>
      
	</div>
  </body>

</html>