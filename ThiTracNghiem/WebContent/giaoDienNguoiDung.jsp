<%@page import="form.ThiForm"%>
<%@page import="com.sun.xml.internal.ws.client.ResponseContext"%>
<%@page import="javax.xml.ws.Response"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

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
	height: 100%;
	border: 0.5px solid black;
}

header {
	color: black;
	clear: left;
	height: 100px;
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
.cangiua {
	margin: auto;
	text-align: center;
}

.canphai {
	margin: auto;
	text-align: right;
}

.cantrai {
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
  <script>
        function counDown(seconds) {
            if (seconds == 0) {
                //submit form
                 document.getElementById("formKetQua").submit();
                //end countDown
                display(0);
                return;
            }
            setTimeout(function () {
                seconds--;
                display(seconds);
                counDown(seconds);
            }, 1000);
        }
        function display(seconds) {
            //minutes
            min = parseInt(seconds / 60);            
            if (min >= 60)
            {
            	
                hour = parseInt(min / 60);
                min = min - hour * 60;
            }
            else
            {
                hour = 0;
            }

            if (min > 0) {
                seconds = seconds - 60 * min - hour * 3600;
            }
            else
                min = 0;

            if (hour < 10)
                hour = "0" + hour.toString();
            if (min < 10)
                min = "0" + min.toString();
            if (seconds < 10)
                seconds = "0" + seconds.toString();

            str = hour.toString() + ':' + min.toString() + ':' + seconds.toString();

            $('.clock-content').text(str);
        }
    </script>

<div class="container"><header>

<p style="float: left; font-size: 18px; padding: 7px; color: navy;"><img
	src="anh/b.jpg" alt="Home" style="width: 20px; height: 20px;"> <B>
HỆ THỐNG THI TRẮC NGHIỆM ONLINE KỲ THI TỐT NGHIỆP THPT</p>
<br>
	



</header>
 <nav>
 
 <h4 style = "color:red; font-size: 18px; padding: 7px;"><p><b>Người thi</b></p><bean:write name="thiForm" property="maNguoiDung" /> </h4>
</br>
	<ul   >
            <logic:iterate name="thiForm" property="listPage" id="pag">
            	<li><html:link styleClass="loadCau" href="thi.do?page=${pag}">Câu <bean:write name="pag"/> </html:link></li>
            	
            </logic:iterate>




</ul>
</nav> <article>

<center><h2>Môn Thi:<bean:write name="thiForm" property="tenMon"></bean:write></h2></center>
	
<div id="reloadForm">
<logic:iterate id="x" name="thiForm" property="listCauHoi" >
	<bean:define id="y" name="thiForm" property="currentPage"  ></bean:define>
	<html:form styleId="from" action="/thi.do?page=${y+1}&submit=submit" method="post" >
		<div class="panel-group">
		<div class="panel panel-default">
		<div class="panel-heading" >
		<html:hidden property="remainTime" styleId="txtRemainTime"/>
		<html:hidden name="x" property="maDeThi"/>
		<html:hidden name="x" property="maCauHoi"/>
	
	<h4> Câu <bean:write name="y"/>: <bean:write name="x" property="noiDung" /></h4>
		</div>
		<div class="panel-body">
	
		<div><html:radio name="x" property="dapAn" value="1" >
		A. &nbsp; 	<bean:write name="x" property="dapAn1" />
		</html:radio></div>
	
		<div><html:radio name="x" property="dapAn" value="2" >
	B. &nbsp;	<bean:write name="x" property="dapAn2" />
		</html:radio></div>
	
		<div><html:radio name="x" property="dapAn" value="3" >
	C. &nbsp;		<bean:write name="x" property="dapAn3" />
		</html:radio></div>
	
		<div><html:radio name="x" property="dapAn" value="4" >
	D. &nbsp;		<bean:write name="x" property="dapAn4" />
		</html:radio></div>
		
		</div>
	
		</div>
		</div>

	
       	<html:submit styleClass="btn btn-primary" property="submit" value="Tiếp tục" ></html:submit>
      	
</html:form>
</logic:iterate> 

<div id="timer" class="canphai" style="color: green">Bài thi sẽ kết thúc trong
<div class="clock-panel">
     <span class="clock-content"></span>
</div>
<html:form action="/xemKetQua" styleId="formKetQua">

<html:submit styleClass="btn btn-danger">Nộp Bài</html:submit>

</html:form>
</div>












<style>
#seconds{
	display: none;
}
</style>

	<script>
		$(document).ready(function(){
			remainTime = $('#txtRemainTime').val();
			counDown(remainTime);
		});
		
	</script>

</div>

        
     
            
           
        </ul>
</br>


 </article></div>
 </br>
 </br>
 
</body>



<script>

function myFunction() {
    document.getElementById("from").submit();
}

</script>
</html>