package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo { // add instructor and details

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.configure("hibernate.cfg.xml").addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
//			Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
//
//			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube",
//					"luv2code!");
			
			Instructor tempInstructor = new Instructor("bea", "arthur", "arthur@luv2code.com");

			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube",
					"comedy");

			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);

			// start a transaction
			session.beginTransaction();

			// save the instructor
			System.out.println("saving instructor: " + tempInstructor);
			session.save(tempInstructor); // also saves detail object due to cascade

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("done!");
		} finally {
			factory.close();
		}

	}

}
