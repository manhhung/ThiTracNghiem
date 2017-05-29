<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NGƯỜI DÙNG</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/style.css" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<script type="text/javascript">
// set minutes
var mins = 60;
 
// calculate the seconds (don't change this! unless time progresses at a different speed for you...)
var secs = mins * 60;
function countdown() {
	setTimeout('Decrement()',1000);
}
function Decrement() {
	if (document.getElementById) {
		minutes = document.getElementById("minutes");
		seconds = document.getElementById("seconds");
		// if less than a minute remaining
		if (seconds < 59) {
			seconds.value = secs;
		} else {
			minutes.value = getminutes();
			seconds.value = getseconds();
		}
		secs--;
		setTimeout('Decrement()',1000);
	}
}
function getminutes() {
	// minutes is seconds divided by 60, rounded down
	mins = Math.floor(secs / 60);
	return mins;
}
function getseconds() {
	// take mins remaining (as seconds) away from total seconds remaining
	return secs-Math.round(mins *60);
}
</script>
<style>
div.container {
	backround-color: red;
    width: 100%;
   	height:100%;
    border: 0.5px solid black;
}

header {
    color: black;
    clear: left;
    height:50px;
    text-align: right;
    text-size: 14px;
    border-bottom-style: outset;
}

nav {
    float: left;
    max-width: 160px;
    margin: 0;
    padding: 1em;
}

nav ul {
    list-style-type: none;
    padding: 0;
}
   
nav ul a {
    text-decoration: none;
}

article {
    margin-left: 170px;
    border-left: 1px solid gray;
     padding: 1em;
    overflow: hidden;
}
</style>
<style>
	.cangiua{
		margin: auto;
		text-align: center;
	}
	.canphai{
		margin: auto;
		text-align: right;
	}
	.cantrai{
		margin: auto;
		text-align: left;
	}
</style>
  <script type="text/javascript">
        function dx(){
            if(confirm("Bạn có muốn đăng xuất không ?") == true){
            	 window.location="dangNhap.jsp";
            }else{
                window.location="giaoDienNguoiDungBD.jsp";
            }
        }
       
    </script>
</head>
<body>
	<div class="container">
<header>

	<p style="float:left;font-size:18px;padding: 7px;color:navy;"><img src="anh/b.jpg" alt="Home" style="width:20px;height:20px;">
	 <B> HỆ THỐNG THI TRẮC NGHIỆM ONLINE KỲ THI TỐT NGHIỆP THPT</p>
   	<br>

    </br>
    
</header>
  
<nav>
<img src="anh/a.jpg" alt="Avatar" style="width:100px;height:100px;display: block;
    margin: 0 auto;">
    </br>
  
  <h4 style="color:blue;">
  <bean:write name="dangNhapForm" property="maNguoiDung"/> 
  </h4>
  <bean:define id="maNguoiDung" name="dangNhapForm" property="maNguoiDung"></bean:define>
   <html:link action="/test?maNguoiDung=${maNguoiDung}" target="blank" style="margin-left: 30px;">
                		Cập nhật thông tin tài khoản 
                	</html:link>
  
  <ul style="list-style-type: circle;">
    <center>	
  
  					</br></br>
  					  <div class ="col-sm-4">
        	<button class="btn btn-success" onclick="dx();"><span class="glyphicon glyphicon-off"></span> Đăng Xuất</button>
    
        	</div>
  			</center>

</ul>
</nav>

<article>
<center>
 </br></br>
    <html:form action="/lamBaiThi" method="post">
	 <label>Nhập key để thi:</label>
	
	 <html:text property="maDeThi" maxlength="50"></html:text>
	<p style="color: red;">
						<bean:write name="giaoDienBatDauForm" property="thongBao"/></p>
	 </br></br>
 <div>
 					<html:submit styleClass="btn btn-success btn-sm "> Bắt đầu </html:submit>
</div>
	</html:form>
 </center>
 
</article>
	</div>
	
</body>
</html>