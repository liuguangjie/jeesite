<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>保存&ldquo;某某&rdquo;成功管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sql/datatable/">数据库表</a></li>
		<li class="active"><a href="${ctx}/sql/datatable">添加表</a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="modelWrap" action="${ctx}/sql/datatable/addTable" method="post" class="form-horizontal">
		<sys:message content="${message}"/>

		<div class="control-group">
			<label class="control-label">创建表的sql语句：</label>
			<div class="controls">
				<form:textarea path="createSql" htmlEscape="false" rows="30"  class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>