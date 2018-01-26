<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<s:url var="css" value="/resources/css" />
<s:url var="js" value="/resources/js" />
<s:url var="images" value="/resources/images" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Shop - ${title}</title>

<script>

	window.menu = $("#hdnMenu").val();
</script>


<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Readable theme-->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/shop-homepage.css" rel="stylesheet">

</head>

<body>

	<div class="wrapper">
		<input type="hidden" id="hdnMenu" value="${title}" />
		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>

		<div class="content">
			<!-- Page Content -->

			<c:if test="${userClicksHome==true}">
				<%@include file="home.jsp"%>
			</c:if>


			<!-- Load only when user click about -->
			<c:if test="${userClicksAbout==true }">
				<%@include file="about.jsp"%>
			</c:if>
			
			<!-- Load only when user click contact -->
			<c:if test="${userClicksContact==true }">
				<%@include file="contact.jsp"%>
			</c:if>
			
			<!-- Load only when user click contact -->
			<c:if test="${userClicksAllProducts==true }">
				<%@include file="listProducts.jsp"%>
			</c:if>
			
			<!-- Load only when user click contact -->
			<c:if test="${userClicksCategoryProducts==true }">
				<%@include file="listProducts.jsp"%>
			</c:if>
			
		</div>
		
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>
		
		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.min.js"></script>
		<script src="${js}/bootstrap.bundle.min.js"></script>
		<script src="${js}/myapp.js"></script>
		
	</div>
	
</body>

</html>