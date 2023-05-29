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
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			deleteAllStudent(studentDAO);
		};
	}

	// Single DELETE operation
	//	private void deleteStudent(StudentDAO studentDAO){
	//		// delete student based on id
	//		int studentId = 8;
	//		studentDAO.delete(studentId);
	//	}

	// Multiple DELETE operation
	private void deleteAllStudent(StudentDAO studentDAO){
		int itemsDeleted = studentDAO.deleteAll();
		System.out.println("Rows deleted " + itemsDeleted);
	}

}
