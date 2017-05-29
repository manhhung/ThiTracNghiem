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
    <title>Chi tiết đề thi</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h3>Chi tiết đề thi</h3>
       <button class="btn btn-primary" onclick="history.go(-1);">Quay lại</button>
    <div class="row">
   
        <html:form action="/chiTietDeThi" method="get">

            <script type="text/javascript">
            	$("[name='maDeThi']").val('<bean:write name="danhSachChiTietDeThiForm" property="maDeThi"/>');
            </script>
          </html:form>
    </div>
    <br>
    <div class="bs-example">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Mã đề thi</th>
                <th>Tên môn</th>
                <th>Mã câu hỏi</th>
                <th>Nội dung</th>
                <th>Đáp án 1</th>
                <th>Đáp án 2</th>
                <th>Đáp án 3</th>
                <th>Đáp án 4</th>
                <th>Đáp án đúng</th>
            </tr>
            </thead>
            <tbody>
            <logic:iterate name="danhSachChiTietDeThiForm" property="listChiTietDeThi" id="ctdt">
            	<tr>
            	<th scope="row">
                	<bean:write name="ctdt" property="maDeThi"/>
				</th>
                <td>
            	    <bean:write name="ctdt" property="tenMon"/>
				</td>
                <td>
                	<bean:write name="ctdt" property="maCauHoi"/>
                </td>
                <td>
                	<bean:write name="ctdt" property="noiDung"/>
				</td>
                <td>
                	<bean:write name="ctdt" property="dapAn1"/>
                </td>
                <td>
                	<bean:write name="ctdt" property="dapAn2"/>
                </td>
                <td>
                	<bean:write name="ctdt" property="dapAn3"/>
                </td>
                <td>
                	<bean:write name="ctdt" property="dapAn4"/>
                </td>
                <td>
                	<bean:write name="ctdt" property="dapAnDung"/>
                </td>
            </tr>
            </logic:iterate>
            </tbody>
        </table>
       
    </div>
</div>
</body>
</html>