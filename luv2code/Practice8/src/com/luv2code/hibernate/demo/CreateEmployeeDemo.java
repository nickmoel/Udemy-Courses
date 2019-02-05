package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class CreateEmployeeDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create a employee object
			System.out.println("creating a new employee object...");
			Employee tempEmployee = new Employee("Paul", "Blart", "Walmart");

			// start a transaction
			session.beginTransaction();

			// save the employee object
			System.out.println("saving employee object...");
			session.save(tempEmployee);

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("done!");
		} finally {
			factory.close();
		}

	}

}
