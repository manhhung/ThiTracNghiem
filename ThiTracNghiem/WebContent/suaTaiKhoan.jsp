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
    <title>Sửa tài khoản</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<html:form action="/suaTaiKhoan" method="post">
<div class = "container">
	<button class="btn btn-danger" onclick="history.go(-1);"><span class="glyphicon glyphicon-arrow-left"></span> Quay lại</button>
	<h3>Sửa tài khoản</h3>
		<br>
		<div class = "row form-group">
			<label class = "row form-group"></label>
			<label class = "col-lg-2">Mã người dùng</label>
			<div class="col-lg-3">
            	<html:text property="maNguoiDung" styleClass="form-control" readonly="true" ></html:text>
				
            </div>
		</div>
		<div class = "row form-group">
			<label class = "row form-group"></label>
			<label class = "col-lg-2">Mật khẩu</label>
			<div class="col-lg-3">
				<html:password property="matKhau" maxlength="50" styleClass="form-control"></html:password>
            	
            	<html:errors property="matKhauError"/>
            </div>
		</div>

		<div class = "row form-group">
				<label class = "row form-group"></label>
				<label class = "col-lg-2">Quyền</label>
				<div class="col-lg-3">
				<html:select property="id" styleClass="form-control">
					<html:optionsCollection name="nguoiDungForm" property="listQuyen" label="tenQuyen" value="id"/>
				</html:select>
				</div>
		</div>
		<div class="row form-group">
            <label class="col-lg-2">Môn</label>
            <div class="col-lg-3">
            	<html:select property="maMon" styleClass="form-control">
            	<option value="">-- Chọn môn --</option>
            		<html:optionsCollection  property="listMonThi" label="tenMon" value="maMon" />
            	</html:select>
            </div>
       	</div>
		<div>
		<div class="col-lg-3 col-lg-offset-2">
			<html:submit styleClass="btn btn-primary" property="submit" value="Lưu lại">Lưu lại</html:submit>
		
		</div>
		</div>
</div>
</html:form>
</body>
</html>