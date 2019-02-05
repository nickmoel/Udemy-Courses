package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create 3 student objects
			System.out.println("creating 3 Employee objects...");
			Employee tempEmployee1 = new Employee("John", "Candy", "Bayer");
			Employee tempEmployee2 = new Employee("Bill", "Murray", "Bayer");
			Employee tempEmployee3 = new Employee("Bea", "Arthur", "Bayer");


			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("saving Employee object...");
			session.save(tempEmployee1);
			session.save(tempEmployee2);
			session.save(tempEmployee3);

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("done!");
		} finally {
			factory.close();
		}

	}

}
