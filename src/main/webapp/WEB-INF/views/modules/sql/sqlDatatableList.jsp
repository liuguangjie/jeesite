<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>保存&ldquo;某某&rdquo;成功管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sql/datatable/">数据库表</a></li>
		<li><a href="${ctx}/sql/datatable/form">添加表</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="sqlDatatable" action="${ctx}/sql/datatable/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>表名：</label>
				<%--<form:input path="name" htmlEscape="false" maxlength="100" class="input-medium"/>--%>
				<input type="text" name="name"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>表明</th>
				<th>备注信息</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${requestScope.rowList}" var="row">
			<tr>
				<td><a href="${ctx}/sql/datatable/form">
					${row.name}
				</a></td>
				<td>
					${row.comments}
				</td>
				<td>
    				<a href="${ctx}/sql/datatable/form?name=${row.name}">修改</a>
					<a href="${ctx}/sql/datatable/delTable?name=${row.name}" onclick="return confirmx('确认要删除${row.name}表&rdquo;吗？', this.href)">删除</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<%-- 分页 page --%>
	<div class="pagination">${page}</div>
</body>
</html>