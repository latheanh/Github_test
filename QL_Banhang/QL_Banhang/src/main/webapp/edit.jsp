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
<body>
	<h1 class="text-center">Sửu Thông Tin bán hàng</h1>
	<div class="box d-flex justify-content-center align-item-center mt-5">
		<form class="w-50" action="edit" method="post">
			<div class="mb-3">
				<label for="" class="form-label">Mã Bán Hàng </label> <input
					class="form-control" type="text" name="id" value="${s.id}" readonly>

			</div>
			<div class="mb-3">
				<label for="" class="form-label">Tên Hàng </label> <input
					class="form-control" type="text" name="tenhang" value="${s.tenhang}">

			</div>
			<div class="mb-3">
				<label for="" class="form-label">Ngày Nhập</label> <input
					type="date" class="form-control" name="ngaynhap"
					value="${s.ngaynhap}">
			</div>

			<div class="mb-3">
				<label for="" class="form-label">Nhóm hàng</label> <input
					type="text" class="form-control" name="nhomhang"
					value="${s.nhomhang}">
			</div>
			<div class="mb-3">
				<label for="" class="form-label">Số lượng</label> <input
					type="number" class="form-control" name="soluong"
					value="${s.soluong}">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
			</form>
</body>
</html>