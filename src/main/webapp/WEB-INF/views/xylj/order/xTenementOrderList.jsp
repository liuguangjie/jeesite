<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>dd管理</title>
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
		<li class="active"><a href="${ctx}/order/xTenementOrder/">dd列表</a></li>
		<shiro:hasPermission name="order:xTenementOrder:edit"><li><a href="${ctx}/order/xTenementOrder/form">dd添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="xTenementOrder" action="${ctx}/order/xTenementOrder/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>缴费人名称：</label>
				<form:input path="userName" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>缴费人电话：</label>
				<form:input path="userPhone" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>缴费房间：</label>
				<form:input path="roomId" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>缴费类型(1:物业费 2: 供暖费 3: 生活垃圾费)：</label>
				<form:input path="feeType" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>缴费类型名称：</label>
				<form:input path="typeName" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>订单号：</label>
				<form:input path="propertyOrderNumber" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>滞纳金：</label>
				<form:input path="fine" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>总金额：</label>
				<form:input path="subtotal" htmlEscape="false" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<shiro:hasPermission name="order:xTenementOrder:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="xTenementOrder">
			<tr>
				<shiro:hasPermission name="order:xTenementOrder:edit"><td>
    				<a href="${ctx}/order/xTenementOrder/form?id=${xTenementOrder.id}">修改</a>
					<a href="${ctx}/order/xTenementOrder/delete?id=${xTenementOrder.id}" onclick="return confirmx('确认要删除该dd吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>