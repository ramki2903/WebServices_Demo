package com.mindtree.restful;

import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.mindtree.restful.dao.EmployeeDAO;
import com.mindtree.restful.util.Address;
import com.mindtree.restful.util.Employee;



/**
 * m1032230
 */
@Path("/employee")
@Singleton
public class EmployeeResource {

   
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_FORM_URLENCODED})
    public List<Employee> getAllEmployee() {
		
        EmployeeDAO dao = new EmployeeDAO();
        List<Employee> employees = dao.getAllEmployees();
        
        for(Employee emp:employees)
        	
        {
        	System.out.println(emp.getName()+"  "+emp.getAddress().getCity());
        }
        return employees;
        
    }
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_FORM_URLENCODED})
    public Employee getEmployee(@PathParam("id") int id) {
		
        EmployeeDAO dao = new EmployeeDAO();
        Employee employee = dao.getEmployee(id);
            System.out.println(employee);    
       /* return Response.status(Status.OK).entity(employee).build();*/
        return employee;
    }
    
    @POST
    @Path("/addEmployee")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_FORM_URLENCODED})
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_FORM_URLENCODED})
    public String addEmployee(Employee employee){
        
    	Employee emp = new Employee();
    	String name= employee.getName();
    	String designation= employee.getDesignation();
    	double salary=employee.getSalary();
    	Address address=employee.getAddress();
    	
    	emp.setName(name);
    	emp.setDesignation(designation);
    	emp.setSalary(salary);
    	emp.setAddress(address);
        EmployeeDAO dao = new EmployeeDAO();
        dao.addEmployee(emp);
        
        return "Employee details added successfully";
    }
    
    @PUT
    @Path("/update/{id}")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_FORM_URLENCODED})
    public Response updateEmployee(@PathParam("id") int id, Employee emp){
        EmployeeDAO dao = new EmployeeDAO();
        int count = dao.updateEmployee(id, emp);
        if(count==0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.status(Status.OK).build();
    }
    
    @DELETE
    @Path("/delete/{id}")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_FORM_URLENCODED})
    public Response deleteEmployee(@PathParam("id") int id){
        EmployeeDAO dao = new EmployeeDAO();
        int count = dao.deleteEmployee(id);
        if(count==0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }
}
