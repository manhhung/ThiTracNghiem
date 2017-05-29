<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
	<meta charset="UTF-8">
	<title>QUẢN LÝ MÔN THI</title>
	<link rel="stylesheet" href="css/bootstrap.min.css" />
	<script src="js/jquery-1.11.2.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<style>
		.cangiua{
			margin: auto;
			text-align: center;
		}
		.canphai{
			margin: auto;
			text-align: right;
		}
	</style>
	<script type="text/javascript">
		function confirmXoa(){
			return confirm("Bạn có muốn xóa môn thi này không?");
		}
	
	</script>
	
</head>

<body>
<div class = "container">

      
      <html:form action="/danh-sach" method="get">
     <div class ="col-sm-4">
        	 <button class="btn btn-danger" onclick= "document.forms[0].action = 'TrangChuQuanTriVien.jsp'"><span class="glyphicon glyphicon-home"></span> Trang Chủ</button>
     </div>
        	 
        	<br>
		<div class = "cangiua"><h2><b>DANH MỤC MÔN THI</b></h2></div>
		<div class="row form-group">
            <div class="canphai">
            	<html:link action="/themMon" styleClass="btn btn-success active btright"><span class="glyphicon glyphicon-plus-sign"></span> Thêm mới</html:link>
            </div>
        </div>
      		</br>
  			<table style="width:100%" class="table table-striped">
			<thead><tr class="success">
				<th><b>Mã Môn</b></th>
				<th><b>Tên Môn</b></th>
				<th><b>Thao Tác</b></th>
			</tr>
			</thead>
			<tbody>
			 <logic:iterate name="danhSachMonThiForm" property="listMonThi" id="mon">
			 <tr>
                <th scope="row">
                	<bean:write name="mon" property="maMon"/>
				</th>
                <td>
                	<bean:write name="mon" property="tenMon"/>
                </td>         
                <td>
                	<bean:define id="maMon" name="mon" property="maMon"></bean:define>
                	<html:link action="/suaMon?maMon=${maMon}">
                		<span class="glyphicon glyphicon-edit"></span>
                	</html:link>
                	<html:link action="/xoaMon?maMon=${maMon}" style="margin-left: 30px;" onclick="return confirmXoa()">
                		<span class="glyphicon glyphicon-trash"></span>
                	</html:link>
                </td>
            </tr>
  		 	</logic:iterate>
			</tbody>
		</table>
		
</html:form>
		
		</div>

</body>
</html>