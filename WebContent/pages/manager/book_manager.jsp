<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>

<%-- 静态包含，头部信息
		base标签+jquery+css样式
 --%>
<%@ include file="/pages/common/head.jsp" %>
<script type="text/javascript">
	
	$(function(){
		// 给删除的a标签绑定单击事件
		$("a.deleteA").click(function(){
			//confirm 它是javaScript语言中提供的一个确认提示框函数。
			// 传递的参数就是提示框提示内容
			// 它有两个按钮，一个确定，一个取消，当用户点击了确定之后返回true，当用户点击了取消之后返回false
			return confirm("你确认要删除【" + $(this).parent().parent().find("td:first").text() + "】吗?");
		});
		
	});
	
</script>
</head>
<body>
	
	
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>

		<%-- 静态包含manager模块的菜单 --%>
		<%@ include file="/pages/common/manager_menu.jsp" %>


	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>	
			<c:forEach items="${ requestScope.page.items }" var="book">
				<tr>
					<td>${ book.name }</td>
					<td>${ book.price }</td>
					<td>${ book.author }</td>
					<td>${ book.sales }</td>
					<td>${ book.stock }</td>
					<td><a href="manager/bookServlet?action=getBook&id=${ book.id }&pageNo=${ requestScope.page.pageNo }">修改</a></td>
					<td><a class="deleteA" href="manager/bookServlet?action=delete&id=${ book.id }&pageNo=${ requestScope.page.pageNo }">删除</a></td>
				</tr>	
			</c:forEach>	
			
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp">添加图书</a></td>
			</tr>	
		</table>

	<%@ include file="/pages/common/page.jsp" %>

		
	</div>
	
	
	<%-- 静态包含页脚 --%>
	<%@ include file="/pages/common/footer.jsp" %>
	
</body>
</html>