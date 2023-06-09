package com.kodeoo.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    // Default constructor (required for DB READ operation)
    public Student(){
        // Add here init stuff if needed
    }

    // Define fields

    // The @Id annotation specifies the primary key of the entity
    @Id
    // The @GeneratedValue annotation indicates that the ID should be automatically generated
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    // The @Column annotation specifies the mapping between the field and the corresponding column in the table
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    // Define constructors

    // Constructor used to create instances of the Student class with the provided values
    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Define getter and setter methods

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Define toString() method

    @Override // (what does it do?)
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
