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
			createMultipleStudent(studentDAO); // Method invoked when the application starts
		};
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		// create new student objects
		System.out.println("Creating students...");
		Student tempStudent1 = new Student("Mary", "Kin", "mary@yahoo.com");
		Student tempStudent2 = new Student("Ovi", "Sen", "ovi@yahoo.com");
		Student tempStudent3 = new Student("Son", "Xin", "son@yahoo.com");

		// save new student objects
		System.out.println("Saving students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		// get id of the student object
		System.out.println("Student Id " + tempStudent2.getId());
	}
}
