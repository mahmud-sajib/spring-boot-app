package com.kodeoo.cruddemo.dao;

import com.kodeoo.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Indicates that it is a Spring repository bean.
public class StudentDAOImpl implements StudentDAO {

    // The EntityManager object is used for interacting with the persistence context and the underlying database.
    private EntityManager entityManager;

    // Constructor-based injection using @Autowired annotation
    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    // Overriding the save() method from the StudentDAO interface
    @Override
    @Transactional
    public void save(Student theStudent){
        // Saving the provided Student entity using the EntityManager
        entityManager.persist(theStudent);
    }

    // Overriding the findById() method from the StudentDAO interface
    @Override
    public Student findById(Integer id) {
        // Find and return the Student entity with the given ID using the EntityManager
        return entityManager.find(Student.class, id);
    }

    // Overriding the findAll() method from the StudentDAO interface
    @Override
    public List<Student> findAll() {
        // create query
        // Find and return all the Students using the EntityManager
        // TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        // create query (in asc/desc order)
        // Find and return all the Students using the EntityManager (filter using last name in ascending order)
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName asc", Student.class);

        // return result
        return theQuery.getResultList();
    }

    // Overriding the findByLastName() method from the StudentDAO interface
    @Override
    public List<Student> findByLastName(String theLastName) {
        // create query
        // Find and return specific Students using the EntityManager (whose last name matches given input)
        TypedQuery<Student> theQuery = entityManager.createQuery(
                 "FROM Student WHERE lastName=:theData", Student.class);

        // set query parameters
        theQuery.setParameter("theData", theLastName);

        // return result
        return theQuery.getResultList();

    }

    // Overriding the update() method from the StudentDAO interface
    @Override
    @Transactional
    public void update(Student theStudent) {
        // Updating the provided Student entity using the EntityManager
        entityManager.merge(theStudent);
    }

    // Overriding the delete() method from the StudentDAO interface
    @Override
    @Transactional
    public void delete(Integer id) {
        // retrieve the student by id
        Student theStudent = entityManager.find(Student.class,id);

        // remove the student
        entityManager.remove(theStudent);
    }

    // Overriding the deleteAll() method from the StudentDAO interface
    @Override
    @Transactional
    public int deleteAll() {
        int itemsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return itemsDeleted;
    }



}
