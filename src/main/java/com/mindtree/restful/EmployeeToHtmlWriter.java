package com.mindtree.restful;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import com.mindtree.restful.util.Employee;


@Provider
@Produces(MediaType.TEXT_HTML)
public class EmployeeToHtmlWriter implements MessageBodyWriter<Employee>{

	public long getSize(Employee arg0, Class<?> arg1, Type arg2,
			Annotation[] arg3, MediaType arg4) {
		// TODO Auto-generated method stub
		return -1;
	}

	public boolean isWriteable(Class<?> arg0, Type arg1, Annotation[] arg2,
			MediaType arg3) {
		// TODO Auto-generated method stub
		return true;
	}

	public void writeTo(Employee employee, Class<?> clz, Type type,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> headers, OutputStream out)
			throws IOException, WebApplicationException {
		
		// TODO Auto-generated method stub
		String resp="<html><body><h2>";
		resp+="Employee Id: "+employee.getId();
		resp+="<br>Name: "+employee.getName();
		resp+="<br>Designation: "+employee.getDesignation();
		resp+="<br>Salary: "+employee.getSalary();
		resp+="<br>DoorNo: "+employee.getAddress().getDoorNo();
		resp+="<br>Street: "+employee.getAddress().getStreet();
		resp+="<br>Location: "+employee.getAddress().getLocation();
		resp+="<br>City: "+employee.getAddress().getCity();
		resp+="</h2></body></html>";
		
		
		out.write(resp.getBytes());
		
	}

}
