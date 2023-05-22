<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h1 class="text-center">Thêm Thông Tin bán hàng</h1>
	<div class="box d-flex justify-content-center align-item-center mt-5">
		<form class="w-50" action="create" method="post">
			<div class="mb-3">
				<label for="" class="form-label">Tên hàng </label> <input
					type="text" class="form-control" id="" aria-describedby=""
					name="tenhang">

			</div>
			<div class="mb-3">
				<label for="" class="form-label">Ngày Nhập</label> <input
					type="date" class="form-control" id="" name="ngaynhap">
			</div>

			<div class="mb-3">
				<label for="" class="form-label">Nhóm hàng</label> <input
					type="text" class="form-control" id="" name="nhomhang">
			</div>
			<div class="mb-3">
				<label for="" class="form-label">Số lượng</label> <input
					type="number" class="form-control" id="" name="soluong">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>