<%@page import="model.bean.MonThi"%>
<%@page import="common.StringProcess"%>
<%@page import="model.bean.CauHoi"%>
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
    <title>QUẢN LÝ CÂU HỎI</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <html:form action="/cau-hoi" method="get">
        
        	<div class ="col-sm-4">
        	 <button class="btn btn-danger" onclick= "document.forms[0].action = 'giaoDienQuanLy.jsp'"><span class="glyphicon glyphicon-home"></span> Trang Chủ</button>
        	</div>
        	<br>
        </br>
		<h3 style="font-size:30px"><b><center>QUẢN LÝ CÂU HỎI</center></b></h3>
		</br>
            <div class="col-lg-4">
                <html:select property="maMon" styleClass="form-control">
					<option value="">-- Chọn môn --</option>
					<html:optionsCollection name="danhSachCauHoiForm" property="listMonThi" 
						label="tenMon" value="maMon" />
				</html:select>
            </div>
            <script type="text/javascript">
            	$("[name='maMon']").val('<bean:write name="danhSachCauHoiForm" property="maMon"/>');
            </script>
            <html:submit styleClass="btn btn-primary">Xem</html:submit>
            <div class="col-lg-2 pull-right">
            	<html:link styleClass="btn btn-success" action="/themCauHoi"><span class="glyphicon glyphicon-plus"></span> Thêm mới</html:link>
            </div>
        </html:form>
    </div>
    <br>
    
    
    
    <div class="bs-example">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Mã câu hỏi</th>
                <th>Tên môn</th>
                <th>Nội dung</th>
                <th>Đáp án 1</th>
                <th>Đáp án 2</th>
                <th>Đáp án 3</th>
                <th>Đáp án 4</th>
                <th>Đáp án đúng</th>
                <th>Thao tác</th>
            </tr>
            </thead>
            <tbody>
            <logic:iterate name="danhSachCauHoiForm" property="listCauHoi" id="ch">
            	<tr>
                <th scope="row">
                	<bean:write name="ch" property="maCauHoi"/>
				</th>
                <td>
                	<bean:write name="ch" property="tenMon"/>
                </td>
                <td>
                	<bean:write name="ch" property="noiDung"/>
				</td>
                <td>
                	<bean:write name="ch" property="dapAn1"/>
                </td>
                <td>
                	<bean:write name="ch" property="dapAn2"/>
                </td>
                <td>
                	<bean:write name="ch" property="dapAn3"/>
                </td>
                <td>
                	<bean:write name="ch" property="dapAn4"/>
                </td>
                <td>
                	<bean:write name="ch" property="dapAnDung"/>
                </td>
                <td>
               	 	<bean:define id="maCauHoi" name="ch" property="maCauHoi"></bean:define>
                	<html:link action="/capNhatCauHoi?maCauHoi=${maCauHoi}">
                		<span class="glyphicon glyphicon-edit"></span>
                	</html:link>
                	<html:link action="/xoaCauHoi?maCauHoi=${maCauHoi}" style="margin-left: 30px;">
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