package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
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

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
		//	readStudent(studentDAO);
			//queryForStudents(studentDAO);
		//	queryForStudentsByLastName(studentDAO);

		//	updateStudent(studentDAO);

		//	deleteStudent(studentDAO);

		//	deleteAllStudents(studentDAO);


		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("deleting all student...");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("deleted row count : "+numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 3;
		System.out.println("Deleting student id : "+studentId);
		studentDAO.delete(studentId);







	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 2;
		System.out.println("getting student with id: "+studentId);
		Student myStudent = studentDAO.findById(studentId);
		System.out.println("updating student..");
		myStudent.setFirstName("Marry");
		studentDAO.update(myStudent);
		System.out.println("updated student : "+ myStudent);






	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("doe");
		for (Student temp:theStudents){
			System.out.println(temp);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();
		for (Student temp: theStudents){
			System.out.println(temp);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("create new student....");
		Student temp = new Student("Daffy","Duck","Daffy@luv2code.com");
		System.out.println("save student ");
		studentDAO.save(temp);

		int theId = temp.getId();
		System.out.println("saved student generated id : "+ theId);


		System.out.println("retrieving student with id : "+theId);
		Student myStudent = studentDAO.findById(theId);

		System.out.println("found the student : "+myStudent);





	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("create 3 student object : ");
		Student tempStudent1 = new Student("john","doe","john@luv2code.com");
		Student tempStudent2 = new Student("Mary","Public","mary@luv2code.com");
		Student tempStudent3 = new Student("Bonita","Applebum","bonita@luv2code.com");
		System.out.println("saving the student");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("create new student object : ");
		Student tempStudent = new Student("paul","doe","paul@luv2code.com");
		System.out.println("saving the student");
		studentDAO.save(tempStudent);
		System.out.println("saved student generated id : "+ tempStudent.getId());
	}
}
