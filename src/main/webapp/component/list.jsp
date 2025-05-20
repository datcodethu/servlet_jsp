<%@ page import="com.javaweb2025project1.model.StudentModel" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Danh sách sinh viên</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        a {
            text-decoration: none;
            color: white;
            background-color: #4CAF50;
            padding: 8px 12px;
            border-radius: 4px;
            margin-bottom: 20px;
            display: inline-block;
        }
        a:hover {
            background-color: #45a049;
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background: white;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
        }
        th, td {
            padding: 12px 15px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        .action-links a {
            background-color: #2196F3;
            margin: 0 5px;
        }
        .action-links a:hover {
            background-color: #0b7dda;
        }
        .action-links a.delete {
            background-color: #f44336;
        }
        .action-links a.delete:hover {
            background-color: #da190b;
        }
    </style>
</head>
<body>
<h1>Danh sách sinh viên</h1>
<div style="text-align: center;">
    <a href="students?action=add">Thêm mới</a>
</div>
<table>
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Hành động</th>
    </tr>
    <%
        List<com.javaweb2025project1.model.StudentModel> students =
                (List<StudentModel>) request.getAttribute("students");
        if (students != null) {
            for (com.javaweb2025project1.model.StudentModel student : students) {
    %>
    <tr>
        <td><%= student.getId() %></td>
        <td><%= student.getName() %></td>
        <td><%= student.getAge() %></td>
        <td class="action-links">
            <a href="students?action=edit&id=<%= student.getId() %>">Sửa</a>
            <a href="students?action=delete&id=<%= student.getId() %>" class="delete">Xóa</a>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
