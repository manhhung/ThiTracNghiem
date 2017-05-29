<%@page import="model.bean.DeThi"%>
<%@page import="model.bean.MonThi"%>
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
    <title>Xóa đề thi</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h3>Xóa đề thi có mã:  
		<bean:write name="deThiForm" property="maDeThi"/>
	</h3>
    <br>
	<html:form action="/xoaDeThi" method="post">
    
          <div class="row form-group">
            <label class="col-lg-2">Mã đề thi</label>
            <div class="col-lg-3">
            	<html:text property="maDeThi" styleClass="form-control"  readonly="true"></html:text>
            	<html:errors property="maDeThiError"/>
            </div>
        </div>
        
         <div class="row form-group">
        	<label class="col-lg-2">Môn thi</label>
            <div class="col-lg-3">
            	<html:select property="maMon" styleClass="form-control" disabled="true">
            		<html:optionsCollection name="deThiForm" property="listMonThi" label="tenMon" value="maMon" />
            	</html:select>
            </div>
       	</div>
        
            <div class="row form-group">
            <label class="col-lg-2">Thời gian thi</label>
            <div class="col-lg-3">
            	<html:text property="thoiGianThi" styleClass="form-control" readonly="true"></html:text>
            	<html:errors property="thoiGianThiError"/>
            </div>
        </div>
        
        <div class="row form-group">
            <label class="col-lg-2">Số lượng câu hỏi</label>
            <div class="col-lg-3">
            	<html:text property="soLuongCauHoi" styleClass="form-control" readonly="true"></html:text>
            	<html:errors property="soLuongError"/>
            </div>
        </div>
       	
        <div class="row form-group">
            <div class="col-lg-3 col-lg-offset-2">
                <html:submit styleClass="btn btn-warning" property="submit" value="Xác nhận">Xác nhận</html:submit>
                <button class="btn btn-primary" onclick="history.go(-1);">Quay lại</button>
            </div>
        </div>
    </html:form>
</div>
</body>
</html>