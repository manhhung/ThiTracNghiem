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
    <title>Thông tin người dùng</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>
<html:form action="/test" method="post" >
	<div class="container">
      
	<h3>Thông tin chi tiết người dùng</h3>
		<br>
		<div class="row form-group">
		<label class="col-lg-2">Mã người dùng</label>
		<div class="col-lg-3">
					<html:text property="maNguoiDung" styleClass="form-control"  readonly="true"></html:text>
					<html:errors property="maTaiKhoanError"/>
				</div>
		</div>
		<div class="row form-group">
		<label class="col-lg-2">Tên người dùng</label>
         <div class="col-lg-3">
				<html:text property="tenNguoiDung" styleClass="form-control" ></html:text>
		</div>
		</div>
		<div class="row form-group">	
		<label class="col-lg-2">Giới tính</label>
            <div class="col-lg-3">
            	<html:select property="gioiTinh" value="gioiTinh" styleClass="form-control">
				<html:optionsCollection name="thongTinNguoiDungForm" property="gender" label="name" value="id"/>
				</html:select>
       </div>
           	</div>
          <div class="row form-group"> 
			<label class="col-lg-2">Ngày sinh</label>
			 <div class="col-lg-3">
				<html:text property="ngaySinh" styleClass="form-control" styleId="datepicker" ></html:text>
		</div>
			</div>
	
		<div class="row form-group">	
			<label class="col-lg-2" >Địa chỉ</label>
			 <div class="col-lg-3">
				<html:text property="diaChi" styleClass="form-control" ></html:text>
				<span style="color: red;"><html:errors property="diaChiError"/></span>
		</div>
          </div>
		
			<div class="row form-group">
			<label class="col-lg-2">Số điện thoại</label>
		       	 <div class="col-lg-3">
				<html:text property="soDienThoai" styleClass="form-control"></html:text>
				<span style="color: red;"><html:errors property="soDienThoaiError"/></span>
		</div>
			</div>
		<center>
			<div class="row form-group">
				<div class="col-lg-3 col-lg-offset-2">
					<html:submit styleClass="btn btn-primary" property="submit" value="Xác nhận">Xác nhận</html:submit>
				
				</div>
			</div>
		</center>
</div>
</html:form>
<script type="text/javascript">
	$("#datepicker").attr('type','date');
</script>
</body>

</html>