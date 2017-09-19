package com.mindtree.restful.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mindtree.restful.util.Address;
import com.mindtree.restful.util.DataBaseUtils;
import com.mindtree.restful.util.Employee;

public class EmployeeDAO {

	public void addEmployee(Employee emp) {
		Session session = DataBaseUtils.getSession();
		Transaction tx = session.beginTransaction();
		session.save(emp);
		tx.commit();
		session.close();

	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {
		Session session = DataBaseUtils.getSession();
		List<Employee> employees =(List<Employee>) session.createQuery("from Employee").list();
		System.out.println(employees);
		session.close();
		return employees;
	}

	public Employee getEmployee(int id) {

		Session session = DataBaseUtils.getSession();

		Employee employee = (Employee) session.get(Employee.class, id);
		System.out.println(employee);
		session.close();
		return employee;
	}

	public int deleteEmployee(int id) {
		Session session = DataBaseUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		String hql = "delete from Employee where id = :id";
		
		Query query = session.createQuery(hql);
		query.setInteger("id", id);
		int rowCount = query.executeUpdate();
		
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		
		session.close();
		return rowCount;
	}

	public int updateEmployee(int id, Employee emp) {
		if (id <= 0)
			return 0;
		Session session = DataBaseUtils.getSession();
		Transaction tx = session.beginTransaction();
		Employee employee=new Employee();
		 employee.setId(id);
		 employee.setName(emp.getName());
		 employee.setDesignation(emp.getDesignation());
		 employee.setSalary(emp.getSalary());
		 
		 Address address=new Address();
		 address.setId(emp.getAddress().getId());
		 address.setDoorNo(emp.getAddress().getDoorNo());
		 address.setCity(emp.getAddress().getCity());
		 address.setLocation(emp.getAddress().getLocation());
		 address.setStreet(emp.getAddress().getStreet());
		 System.out.println(address);
		 employee.setAddress(address);
		
		session.update(employee);

		tx.commit();
		session.close();
		return 1;
	}

}
