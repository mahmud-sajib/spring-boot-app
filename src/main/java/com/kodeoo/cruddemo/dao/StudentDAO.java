package com.kodeoo.cruddemo.dao;

import com.kodeoo.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    // save to db
    void save(Student theStudent);

    // find from db
    Student findById(Integer id);

    // query from db
    List<Student> findAll();
}
