package com.javaweb2025project1.dao.ipl;

import com.javaweb2025project1.config.DBConnection;
import com.javaweb2025project1.dao.abs.IStudentDAO;
import com.javaweb2025project1.mapper.StudentMapper;
import com.javaweb2025project1.model.StudentModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudentDAO {
    @Override
    public List<StudentModel> getAll() throws SQLException {
        Connection conn = DBConnection.getConnection();
        List<StudentModel> result = new ArrayList<>();

        if (conn != null) {
            PreparedStatement statement = conn.prepareStatement("select * from students");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                result.add(StudentMapper.toStudentModel(resultSet));
            }
            return result;
        }
        return List.of();
    }

    @Override
    public StudentModel getById(int id) throws SQLException {
        String sql = "select * from students where id = ?";
        Connection conn = DBConnection.getConnection();
        if (conn != null) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            StudentModel studentModel = null;
            while (resultSet.next()){
                studentModel = StudentMapper.toStudentModel(resultSet);
            }
            return studentModel;
        }
        return null;
    }

    @Override
    public boolean create(StudentModel student) throws SQLException {
        String sql = "insert into students (name,age) values(?,?)";
        Connection conn = DBConnection.getConnection();
        if (conn != null) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,student.getName());
            statement.setInt(2,student.getAge());
            statement.executeUpdate();
            return true;
        }
        return false;
    }

    @Override
    public boolean update(StudentModel student) throws SQLException {
        String sql = "update students set name=?,age=? where id=?";
        Connection conn = DBConnection.getConnection();
        if (conn != null) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,student.getName());
            statement.setInt(2,student.getAge());
            statement.setInt(3,student.getId());
            statement.executeUpdate();
            return true;
        }
        return false;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "delete from students where id=?";
        Connection conn = DBConnection.getConnection();
        if (conn != null) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,id);
            statement.executeUpdate();
        }
    }
}
