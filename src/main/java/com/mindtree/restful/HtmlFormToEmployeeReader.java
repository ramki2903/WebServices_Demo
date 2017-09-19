package com.mindtree.restful;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

import com.mindtree.restful.util.Employee;

@Provider
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public class HtmlFormToEmployeeReader implements MessageBodyReader<Employee>{

	public boolean isReadable(Class<?> arg0, Type arg1, Annotation[] arg2,
			MediaType arg3) {
		// TODO Auto-generated method stub
		return true;
	}

	public Employee readFrom(Class<Employee> clz, Type type,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> headers, InputStream in)
			throws IOException, WebApplicationException {
		// TODO Auto-generated method stub
		System.out.println("readFrom");
		BufferedReader br=new BufferedReader(new  InputStreamReader(in));
		String line=br.readLine();
		Map<String, String> paramMap=converToMap(line);
		Employee employee=new Employee();
		employee.setName(paramMap.get("name"));
		employee.setDesignation(paramMap.get("designation"));
		employee.setSalary(Double.parseDouble(paramMap.get("salary")));
		employee.getAddress().setDoorNo(Integer.parseInt(paramMap.get("doorNo")));
		employee.getAddress().setStreet(paramMap.get("street"));
		employee.getAddress().setLocation(paramMap.get("location"));
		employee.getAddress().setCity(paramMap.get("city"));
		return employee;
	}

	private Map<String, String> converToMap(String line) {
		// TODO Auto-generated method stub
		String[] parameters=line.split("&");
		Map<String, String> paramMap=new HashMap<String, String>();
		for(String parameter:parameters){
			String[] keyValue=parameter.split("=");
			String key=keyValue[0];
			try {
				String value=URLDecoder.decode(keyValue[1],"UTF-8");
				paramMap.put(key, value);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return paramMap;
	}

}
