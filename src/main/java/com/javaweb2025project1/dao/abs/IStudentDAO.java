package com.javaweb2025project1.dao.abs;

import com.javaweb2025project1.model.StudentModel;
import java.sql.SQLException;
import java.util.List;

public interface IStudentDAO {
    List<StudentModel> getAll() throws SQLException;

    StudentModel getById(int id) throws SQLException;

    boolean create(StudentModel student) throws SQLException;

    boolean update(StudentModel student) throws SQLException;

    void delete(int id) throws SQLException;
}
