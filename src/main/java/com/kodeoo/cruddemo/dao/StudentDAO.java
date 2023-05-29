package com.kodeoo.cruddemo.dao;

import com.kodeoo.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    // save to db
    void save(Student theStudent);

    // find from db (by id)
    Student findById(Integer id);

    // query from db
    List<Student> findAll();

    // find from db (by lastName)
    List<Student> findByLastName(String theLastName);

    // update to db
    void update(Student theStudent);

    // delete from db
    void delete(Integer id);

    // delete all from DB
    int deleteAll();

}
