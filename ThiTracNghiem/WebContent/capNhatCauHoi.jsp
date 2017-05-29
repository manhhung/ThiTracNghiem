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
    <title>Cập nhật câu hỏi</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h3>Cập nhật câu hỏi</h3>
    <br>
	<html:form action="/capNhatCauHoi" method="post">
	
	
	    <div class="row form-group">
            <label class="col-lg-2">Mã câu hỏi</label>
            <div class="col-lg-3">
            	<html:text property="maCauHoi" styleClass="form-control" readonly="true"></html:text>
            </div>
       	</div>
	
	
		 <div class="row form-group">
            <label class="col-lg-2">Môn thi</label>
            <div class="col-lg-3">
            	<html:select property="maMon" styleClass="form-control">
            		<html:optionsCollection name="cauHoiForm" property="listMonThi" label="tenMon" value="maMon"/>
            	</html:select>
            </div>
       	</div>
        		
        <div class="row form-group">
            <label class="col-lg-2">Nội dung câu hỏi</label>
            <div class="col-lg-3">
            	<html:textarea property="noiDung" styleClass="form-control"></html:textarea>
            	<html:errors property="noiDungError"/>
            </div>
        </div>
        
        <div class="row form-group">
            <label class="col-lg-2">Phương án 1</label>
            <div class="col-lg-3">
            	<html:text property="dapAn1" styleClass="form-control"></html:text>
            	<html:errors property="dapAnError"/>
            </div>
        </div>
        
        <div class="row form-group">
            <label class="col-lg-2">Phương án 2</label>
            <div class="col-lg-3">
            	<html:text property="dapAn2" styleClass="form-control"></html:text>
            	<html:errors property="dapAnError"/>
            </div>
        </div>
        
        <div class="row form-group">
            <label class="col-lg-2">Phương án 3</label>
            <div class="col-lg-3">
            	<html:text property="dapAn3" styleClass="form-control"></html:text>
            	<html:errors property="dapAnError"/>
            </div>
        </div>
        
         <div class="row form-group">
            <label class="col-lg-2">Phương án 4</label>
            <div class="col-lg-3">
            	<html:text property="dapAn4" styleClass="form-control"></html:text>
            	<html:errors property="dapAnError"/>
            </div>
        </div>
        
         <div class="row form-group">
            <label class="col-lg-2">Đáp án đúng</label>
            <div class="col-lg-3">
            	<html:select property="dapAnDung" styleClass="form-control">
				<html:optionsCollection name="cauHoiForm" property="pair" label="name" value="id"/>
				</html:select>
            </div>
       	</div>
      	          
        <div class="row form-group">
            <div class="col-lg-3 col-lg-offset-2">
            	<html:submit styleClass="btn btn-warning" property="submit" value="Lưu lại">Lưu lại</html:submit>
                <button class="btn btn-primary" onclick="history.go(-1);">Quay lại</button>
            </div>
        </div>
    </html:form>
    <br>
</div>
</body>
</html>