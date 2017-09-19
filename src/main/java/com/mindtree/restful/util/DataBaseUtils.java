package com.mindtree.restful.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class DataBaseUtils {

	  public static Session getSession(){
        Session session =  getSessionFactory().openSession();
        
        return session;
    }
    
    private static final SessionFactory sessionFactory ;
    
   	static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
        	sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
           

        } catch (Throwable ex) {
			System.err.println("Session Factory could not be created." + ex);
			throw new ExceptionInInitializerError(ex);
		}	
    }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
   
}
