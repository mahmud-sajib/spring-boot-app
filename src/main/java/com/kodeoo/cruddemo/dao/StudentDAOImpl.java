package com.kodeoo.cruddemo.dao;

import com.kodeoo.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
        // Persisting the provided Student entity using the EntityManager
        entityManager.persist(theStudent);
    };
}
