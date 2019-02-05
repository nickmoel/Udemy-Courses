package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class ReadEmployeeDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create a student object
			System.out.println("creating a new Employee object...");
			Employee tempEmployee = new Employee("Daffy", "duck", "daffy@luv2code.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("saving Employee...");
			System.out.println(tempEmployee);

			session.save(tempEmployee);

			// commit the transaction
			session.getTransaction().commit();

			// my new code

			// find out the Employee id: primary key
			System.out.println("saved Employee. generated id " + tempEmployee.getId());

			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve Employee based on the id: primary key
			System.out.println("\nGetting Employee with id: " + tempEmployee.getId());

			Employee myEmployee = session.get(Employee.class, tempEmployee.getId());
			System.out.println("get complete: " + myEmployee);

			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("done!");
			
		} finally {
			factory.close();
		}

	}

}
