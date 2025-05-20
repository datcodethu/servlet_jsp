<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Thêm sinh viên</title>
</head>
<body>
<h1>Thêm sinh viên mới</h1>
<form action="students?action=add" method="post">
    Tên: <input type="text" name="name" required><br><br>
    Tuổi: <input type="number" name="age" required><br><br>
    <button type="submit">Lưu</button>
</form>
<a href="students?action=list">Quay lại</a>
</body>
</html>
