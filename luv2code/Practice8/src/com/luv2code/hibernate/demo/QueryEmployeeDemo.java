package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class QueryEmployeeDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// query students
			List<Employee> theEmployees = session.createQuery("from Employee").list();

			// display the Employee
			displayEmployees(theEmployees);

			// query students: lastName='Arthur'
			theEmployees = session.createQuery("from Employee s where s.lastName='Arthur'").list();

			// display the students
			System.out.println("\n\nEmployees who have lastName of Arthur: " + theEmployees);
			displayEmployees(theEmployees);

			// query Employees: lastName='Arthur' OR firstName='Daffy'
			theEmployees = session.createQuery("from Employee s where s.lastName='Arthur' OR s.firstName='Daffy'").list();

			// display the Employees
			System.out.println("\n\nEmployees who have lastName of Arthur or firstName of Daffy: " + theEmployees);
			displayEmployees(theEmployees);

			// query students: where company like Target
			theEmployees = session.createQuery("from Employee s where s.company LIKE '%Target'").list();

			// display the Employees
			System.out.println("\n\nEmployees who work for Target: " + theEmployees);
			displayEmployees(theEmployees);

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("done!");
		} finally {
			factory.close();
		}

	}

	private static void displayEmployees(List<Employee> theEmployees) { // made from refactor>extract method on Query
																		// Students method
		for (Employee tempEmployee : theEmployees) {
			System.out.println(tempEmployee);
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