<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Sửa sinh viên</title>
</head>
<body>
<h1>Sửa sinh viên</h1>
<form action="students?action=edit" method="post">
  <input type="hidden" name="id" value="<%= ((com.javaweb2025project1.model.StudentModel)request.getAttribute("student")).getId() %>">
  Tên: <input type="text" name="name" value="<%= ((com.javaweb2025project1.model.StudentModel)request.getAttribute("student")).getName() %>" required><br><br>
  Tuổi: <input type="number" name="age" value="<%= ((com.javaweb2025project1.model.StudentModel)request.getAttribute("student")).getAge() %>" required><br><br>
  <button type="submit">Cập nhật</button>
</form>
<a href="students?action=list">Quay lại</a>
</body>
</html>
