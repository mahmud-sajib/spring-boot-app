package com.kodeoo.cruddemo;

import com.kodeoo.cruddemo.dao.StudentDAO;
import com.kodeoo.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
			readStudent(studentDAO); // Method invoked when the application starts
		};
	}

	// Single READ operation
	private void readStudent(StudentDAO studentDAO) {
		// create new student objects
		System.out.println("Creating students...");
		Student tempStudent = new Student("Naomi", "Eli", "eli@yahoo.com");

		// save new student objects
		System.out.println("Saving students...");
		studentDAO.save(tempStudent);

		// display student id
		int theId =  tempStudent.getId();

		// get id of the student object
		System.out.println("Student Id " + theId);

		// retrieve student based on id
		System.out.println("Retrieve Student by Id...");
		Student myStudent = studentDAO.findById(theId);

		// display student info
		System.out.println("Student found...");
		System.out.println(myStudent);

	}
}
