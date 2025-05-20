package com.javaweb2025project1.dao;

import com.javaweb2025project1.model.StudentModel;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface BaseDAO <T> {
    List<StudentModel> getAll() throws SQLException;
    T getById(int id) throws SQLException;

    boolean create(T obj) throws SQLException;


    boolean update(T obj) throws SQLException;


    boolean delete(int id) throws SQLException;
}
