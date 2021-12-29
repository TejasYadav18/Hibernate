package com.DemoProject.HibernateDemo;


	

	import java.util.Date;

	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.Transaction;
	import org.hibernate.boot.registry.StandardServiceRegistry;
	import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
	import org.hibernate.cfg.Configuration;
	import org.hibernate.service.ServiceRegistry;

	public class App {

	    static User userObj;
	    static Session sessionObj;
	    static SessionFactory sessionFactoryObj;
	    private static StandardServiceRegistry registry;
	    private static SessionFactory sessionFactory;


	    public static void main(String[] args) {
	        System.out.println(".......Hibernate Maven Example.......\n");
	        Transaction transaction = null;
	      
	            Configuration cf=new Configuration();
	            cf.configure();
	            SessionFactory sf =cf.buildSessionFactory();
	            Session  session=sf.openSession();
	            Transaction t=session.beginTransaction();
	            
	            for(int i = 1; i <= 5; i++) {
	                userObj = new User();
	                userObj.setUserid(i);
	                userObj.setUsername("Editor " + i);
	                userObj.setCreatedBy("Administrator");
	                userObj.setCreatedDate(new Date());

	                session.save(userObj);
	            }
	            System.out.println("\n.......Records Saved Successfully To The Database.......\n");

	            // Committing The Transactions To The Database
	            t.commit();


	    }
	}