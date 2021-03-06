package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class DeleteEmployeeDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			int employeeId = 1;

			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve employee based on the id: primary key
			System.out.println("\nGetting employee with id: " + employeeId);

			Employee myEmployee = session.get(Employee.class, employeeId);
			System.out.println("Updating student...");
			myEmployee.setFirstName("Chris"); // at this point only updated in memory

			// commit the transaction
			session.getTransaction().commit(); // updated in database

			// New Code
			// create session
			session = factory.getCurrentSession();
			session.beginTransaction();

			// update company for all employees
			System.out.println("update company for all employees...");
			session.createQuery("update Employee set company='Target'").executeUpdate();

			// commit the transaction
			session.getTransaction().commit(); // updated in database

			System.out.println("done!");

		} finally {
			factory.close();
		}

	}

}

//Practice Activity #8 - Hibernate Development
//Section 21, Lecture 200
//Practice Activity #8 - Hibernate Development
//
// 
//
//Overview
//
//Create an app using Hibernate to read/write data to database table. Here is the database table design:
//
//Table: Employee
//
//Columns
//- first_name : varchar
//- last_name: varchar
//- company : varchar
//
//
//Steps You Must Complete 
//
//Create the database table.
//Set up the Hibernate configuration file.
//Create a Java class (entity) with Hibernate annotations.
//Develop a main application.
//Develop code to save objects.
//Develop code to retrieve an object by primary key.
//Develop code to query objects to find employees for a given company.
//Develop code to delete an object by primary key.
//  
//
//  The application should use the same style and approach as shown in the videos. 
//
//
