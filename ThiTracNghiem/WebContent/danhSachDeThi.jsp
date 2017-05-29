<%@page import="model.bean.MonThi"%>
<%@page import="common.StringProcess"%>
<%@page import="model.bean.DeThi"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>QUẢN LÝ ĐỀ THI</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <html:form action="/danh-sach2" method="get">
        
        	<div class ="col-sm-4">
        	 <button class="btn btn-danger" onclick= "document.forms[0].action = 'giaoDienQuanLy.jsp'"><span class="glyphicon glyphicon-home"></span> Trang Chủ</button>
        	</div>
        	</br>
        	</br>
				<h3 style="font-size:30px"><b><center>QUẢN LÝ ĐỀ THI</center></b></h3>
			</br>
            <div class="col-lg-4">
                <html:select property="maMon" styleClass="form-control">
					<option value="">-- Chọn môn --</option>
					<html:optionsCollection name="danhSachDeThiForm" property="listMonThi" 
						label="tenMon" value="maMon" />
				</html:select>
            </div>
            <script type="text/javascript">
            	$("[name='maMon']").val('<bean:write name="danhSachDeThiForm" property="maMon"/>');
            </script>
            <html:submit styleClass="btn btn-primary">Xem</html:submit>
            <div class="col-lg-2 pull-right">
            	<html:link styleClass="btn btn-success" action="/themDeThi"><span class="glyphicon glyphicon-plus"></span> Thêm mới</html:link>
            </div>
        </html:form>
    </div>
    <br>
    
    
    
    <div class="bs-example">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Mã đề thi</th>
                <th>Tên môn thi</th>
                <th>Thời gian thi</th>
                <th>Số lượng câu hỏi</th>
                <th>Thao tác</th>
            </tr>
            </thead>
            <tbody>
            <logic:iterate name="danhSachDeThiForm" property="listDeThi" id="dt">
            	<tr>
                <th scope="row">
                	<bean:write name="dt" property="maDeThi"/>
				</th>
                <td>
                	<bean:write name="dt" property="tenMon"/>
                </td>
                <td>
                	<bean:write name="dt" property="thoiGianThi"/>
				</td>
                <td>
                	<bean:write name="dt" property="soLuongCauHoi"/>
                </td>
                <td>
               	 	<bean:define id="maDeThi" name="dt" property="maDeThi"></bean:define>
                	<html:link action="/xoaDeThi?maDeThi=${maDeThi}" style="margin-left: 30px;">
                		<span class="glyphicon glyphicon-trash"></span>
                	</html:link>
                	<html:link action="/chiTietDeThi?maDeThi=${maDeThi}" style="margin-left: 10px;">
                		<span class="glyphicon glyphicon-eye-open"></span>
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