<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>Hello====
		<li><a href="${pageContext.request.contextPath}/index.kic">index.kic</a></li>
		<li><a href="${pageContext.request.contextPath}/index2.kic">index2.kic.do</a></li>
		<li><a href="${pageContext.request.contextPath}/index.kic2">index.kic2</a></li>
	</ul>

	<ul>
		<li>model
		<li><a href="${pageContext.request.contextPath}/event/list">event/list</a></li>
	</ul>

	<ul>
		<li>@RequestMapping, @PathVariable:</li>
		<li><a href="${pageContext.request.contextPath}/member/regist">/member/regist</a>:
			GET/POST 예, RegistrationController</li>


		<li><a href="<%=request.getContextPath()%>/members">/members</a>:
			@PathVariable 사용 위한 목록 출력, MemberController.members()</li>
		<li><a href="<%=request.getContextPath()%>/members/m2">/members/m2</a>:
			@PathVariable 예, MemberController.memberDetail()</li>

		<li><a href="<%=request.getContextPath()%>/members/m2/orders/1">/members/m2/orders/1</a>:
			@PathVariable 예, MemberController.memberOrderDetail()</li>
		<li><a href="<%=request.getContextPath()%>/members/m2/orders/1a">/members/m2/orders/1a</a>:
			@PathVariable 400 응답 예, MemberController.memberOrderDetail()</li>

		<li><a href="<%=request.getContextPath()%>/files/a123">/files/a123</a>:
			@PathVariable 정규표현식, FileController.fileInfo()</li>


		<li><a href="<%=request.getContextPath()%>/files/a1">/files/a1</a>:
			@PathVariable 정규표현식 404, FileController.fileInfo()</li>
		<li><a href="<%=request.getContextPath()%>/folders/1/2/3/files">/folders/1/2/3/files</a>:
			@RequestMapping Ant패턴, FileController.list()</li>


	</ul>
	<ul>
		<li><a href="<%=request.getContextPath()%>/upload/form">/upload/form</a>:
			파일 업로드 폼, UploadController</li>
	</ul>
	<ul>
		<li><a href="<%=request.getContextPath()%>/acl/list">/acl/list</a>
			: 커맨드 객체 리스트 처리, AclController</li>
		<li><a href="<%=request.getContextPath()%>/auth/login">/auth/login</a>:
			LoginController</li>
	</ul>
</body>
</html>