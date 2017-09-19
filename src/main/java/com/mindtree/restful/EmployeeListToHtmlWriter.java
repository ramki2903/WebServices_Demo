package com.mindtree.restful;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import com.mindtree.restful.util.Employee;

@Provider
@Produces(MediaType.TEXT_HTML)
public class EmployeeListToHtmlWriter implements MessageBodyWriter<List<Employee>> {

	@Override
	public long getSize(List<Employee> arg0, Class<?> arg1, Type arg2, Annotation[] arg3, MediaType arg4) {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public boolean isWriteable(Class<?> arg0, Type arg1, Annotation[] arg2, MediaType arg3) {
		// TODO Auto-generated method stub
		return true;
	}

	
	public void writeTo(List<Employee> emp, Class<?> clz, Type type,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> headers, OutputStream out)
			throws IOException, WebApplicationException { 
				// TODO Auto-generated method stub
		String resp="<html><body><table border=1>";
		resp+="<tr><th>Employee Id</th><th>Name</th><th>Designation</th><th>Salary</th><th>DoorNo</th><th>Street</th><th>Location</th><th>City</th>";
		for(Employee employee:emp){
			resp+="<tr>";
			resp+="<td>"+employee.getId()+"</td>";
			resp+="<td>"+employee.getName()+"</td>";
			resp+="<td>"+employee.getDesignation()+"</td>";
			resp+="<td>"+employee.getSalary()+"</td>";
			resp+="<td>"+employee.getAddress().getDoorNo()+"</td>";
			resp+="<td>"+employee.getAddress().getStreet()+"</td>";
			resp+="<td>"+employee.getAddress().getLocation()+"</td>";
			resp+="<td>"+employee.getAddress().getCity()+"</td>";
			resp+="</tr>";
			
		}
		resp+="</table></body></html>";
		out.write(resp.getBytes());
	}

}
