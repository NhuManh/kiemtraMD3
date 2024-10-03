<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách mặt bằng</title>
</head>
<body>
<h2>Danh sách mặt bằng</h2>
<a href="add_matbang.jsp">Thêm mặt bằng mới</a>
<table border="1">
    <thead>
    <tr>
        <th>Mã mặt bằng</th>
        <th>Trạng thái</th>
        <th>Diện tích</th>
        <th>Tầng</th>
        <th>Loại mặt bằng</th>
        <th>Giá tiền</th>
        <th>Ngày bắt đầu</th>
        <th>Ngày kết thúc</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="matBang" items="${listMatBang}">
        <tr>
            <td>${matBang.maMatBang}</td>
            <td>${matBang.trangThai}</td>
            <td>${matBang.dienTich}</td>
            <td>${matBang.tang}</td>
            <td>${matBang.loaiMatBang}</td>
            <td>${matBang.giaTien}</td>
            <td>${matBang.ngayBatDau}</td>
            <td>${matBang.ngayKetThuc}</td>
            <td>
                <a href="edit_matbang.jsp?id=${matBang.id}">Sửa</a>
                <a href="delete_matbang?id=${matBang.id}" onclick="return confirm('Bạn có chắc chắn muốn xóa không?');">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
