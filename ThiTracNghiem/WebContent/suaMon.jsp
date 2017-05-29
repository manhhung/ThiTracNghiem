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
    <title>Sửa danh mục</title>
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
</head>
<body>
<div class = "container">
	
	<html:form action="/suaMon" method="post">
	<div class = "cantrai">
	<button class="btn btn-danger" onclick="history.go(-1);"><span class="glyphicon glyphicon-arrow-left"></span> Quay lại</button>
	</div>
	<h3><b>Sửa môn thi</b></h3>
		<br>
		<div class = "row form-group">
			<label class = "row form-group"></label>
			<label class = "col-lg-2">Mã môn thi</label>
			<div class="col-lg-3">
            	<html:text property="maMon" readonly="true" styleClass="form-control"></html:text>
            </div>
		</div>
		<div class = "row form-group">
			<label class = "row form-group"></label>
			<label class = "col-lg-2">Tên môn thi</label>
			<div class="col-lg-3">
            	<html:text property="tenMon" styleClass="form-control"></html:text>
            	<p style = "color:red"><bean:write name="monThiForm" property = "thongBaoTen"/></p>	
            </div>
		</div>
		 <div class="row form-group">
            <div class="col-lg-3 col-lg-offset-2">
            	<html:submit styleClass="btn btn-primary" property="submit" value="Lưu lại">Lưu lại</html:submit>
       			
            </div>
           
        </div>
        </html:form>
</div>

</body>
</html>