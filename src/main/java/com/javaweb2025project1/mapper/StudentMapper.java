package com.javaweb2025project1.mapper;

import com.javaweb2025project1.model.StudentModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentMapper {
    public static List<StudentModel> toStudentList(ResultSet rs) throws SQLException {
        List<StudentModel> list = new ArrayList<>();
        while (rs.next()) {
            StudentModel studentModel = new StudentModel();
            studentModel.setId(rs.getInt("id"));
            studentModel.setName(rs.getString("name"));
            studentModel.setAge(rs.getInt("age"));
            list.add(studentModel);
        }
        return list;
    }
    public static StudentModel toStudentModel(ResultSet rs) throws SQLException {
        StudentModel studentModel = new StudentModel();
        studentModel.setId(rs.getInt("id"));
        studentModel.setName(rs.getString("name"));
        studentModel.setAge(rs.getInt("age"));
        return studentModel;
    }

}
