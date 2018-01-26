<div class="container">

	<div class="row">
		
		<!-- To display side bar -->
		<div class="col-md-3">
			
			<%@include file="./shared/sidebar.jsp" %>
			
		</div>
		
		
		<!-- To display actual bar -->
		<div class="col-md-9">
			
			<div class="row">
				
				<!-- Added breadcrumb component -->
				<div class="col-lg-12">
					all products
					<c:if test="${userClicksAllProducts==true}">
						<ol class="breadcrumb">
							<li><a href="${contextRoot }/home">Home</a></li>
							<li class="active">All products</li>
						</ol>
					</c:if>
					
					<c:if test="${userClicksCategoryProducts==true}">
					category by id
						<ol class="breadcrumb">
							<li><a href="${contextRoot }/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>
						</ol>
					</c:if>
					
				</div>
			</div>
			
			
		</div>
		
		
	</div>

</div>