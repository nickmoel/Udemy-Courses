package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.configure("hibernate.cfg.xml").addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
//			

			// start a transaction
			session.beginTransaction();

			// get instructor by primary key / ID
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			System.out.println("found instructor: " + tempInstructor);

			// delete the instructors
			if (tempInstructor != null) {
				System.out.println("deleting: " + tempInstructor);

				// note: will also delete associated "details" object
				// because of cascadetype.all
				session.delete(tempInstructor);
			}

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("done!");
		} finally {
			factory.close();
		}

	}

}
