package com.javaweb2025project1.servlet;

import com.javaweb2025project1.config.DBConnection;
import com.javaweb2025project1.model.StudentModel;
import com.javaweb2025project1.service.StudentService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(value = "/students")
public class StudentServlet extends HttpServlet {
    private StudentService studentService;

    @Override
    public void init() throws ServletException {
        studentService = new StudentService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        try {
            switch (action) {
                case "list":
                    showListForm(request, response);
                    break;
                case "add":
                    showAddForm(request, response);
                    break;
                case "edit":
                    showEditFrom(request, response);
                    break;
                case "delete":
                    showDeleteForm(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "add":
                    add(request, response);
                    break;
                case "edit":
                    edit(request, response);
                    break;
                case "delete":
                    delete(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void showAddForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        RequestDispatcher deDispatcher = request.getRequestDispatcher("component/add.jsp");
        deDispatcher.forward(request, response);
    }

    public void showListForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        request.setAttribute("students", studentService.getAllStudents());
        RequestDispatcher deDispatcher = request.getRequestDispatcher("/component/list.jsp");
        deDispatcher.forward(request, response);
    }

    public void showEditFrom(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        StudentModel studentModel = studentService.getStudentById(id);
        if (studentModel != null) {
            request.setAttribute("student", studentModel);
        }
        RequestDispatcher deDispatcher = request.getRequestDispatcher("/component/edit.jsp");
        deDispatcher.forward(request, response);
    }

    public void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        StudentModel studentModel = studentService.getStudentById(id);
        if (studentModel != null) {
            request.setAttribute("student", studentModel);
        }
        RequestDispatcher deDispatcher = request.getRequestDispatcher("/component/delete.jsp");
        deDispatcher.forward(request, response);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        StudentModel studentModel = new StudentModel();
        studentModel.setName(request.getParameter("name"));
        studentModel.setAge(Integer.parseInt(request.getParameter("age")));
        studentService.addStudent(studentModel);
        response.sendRedirect("students?action=list");
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        StudentModel studentModel = studentService.getStudentById(id);
        if (studentModel != null) {
            studentModel.setName(request.getParameter("name"));
            studentModel.setAge(Integer.parseInt(request.getParameter("age")));
            studentService.updateStudent(studentModel);
        }
        response.sendRedirect("students?action=list");
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentService.deleteStudent(id);
        response.sendRedirect("students?action=list");
    }
}
