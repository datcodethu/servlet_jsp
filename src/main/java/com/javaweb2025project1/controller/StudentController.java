//package com.javaweb2025project1.controller;
//
//import com.javaweb2025project1.model.StudentModel;
//import com.javaweb2025project1.service.StudentService;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//
//@WebServlet(value = "/student")
//public class StudentController {
//    private final StudentService studentService;
//
//    public StudentController(StudentService studentService) {
//        this.studentService = studentService;
//    }
//
//    public void doGet(HttpServletRequest rq, HttpServletResponse rsp) throws IOException, ServletException, SQLException {
//        String action = rq.getParameter("action");
//        switch (action) {
//            case "":
//                try {
//                    List<StudentModel> list = studentService.getAllStudents();
//                    rq.setAttribute("list", list);
//                    rq.getRequestDispatcher("/component/index.jsp").forward(rq, rsp);
//                }catch (Exception e) {
//                    e.printStackTrace();
//                }
//                break;
//            case "add":
//                rq.getRequestDispatcher("/add.jsp").forward(rq, rsp);
//                break;
//            case "new":
//                rq.getRequestDispatcher("/new.jsp").forward(rq, rsp);
//                break;
//            case "edit":
//                int id = Integer.parseInt(rq.getParameter("id"));
//                StudentModel studentModel = studentService.getStudentById(id);
//                rq.setAttribute("student", studentModel);
//                rq.getRequestDispatcher("/edit.jsp").forward(rq, rsp);
//                break;
//            case "delete":
//                int student_id = Integer.parseInt(rq.getParameter("id"));
//                studentService.deleteStudent(student_id);
//                break;
//        }
//    }
//}
