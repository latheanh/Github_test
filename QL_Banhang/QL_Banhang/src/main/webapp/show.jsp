<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body class="d-flex justify-content-center align-item-center"
	height="100vh">
	<div>
		<h1 class="text-center">Thông Tin Bán Hàng</h1>
		<table class="table mt-5">
			<thead class="thead-light">
				<tr>
					<th scope="col">Mã Bán Hàng</th>
					<th scope="col">Tên Hàng</th>
					<th scope="col">Ngày Nhập</th>
					<th scope="col">Nhóm Hàng</th>
					<th scope="col">Số Lượng</th>
					<th scope="col"></th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<c:forEach items="${listBH}" var="x">
						<td>${x.id}</td>
						<td>${x.tenhang}</td>
						<td>${x.ngaynhap}</td>
						<td>${x.nhomhang}</td>
						<td>${x.soluong}</td>
						<td><button>
								<a href="edit?id=${x.id}">Sửa</a>
							</button>
							<button>
								<a href="delete?id=${x.id}">Xóa</a>
							</button></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<button>
			<a href="create.jsp">Thêm</a>
		</button>
	</div>
</body>
</html>