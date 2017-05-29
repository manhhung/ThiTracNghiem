<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.Quyen"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>DANH SÁCH TÀI KHOẢN</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style1.css"/>
    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/index.js"></script>
    <script src="js/index1.js"></script>
    <link href="css/metro/blue/jtable.css" rel="stylesheet" type="text/css" />
	<link href="css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
	<script src="js/jquery-1.8.2.js" type="text/javascript"></script>
	<script src="js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
	<script src="js/jquery.jtable.js" type="text/javascript"></script>
	
</head>
<body>
<div class = "container">
<html:form action="/danh-sach" method="post">
<div class="row">
     <div class ="col-sm-4">
        	 <button class="btn btn-danger" onclick= "document.forms[0].action = 'TrangChuQuanTriVien.jsp'"><span class="glyphicon glyphicon-home"></span> Trang Chủ</button>
        	</div>
        	</br>
        	</br>
				<h3 style="font-size:30px"><b><center>QUẢN LÝ TÀI KHOẢN</center></b></h3>
			</br>
   	
       <span style = "font-size: 30px; color: red"><bean:write name="danhSachTaiKhoanForm" property="thongBao" /></span>

<div class="row">
          <div class="col-lg-10">
          <form>
		  <input type="text" id="myInput" maxlength="50" onkeyup="myFunction()" name="search" placeholder="Nhập từ khóa...">
	 </form>
          
	  </div>
	  <div class="col-lg-2">
     <html:link action="/themTaiKhoan" styleClass="btn btn-success active btright"><span class="glyphicon glyphicon-plus-sign"></span> Thêm mới</html:link>
     </div>
            
     </div> 
     </br> 
	 <div class="bs-example">
        <table id="myTable" class="table table-striped">
            <thead>
            <tr class="success">
                <th>Mã người dùng</th>
                <th>Mật khẩu</th>
                <th>Quyền</th>  
                <th>Tên môn</th>   
                <th>Thao tác</th>
            </tr>
            </thead>
            <tbody>
            <logic:iterate name="danhSachTaiKhoanForm" property="listNguoiDung" id="nd">
            	<tr>
                <td scope="row">
                	<bean:write name="nd" property="maNguoiDung"/>
				</td>
                <td>
                	
                	<bean:write name="nd" property="matKhau" />
                </td>
				<td>
                	<bean:write name="nd" property="tenQuyen"/>
				</td>
				<td>
                	<bean:write name="nd" property="tenMon"/>
				</td>
                <td>
                	<bean:define id="maNguoiDung" name="nd" property="maNguoiDung"></bean:define>
                	<html:link action="/suaTaiKhoan?maNguoiDung=${maNguoiDung}">
                		<span class="glyphicon glyphicon-edit"></span>
                	</html:link>
                	<html:link action="/xoaTaiKhoan?maNguoiDung=${maNguoiDung}" style="margin-left: 30px;" onclick="return confirmXoa()">
                        <span class="glyphicon glyphicon-trash"></span>
                  </html:link>
                	
                	<html:link action="/suaThongTinTaiKhoan?maNguoiDung=${maNguoiDung}" style="margin-left: 30px;">
                		<span class="glyphicon glyphicon-eye-open"> </span>
                	</html:link>
                	
                </td>
            </tr>
            </logic:iterate>
            </tbody>
        </table>
        </br>
         
    </div>
    </html:form>
    
    </div>
</body>
</html>