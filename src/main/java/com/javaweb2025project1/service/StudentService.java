package com.javaweb2025project1.service;

import com.javaweb2025project1.dao.abs.IStudentDAO;
import com.javaweb2025project1.dao.ipl.StudentDAO;
import com.javaweb2025project1.model.StudentModel;

import java.sql.SQLException;
import java.util.List;

public class StudentService {
    private final IStudentDAO studentDAO;
    public StudentService(){
        this.studentDAO = new StudentDAO();
    }
    public List<StudentModel> getAllStudents() throws SQLException {
        return studentDAO.getAll();
    }
    public StudentModel getStudentById(int id) throws SQLException {
        return studentDAO.getById(id);
    }
    public boolean addStudent(StudentModel studentModel) throws SQLException {
        return studentDAO.create(studentModel);
    }
    public boolean updateStudent(StudentModel studentModel) throws SQLException {
        return studentDAO.update(studentModel);
    }
    public void deleteStudent(int id) throws SQLException {
        studentDAO.delete(id);
    }

}
