<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Xóa sinh viên</title>
</head>
<body>
<h1>Xóa sinh viên</h1>
<p>Bạn có chắc chắn muốn xóa sinh viên <b><%= ((com.javaweb2025project1.model.StudentModel)request.getAttribute("student")).getName() %></b> không?</p>
<form action="students?action=delete" method="post">
    <input type="hidden" name="id" value="<%= ((com.javaweb2025project1.model.StudentModel)request.getAttribute("student")).getId() %>">
    <button type="submit">Xóa</button>
    <a href="students?action=list">Hủy</a>
</form>
</body>
</html>
