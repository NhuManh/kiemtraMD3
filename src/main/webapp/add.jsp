<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm mặt bằng</title>
</head>
<body>
<h2>Thêm mặt bằng mới</h2>
<form action="add_matbang" method="post">
    <label for="maMatBang">Mã mặt bằng:</label>
    <input type="text" id="maMatBang" name="maMatBang" required><br>

    <label for="trangThai">Trạng thái:</label>
    <input type="text" id="trangThai" name="trangThai" required><br>

    <label for="dienTich">Diện tích:</label>
    <input type="number" id="dienTich" name="dienTich" required><br>

    <label for="tang">Tầng:</label>
    <input type="number" id="tang" name="tang" required><br>

    <label for="loaiMatBang">Loại mặt bằng:</label>
    <input type="text" id="loaiMatBang" name="loaiMatBang" required><br>

    <label for="giaTien">Giá tiền:</label>
    <input type="number" id="giaTien" name="giaTien" required><br>

    <label for="ngayBatDau">Ngày bắt đầu:</label>
    <input type="date" id="ngayBatDau" name="ngayBatDau" required><br>

    <label for="ngayKetThuc">Ngày kết thúc:</label>
    <input type="date" id="ngayKetThuc" name="ngayKetThuc" required><br>

    <input type="submit" value="Thêm mặt bằng">
</form>
<a href="student_list.jsp">Trở về danh sách mặt bằng</a>
</body>
</html>
