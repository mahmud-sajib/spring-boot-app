package com.kodeoo.cruddemo;

import com.kodeoo.cruddemo.dao.StudentDAO;
import com.kodeoo.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	// Bean definition for CommandLineRunner
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			// The createStudent method creates a new Student object with the provided values and
			// saves it using the studentDAO bean.
			// createMultipleStudent(studentDAO); // Method invoked when the application starts
			// readStudent(studentDAO); // Method invoked when the application starts
			// queryStudent(studentDAO);
			// queryStudentByLastName(studentDAO);
			updateStudent(studentDAO);
		};
	}

	// Multiple READ operation
	private void updateStudent(StudentDAO studentDAO){
		// retrieve student based on id
		int studentId = 1;
		Student myStudent = studentDAO.findById(studentId);

		// change firstName
		myStudent.setFirstName("Khabi");

		// update the student
		studentDAO.update(myStudent);

		// display info of the updated student
		System.out.println(myStudent);
	}
}
