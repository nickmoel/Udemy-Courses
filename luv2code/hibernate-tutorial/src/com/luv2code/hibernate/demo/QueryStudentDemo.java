package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// query students
			List<Student> theStudents = session.createQuery("from Student").list();

			// display the students
			displayStudents(theStudents);

			// query students: lastName='Arthur'
			theStudents = session.createQuery("from Student s where s.lastName='Arthur'").list();

			// display the students
			System.out.println("\n\nstudents who have lastName of Arthur: " + theStudents);
			displayStudents(theStudents);

			// query students: lastName='Arthur' OR firstName='Daffy'
			theStudents = session.createQuery("from Student s where s.lastName='Arthur' OR s.firstName='Daffy'").list();

			// display the students
			System.out.println("\n\nstudents who have lastName of Arthur or firstName of Daffy: " + theStudents);
			displayStudents(theStudents);

			// query students: where email like luv2code
			theStudents = session.createQuery("from Student s where s.email LIKE '%luv2code.com'").list();

			// display the students
			System.out.println("\n\nstudents who have email of luv2Code.com: " + theStudents);
			displayStudents(theStudents);

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("done!");
		} finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) { // made from refactor>extract method on Query
																		// Students method
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
//If you are using Hibernate 5.2 or higher, then the Query list() method has been deprecated.
//
//In your code you should make the following update:
//
//Replace
//
//session.createQuery("from Student").list()
//
//With
//
//session.createQuery("from Student").getResultList()