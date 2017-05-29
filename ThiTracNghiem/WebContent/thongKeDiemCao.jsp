<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Thống kê</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>

    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
	<style>
		.cantrai{
			margin: auto;
			text-align: left;
		}
		.cangiua{
		margin: auto;
		text-align: center;
	}
	</style>
		<script type="text/javascript">
		function confirmXoa(){
			return confirm("Bạn có muốn xóa dòng này không?");
		}
	
	</script>
</head>
<body>
<div class = "container">
		<html:form action="/thong-ke" method="get">
		<div class ="col-sm-4">
        	 <button class="btn btn-danger" onclick= "document.forms[0].action = 'TrangChuQuanTriVien.jsp'"><span class="glyphicon glyphicon-home"></span> Trang Chủ</button>
        	</div>	
		<div class = "row form-group" >
		</br>
		<h3 style="font-size:30px"><b><center>XEM ĐIỂM NGƯỜI THI </center></b></h3>
		</br>
			<div class="col-lg-4">
                <html:select property="maMon" styleClass="form-control">
					<option value="">-- Chọn Môn Cần Xem--</option>
					<html:optionsCollection name="thongKeDiemCaoForm" property="listMon" 
						label="tenMon" value="maMon" />
				</html:select>
            </div>
            <script type="text/javascript">
            	$("[name='maMon']").val('<bean:write name="thongKeDiemCaoForm" property="maMon"/>');
            </script>
					 <html:submit styleClass="btn btn-primary">Xem</html:submit>
					</br></br>
					
		</div>
				</html:form>
			<div class="bs-example">
        <table class="table table-striped">
            <thead>
            <tr class="success">
                <th>Mã Người Dùng</th>
               	<th>Mã Môn</th>
                <th>Tên Môn Thi</th>
                <th>Điểm</th>
                <th>Thao tác</th>
            </tr>
            </thead>
            <tbody>
            <logic:iterate name="thongKeDiemCaoForm" property="listDiem" id="d">
            	<tr >
                <th scope="row" >
                	<bean:write name="d" property="maNguoiDung"/>
				</th>
				<td>
					<bean:write name="d" property="maMon"/>
				</td>
                <td >
                	<bean:write name="d" property="tenMon"/>
                </td>
                <td >
                	<bean:write name="d" property="diemSo"/>
				</td>  
				<td>
				<bean:define id="maNguoiDung" name="d" property="maNguoiDung"></bean:define>
				<bean:define id="maMon" name="d" property="maMon"></bean:define>
				<html:link action="/xoaDiem?maNguoiDung=${maNguoiDung}&&maMon=${maMon}" style="margin-left: 30px;" onclick="return confirmXoa()">
                		<span class="glyphicon glyphicon-trash"></span>
                	</html:link>   
                	</td>       
            </tr>
            </logic:iterate>
            </tbody>
        </table>
    </div>	
		</div>
	

</body>
</html>