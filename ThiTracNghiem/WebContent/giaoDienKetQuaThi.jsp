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
                window.location="giaoDienKetQuaThi.jsp";
            }
        }
       
    </script>
</head>
<body>
	<div class="container">
<header>

	<p style="float:left;font-size:18px;padding: 7px;color:navy;"><img src="anh/b.jpg" alt="Home" style="width:20px;height:20px;"> <B> HỆ THỐNG THI TRẮC NGHIỆM ONLINE KỲ THI TỐT NGHIỆP THPT</p>
   	<br>
   
    </br>
    
</header>
  
<nav>
<img src="anh/a.jpg" alt="Avatar" style="width:100px;height:100px;display: block;
    margin: 0 auto;">
    </br>
  <ul style="list-style-type: circle;">

  <div class ="col-sm-4">
        	<button class="btn btn-success" onclick="dx();"><span class="glyphicon glyphicon-off"></span> Đăng Xuất</button>
    
        	</div>
</ul>
</nav>

<article>
<center> 
<html:form action="/xemKetQua" method="post">
 
 </center>
  
  <div style="color:green">
  <center><lable>KẾT QUẢ BÀI THI</lable></center>
  </div>
  <div>
  <br>
 
  <table style="width:100%" class="table table-striped">
  	<tr>
  		<b><td>Tên người dùng</td></b>
  		<td>Mã đề thi</td>
		<td>Tổng số câu hỏi</td>	
		<td>Số câu trả lời đúng</td>
		<td>Điểm</td>
	</tr>
  	<tr>
  		<td><bean:write name="luuKetQuaForm" property="maNguoiDung"/></td>
  		<td><bean:write name="luuKetQuaForm" property="maDeThi"/></td>
		<td><bean:write name="luuKetQuaForm" property="soLuong"/></td>	
		<td><bean:write name="luuKetQuaForm" property="soCauTraLoiDung"/></td>
		<td><bean:write name="luuKetQuaForm" property="diem"/></td>
	</tr>
  </table>
 </html:form>
 </div>
 </article>



</div>
	
</body>
</html>