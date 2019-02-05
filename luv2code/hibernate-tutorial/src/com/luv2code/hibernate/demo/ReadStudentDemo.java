package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create a student object
			System.out.println("creating a new student object...");
			Student tempStudent = new Student("Daffy", "duck", "daffy@luv2code.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("saving student...");
			System.out.println(tempStudent);

			session.save(tempStudent);

			// commit the transaction
			session.getTransaction().commit();

			// my new code

			// find out the students id: primary key
			System.out.println("saved student. generated id " + tempStudent.getId());

			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + tempStudent.getId());

			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("get complete: " + myStudent);

			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("done!");
			
		} finally {
			factory.close();
		}

	}

}
